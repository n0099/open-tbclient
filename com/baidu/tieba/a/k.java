package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.game.GameInfoData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public static com.baidu.tbadk.core.a.c a(com.baidu.tbadk.core.a.c cVar) {
        com.baidu.tbadk.core.a.c cVar2;
        String[] XY;
        if (cVar == null) {
            return null;
        }
        try {
            XY = XY();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (XY != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", XZ()));
            arrayList.add(new BasicNameValuePair("cert_id", XY[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, cVar.xh);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, cVar.OF);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.m411getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m411getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.e().Q(XY[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", b(arrayList, TbConfig.PassConfig.ENC_KEY)));
            aa aaVar = new aa(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            aaVar.sp().tp().mIsNeedAddCommenParam = false;
            aaVar.sp().tp().mIsUseCurrentBDUSS = false;
            aaVar.o(arrayList);
            aaVar.sp().tp().ts().Wr = true;
            aaVar.sp().tp().ts().mIsBaiduServer = false;
            String rO = aaVar.rO();
            if (aaVar.sp().tq().pv() && !bd.isEmpty(rO)) {
                JSONObject jSONObject2 = new JSONObject(rO);
                if (GameInfoData.NOT_FROM_DETAIL.equals(jSONObject2.optString("errno"))) {
                    cVar2 = new com.baidu.tbadk.core.a.c();
                    cVar2.xh = jSONObject2.optString(SapiAccountManager.SESSION_BDUSS);
                    cVar2.OF = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                    cVar2.mUsername = jSONObject2.optString("uname");
                    return cVar2;
                }
            }
            cVar2 = null;
            return cVar2;
        }
        return null;
    }

    private static String[] XY() {
        try {
            aa aaVar = new aa(TbConfig.PassConfig.GET_CERT_URL);
            aaVar.sp().tp().mIsNeedAddCommenParam = false;
            aaVar.sp().tp().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(aaVar.rP()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String XZ() {
        if (com.baidu.adp.lib.util.k.iI()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m411getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
    }

    private static String b(ArrayList<BasicNameValuePair> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(arrayList.get(i).getName());
            hashMap.put(arrayList.get(i).getName(), arrayList.get(i).getValue());
        }
        Collections.sort(arrayList2);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            stringBuffer.append(str2);
            stringBuffer.append("=");
            try {
                String str3 = (String) hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(URLEncoder.encode(str3, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return ab.toMd5(stringBuffer.toString());
    }
}
