package com.baidu.tbadk.m;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.o.ag;
import com.baidu.tbadk.task.TbHttpMessageTask;
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
        httpMessage.addHeader("Charset", "UTF-8");
        String userAgent = httpMessage.getUserAgent();
        if (TextUtils.isEmpty(userAgent)) {
            httpMessage.addHeader(HTTP.USER_AGENT, "bdtb for Android " + TbConfig.getVersion());
        } else {
            httpMessage.addHeader(HTTP.USER_AGENT, userAgent);
        }
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
        }
        int jJ = j.jJ();
        if (!ag.ip()) {
            httpMessage.addHeader("net", String.valueOf(jJ));
        }
        if (1 != jJ ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() != 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() != 1) {
            z = false;
        }
        if (z) {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            httpMessage.addHeader(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
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
        int jJ = j.jJ();
        httpMessage.addParam("net_type", String.valueOf(jJ));
        if (com.baidu.tbadk.coreExtra.b.a.BH().BI()) {
            httpMessage.addCookie("pub_env", String.valueOf(com.baidu.tbadk.coreExtra.b.a.BH().BJ()));
        }
        if (1 == jJ) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                httpMessage.addCookie("ka", TbConfig.ST_TYPE_OPEN);
            }
        } else if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
            httpMessage.addCookie("ka", TbConfig.ST_TYPE_OPEN);
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        }
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addParam("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        httpMessage.addParam(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
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
                if ((value instanceof String) && !"sign".equals(key)) {
                    stringBuffer.append(key + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam("sign", s.bl(stringBuffer.toString()));
    }

    private void d(HttpMessage httpMessage) {
        ab.a zi = ab.zi();
        if (zi != null) {
            httpMessage.addParam("stTime", String.valueOf(zi.mTime));
            httpMessage.addParam("stSize", String.valueOf(zi.aqm));
            httpMessage.addParam("stTimesNum", String.valueOf(zi.aqn));
            httpMessage.addParam("stMode", String.valueOf(zi.mMode));
            httpMessage.addParam("stMethod", String.valueOf(zi.aql));
        }
        int cH = ab.cH(0);
        if (cH == 0 && zi != null) {
            cH = zi.aqn;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(cH));
    }
}
