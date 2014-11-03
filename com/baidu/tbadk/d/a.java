package com.baidu.tbadk.d;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.stats.p;
import com.baidu.adp.lib.util.u;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.httpNet.j;
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

    private void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
            httpMessage.addHeader("Accept-Encoding", "gzip");
        }
        httpMessage.addHeader("Charset", "UTF-8");
        httpMessage.addHeader("User-Agent", "bdtb for Android " + TbConfig.getVersion());
        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
            httpMessage.addHeader("client_user_token", TbadkApplication.getCurrentAccount());
        }
        String eK = p.eK();
        if (!TextUtils.isEmpty(eK)) {
            httpMessage.addHeader("sid", eK);
        }
        String netType = j.getNetType();
        if (!TextUtils.isEmpty(netType)) {
            httpMessage.addHeader("net", netType);
        }
    }

    private void c(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        httpMessage.addParam("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        if (!TbadkApplication.m251getInst().isOfficial()) {
            httpMessage.addParam("apid", TbConfig.SW_APID);
        }
        httpMessage.addParam("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m251getInst().getImei() != null) {
            httpMessage.addParam("_phone_imei", TbadkApplication.m251getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            httpMessage.addParam("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            httpMessage.addParam("from", from);
        }
        String netType = j.getNetType();
        if (netType != null) {
            String ot = com.baidu.tbadk.coreExtra.a.a.or().ot();
            if (TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equalsIgnoreCase(netType)) {
                if (TbadkApplication.m251getInst().getKeepaliveWifi() == 1) {
                    ot = String.valueOf(ot) + "ka=open";
                }
            } else if (TbadkApplication.m251getInst().getKeepaliveNonWifi() == 1) {
                ot = String.valueOf(ot) + "ka=open";
            }
            httpMessage.addHeader("Cookie", ot);
        }
        if (tbHttpMessageTask.isNeedTbs()) {
            httpMessage.addParam("tbs", TbadkApplication.m251getInst().getTbs());
        }
        httpMessage.addParam("cuid", TbadkApplication.m251getInst().getCuid());
        httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
        httpMessage.addParam("model", Build.MODEL);
    }

    private void c(HttpMessage httpMessage) {
        String currentBduss = TbadkApplication.getCurrentBduss();
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
        httpMessage.addParam(SapiUtils.KEY_QR_LOGIN_SIGN, u.aE(stringBuffer.toString()));
    }

    private void e(HttpMessage httpMessage) {
        ao mv = an.mv();
        if (mv != null) {
            httpMessage.addParam("stTime", String.valueOf(mv.mTime));
            httpMessage.addParam("stSize", String.valueOf(mv.mSize));
            httpMessage.addParam("stTimesNum", String.valueOf(mv.EK));
            httpMessage.addParam("stMode", String.valueOf(mv.mMode));
            httpMessage.addParam("stMethod", String.valueOf(mv.EJ));
        }
        int bv = an.bv(0);
        if (bv == 0 && mv != null) {
            bv = mv.EK;
        }
        httpMessage.addParam("stErrorNums", String.valueOf(bv));
    }
}
