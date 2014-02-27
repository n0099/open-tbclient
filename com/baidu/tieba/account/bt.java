package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class bt {
    public static o a(o oVar) {
        o oVar2;
        String[] a;
        if (oVar == null) {
            return null;
        }
        try {
            a = a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
        }
        if (a != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", SocialConstants.TRUE));
            arrayList.add(new BasicNameValuePair("tpl", "tb"));
            arrayList.add(new BasicNameValuePair("appid", SocialConstants.TRUE));
            arrayList.add(new BasicNameValuePair("clientip", com.baidu.adp.lib.network.i.a() ? UtilHelper.i(TiebaApplication.g().b()) : UtilHelper.c()));
            arrayList.add(new BasicNameValuePair("cert_id", a[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", oVar.a);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, oVar.b);
            jSONObject.put(SocialConstants.PARAM_CUID, DeviceId.getDeviceID(TiebaApplication.g().b()));
            jSONObject.put("clientid", TiebaApplication.g().k());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tieba.util.ac().a(a[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", a(arrayList, "6e93e7659ae637845c7f83abee68a740")));
            com.baidu.tieba.util.bf.a();
            com.baidu.tieba.util.an a2 = com.baidu.tieba.util.bf.a(new com.baidu.tieba.util.bj());
            if (a2 != null) {
                a2.b("http://passport.baidu.com/v2/sapi/bdusslogin");
                a2.a(arrayList);
                a2.a((Boolean) true);
                a2.e(false);
                String u = a2.u();
                if (a2.p() && !com.baidu.tieba.util.bs.c(u)) {
                    JSONObject jSONObject2 = new JSONObject(u);
                    if (SocialConstants.FALSE.equals(jSONObject2.optString("errno"))) {
                        oVar2 = new o();
                        oVar2.a = jSONObject2.optString("bduss");
                        oVar2.b = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                        oVar2.c = jSONObject2.optString("uname");
                        return oVar2;
                    }
                }
                oVar2 = null;
                return oVar2;
            }
            return null;
        }
        return null;
    }

    private static String[] a() {
        try {
            com.baidu.tieba.util.bf.a();
            com.baidu.tieba.util.an a = com.baidu.tieba.util.bf.a(new com.baidu.tieba.util.bj());
            if (a == null) {
                return null;
            }
            a.b("http://passport.baidu.com/sslcrypt/get_last_cert");
            JSONObject jSONObject = new JSONObject(new String(a.w()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(ArrayList<BasicNameValuePair> arrayList, String str) {
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
                com.baidu.adp.lib.util.e.b(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return com.baidu.tieba.util.ax.a(stringBuffer.toString());
    }
}
