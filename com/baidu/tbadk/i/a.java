package com.baidu.tbadk.i;

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
import com.baidu.tbadk.core.util.a.j;
import com.baidu.tbadk.core.util.af;
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
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
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
        String netType = j.getNetType();
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
        httpMessage.addHeader(SocialConstants.PARAM_CUID, TbadkCoreApplication.m10getInst().getCuid());
    }

    private void c(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", "2");
        if (!TbadkCoreApplication.m10getInst().isOfficial()) {
            httpMessage.addParam("apid", TbConfig.SW_APID);
        }
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m10getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkCoreApplication.m10getInst().getImei());
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
        String netType = j.getNetType();
        if (netType != null) {
            if (com.baidu.tbadk.coreExtra.b.a.wo().wp()) {
                httpMessage.addCookie("pub_env", String.valueOf(com.baidu.tbadk.coreExtra.b.a.wo().wq()));
            }
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkCoreApplication.m10getInst().getKeepaliveWifi() == 1) {
                    httpMessage.addCookie("ka", TbConfig.ST_TYPE_OPEN);
                }
            } else if (TbadkCoreApplication.m10getInst().getKeepaliveNonWifi() == 1) {
                httpMessage.addCookie("ka", TbConfig.ST_TYPE_OPEN);
            }
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkCoreApplication.m10getInst().getTbs());
        }
        httpMessage.addParam(SocialConstants.PARAM_CUID, TbadkCoreApplication.m10getInst().getCuid());
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
                if ((value instanceof String) && !SapiUtils.KEY_QR_LOGIN_SIGN.equals(key)) {
                    stringBuffer.append(String.valueOf(key) + "=");
                    stringBuffer.append(value);
                }
            }
        }
        stringBuffer.append("tiebaclient!!!");
        httpMessage.addParam(SapiUtils.KEY_QR_LOGIN_SIGN, t.aT(stringBuffer.toString()));
    }

    private void e(HttpMessage httpMessage) {
        af.a tH = af.tH();
        if (tH != null) {
            httpMessage.addParam("stTime", String.valueOf(tH.mTime));
            httpMessage.addParam("stSize", String.valueOf(tH.XP));
            httpMessage.addParam("stTimesNum", String.valueOf(tH.XQ));
            httpMessage.addParam("stMode", String.valueOf(tH.mMode));
            httpMessage.addParam("stMethod", String.valueOf(tH.XO));
        }
        int cr = af.cr(0);
        if (cr == 0 && tH != null) {
            cr = tH.XQ;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(cr));
    }
}
