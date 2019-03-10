package com.baidu.tbadk.q;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.s.am;
import com.baidu.tbadk.s.t;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.StringU;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.a.d {
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
            TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
            a(httpMessage, tbHttpMessageTask);
            b(httpMessage, tbHttpMessageTask);
        }
        return httpMessage;
    }

    private void a(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        if (tbHttpMessageTask.isFromCDN()) {
            httpMessage.removeAllParams();
            return;
        }
        if (tbHttpMessageTask.isUseCurrentBDUSS()) {
            c(httpMessage);
        }
        if (tbHttpMessageTask.isNeedAddCommenParam()) {
            c(httpMessage, tbHttpMessageTask);
        }
        if (tbHttpMessageTask.isNeedAddStatisticsParam()) {
            d(httpMessage);
        }
        if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST && tbHttpMessageTask.isBaiduServer()) {
            addSign(httpMessage);
        }
    }

    private void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        boolean z = true;
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader("Accept-Encoding", "gzip");
        } else {
            httpMessage.addHeader("Accept-Encoding", "");
        }
        httpMessage.addHeader("Charset", HTTP.UTF_8);
        String userAgent = httpMessage.getUserAgent();
        if (TextUtils.isEmpty(userAgent)) {
            httpMessage.addHeader("User-Agent", "bdtb for Android " + TbConfig.getVersion());
        } else {
            httpMessage.addHeader("User-Agent", userAgent);
        }
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
        }
        int netType = j.netType();
        if (!am.jK()) {
            httpMessage.addHeader("net", String.valueOf(netType));
        }
        if (1 != netType ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() != 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() != 1) {
            z = false;
        }
        if (z) {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, "close");
        }
        httpMessage.addHeader("client_logid", String.valueOf(httpMessage.getClientLogID()));
        httpMessage.addHeader("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addHeader("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addHeader("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
    }

    private void c(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            httpMessage.addParam("apid", TbConfig.SW_APID);
        }
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            httpMessage.addParam("_client_id", clientId);
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            httpMessage.addParam("subapp_type", TbConfig.getSubappType());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            httpMessage.addParam("from", from);
        }
        int netType = j.netType();
        httpMessage.addParam("net_type", String.valueOf(netType));
        if (com.baidu.tbadk.coreExtra.b.a.afJ().afK()) {
            httpMessage.addCookie("pub_env", String.valueOf(com.baidu.tbadk.coreExtra.b.a.afJ().afL()));
        }
        if (1 == netType) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                httpMessage.addCookie("ka", "open");
            }
        } else if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
            httpMessage.addCookie("ka", "open");
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addParam("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
        httpMessage.addParam("model", Build.MODEL);
    }

    private void c(HttpMessage httpMessage) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null) {
            httpMessage.addParam("BDUSS", currentBduss);
            String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
            if (!StringUtils.isNull(c)) {
                httpMessage.addParam(ISapiAccount.SAPI_ACCOUNT_STOKEN, c);
            }
        }
    }

    private void addSign(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !SapiUtils.KEY_QR_LOGIN_SIGN.equals(key)) {
                    stringBuffer.append(key + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam(SapiUtils.KEY_QR_LOGIN_SIGN, s.bC(stringBuffer.toString()));
        if (httpMessage.getHeaders() != null && "1".equals(httpMessage.getHeaders().get("needSig")) && t.jK()) {
            httpMessage.addParam("sig", StringU.ql(stringBuffer.toString()));
        }
        httpMessage.getHeaders().remove("needSig");
    }

    private void d(HttpMessage httpMessage) {
        aa.a acS = aa.acS();
        if (acS != null) {
            httpMessage.addParam("stTime", String.valueOf(acS.mTime));
            httpMessage.addParam("stSize", String.valueOf(acS.aSN));
            httpMessage.addParam("stTimesNum", String.valueOf(acS.bJJ));
            httpMessage.addParam("stMode", String.valueOf(acS.mMode));
            httpMessage.addParam("stMethod", String.valueOf(acS.bJI));
        }
        int hg = aa.hg(0);
        if (hg == 0 && acS != null) {
            hg = acS.bJJ;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(hg));
    }
}
