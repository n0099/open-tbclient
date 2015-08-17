package com.baidu.tbadk.e;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.t;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.httpNet.h;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.a.d {
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
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
        e(httpMessage);
        if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST && tbHttpMessageTask.isBaiduServer()) {
            d(httpMessage);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        boolean z = true;
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader("Accept-Encoding", "gzip");
        } else {
            httpMessage.addHeader("Accept-Encoding", "");
        }
        httpMessage.addHeader("Charset", "UTF-8");
        httpMessage.addHeader("User-Agent", "bdtb for Android " + TbConfig.getVersion());
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
        }
        String netType = h.getNetType();
        if (!TextUtils.isEmpty(netType)) {
            httpMessage.addHeader("net", netType);
        }
        if (!TextUtils.isEmpty(netType)) {
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (!z) {
                    httpMessage.addHeader("Connection", "Keep-Alive");
                } else {
                    httpMessage.addHeader("Connection", IntentConfig.CLOSE);
                }
            } else if (!z) {
            }
        }
        httpMessage.addHeader("client_logid", String.valueOf(httpMessage.getClientLogID()));
        httpMessage.addHeader(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
    }

    private void c(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", "2");
        if (!TbadkCoreApplication.m411getInst().isOfficial()) {
            httpMessage.addParam("apid", TbConfig.SW_APID);
        }
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
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
        String netType = h.getNetType();
        if (netType != null) {
            String wn = com.baidu.tbadk.coreExtra.a.a.wl().wn();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m411getInst().getKeepaliveWifi() == 1) {
                    wn = String.valueOf(wn) + "ka=open";
                }
            } else if (TbadkCoreApplication.m411getInst().getKeepaliveNonWifi() == 1) {
                wn = String.valueOf(wn) + "ka=open";
            }
            httpMessage.addHeader("Cookie", wn);
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkCoreApplication.m411getInst().getTbs());
        }
        httpMessage.addParam(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
        httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
        httpMessage.addParam("model", Build.MODEL);
    }

    private void c(HttpMessage httpMessage) {
        String currentBduss = TbadkCoreApplication.getCurrentBduss();
        if (currentBduss != null) {
            httpMessage.addParam("BDUSS", currentBduss);
        }
    }

    private void d(HttpMessage httpMessage) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
        for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
            Map.Entry<String, Object> entry = encodeInBackGround.get(i);
            if (entry != null) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    stringBuffer.append(String.valueOf(key) + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam(SapiUtils.KEY_QR_LOGIN_SIGN, t.toMd5(stringBuffer.toString()));
    }

    private void e(HttpMessage httpMessage) {
        z.a un = z.un();
        if (un != null) {
            httpMessage.addParam("stTime", String.valueOf(un.mTime));
            httpMessage.addParam("stSize", String.valueOf(un.mSize));
            httpMessage.addParam("stTimesNum", String.valueOf(un.aaj));
            httpMessage.addParam("stMode", String.valueOf(un.mMode));
            httpMessage.addParam("stMethod", String.valueOf(un.aai));
        }
        int ch = z.ch(0);
        if (ch == 0 && un != null) {
            ch = un.aaj;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(ch));
    }
}
