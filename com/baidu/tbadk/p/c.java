package com.baidu.tbadk.p;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.StringU;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
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
    /* renamed from: d */
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
            d(httpMessage);
        }
        if (tbHttpMessageTask.isNeedAddCommenParam()) {
            c(httpMessage, tbHttpMessageTask);
            c(httpMessage);
        }
        if (tbHttpMessageTask.isNeedAddStatisticsParam()) {
            f(httpMessage);
        }
        if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST && tbHttpMessageTask.isBaiduServer()) {
            e(httpMessage);
        }
    }

    private void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        boolean z = true;
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader(Headers.ACCEPT_ENCODING, "gzip");
        } else {
            httpMessage.addHeader(Headers.ACCEPT_ENCODING, "");
        }
        httpMessage.addHeader("Charset", "UTF-8");
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
        if (!NetDeleteSwitch.isOn()) {
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
            httpMessage.addParam("apid", "sw");
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
        httpMessage.addParam("net_type", String.valueOf(j.netType()));
        String aSm = w.aSm();
        if (!TextUtils.isEmpty(aSm)) {
            httpMessage.addParam("oaid", aSm);
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
        if (com.baidu.tbadk.coreExtra.b.a.aIV().aIW()) {
            httpMessage.addCookie("pub_env", String.valueOf(com.baidu.tbadk.coreExtra.b.a.aIV().aIX()));
        }
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            httpMessage.addCookie("pub_env", TbSingleton.getInstance().getPubEnvValue());
        }
        if (1 == j.netType()) {
            if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                httpMessage.addCookie("ka", "open");
            }
        } else if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
            httpMessage.addCookie("ka", "open");
        }
        httpMessage.addCookie("TBBRAND", Build.MODEL);
        httpMessage.addCookie("CUID", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addCookie("BAIDUZID", FH.gz(TbadkCoreApplication.getInst()));
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        if (!TextUtils.isEmpty(cuidGalaxy2)) {
            httpMessage.addCookie("BAIDUCUID", new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
        }
    }

    private void d(HttpMessage httpMessage) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null) {
            httpMessage.addParam("BDUSS", currentBduss);
            String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
            if (!StringUtils.isNull(c)) {
                httpMessage.addParam("stoken", c);
            }
        }
    }

    private void e(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && !"sign".equals(key)) {
                    stringBuffer.append(key + ETAG.EQUAL);
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam("sign", s.toMd5(stringBuffer.toString()));
        if (httpMessage.getHeaders() != null && "1".equals(httpMessage.getHeaders().get("needSig")) && EncSigNewSwitch.isOn()) {
            httpMessage.addParam("sig", StringU.wo(stringBuffer.toString()));
        }
        httpMessage.getHeaders().remove("needSig");
    }

    private void f(HttpMessage httpMessage) {
        aa.a aGl = aa.aGl();
        if (aGl != null) {
            httpMessage.addParam("stTime", String.valueOf(aGl.mTime));
            httpMessage.addParam("stSize", String.valueOf(aGl.mSize));
            httpMessage.addParam("stTimesNum", String.valueOf(aGl.mTimesNum));
            httpMessage.addParam("stMode", String.valueOf(aGl.mMode));
            httpMessage.addParam("stMethod", String.valueOf(aGl.mMethod));
        }
        int errorNumsAndSet = aa.getErrorNumsAndSet(0);
        if (errorNumsAndSet == 0 && aGl != null) {
            errorNumsAndSet = aGl.mTimesNum;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(errorNumsAndSet));
    }
}
