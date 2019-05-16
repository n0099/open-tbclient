package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String daM;
    public String daN;
    public d daO;
    public d daP;
    public d daQ;
    public String daR;
    public String daS;
    public boolean daT;
    public String id;
    public String userName;

    public static b bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.daM = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.daN = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.daO = d.bg(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.daP = d.bg(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.daQ = d.bg(optJSONObject3);
        }
        bVar.daR = jSONObject.optString("street");
        bVar.daS = jSONObject.optString("zipcode");
        bVar.daT = TextUtils.equals(jSONObject.optString(NotifyAdapterUtil.PRIMARY_CHANNEL), "1");
        return bVar;
    }

    public static b r(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        b bVar = new b();
        if (map.containsKey("id")) {
            bVar.id = String.valueOf(map.get("id"));
        }
        if (map.containsKey("name")) {
            bVar.userName = String.valueOf(map.get("name"));
        }
        if (map.containsKey(ISapiAccount.SAPI_ACCOUNT_PHONE)) {
            bVar.daM = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.daR = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.daS = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.daO = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.daP = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.daQ = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.daM)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aDF())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.daR) ? false : true));
        }
        return hashMap;
    }

    public static JSONObject c(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(bVar.id)) {
                jSONObject.put("id", bVar.id);
            }
            if (!TextUtils.isEmpty(bVar.userName)) {
                jSONObject.put("name", bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.daM)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.daM);
            }
            if (!TextUtils.isEmpty(bVar.daN)) {
                jSONObject.put("phone_cipher", bVar.daN);
            }
            JSONObject a = d.a(bVar.daO);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.daP);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.daQ);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.daR)) {
                jSONObject.put("street", bVar.daR);
            }
            if (!TextUtils.isEmpty(bVar.daS)) {
                jSONObject.put("zipcode", bVar.daS);
            }
            jSONObject.put(NotifyAdapterUtil.PRIMARY_CHANNEL, bVar.daT);
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static JSONObject d(b bVar) {
        if (bVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.userName)) {
                jSONObject.put("userName", bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.daS)) {
                jSONObject.put("postalCode", bVar.daS);
            }
            if (bVar.daO != null && !TextUtils.isEmpty(bVar.daO.name)) {
                jSONObject.put("provinceName", bVar.daO.name);
            }
            if (bVar.daP != null && !TextUtils.isEmpty(bVar.daP.name)) {
                jSONObject.put("cityName", bVar.daP.name);
            }
            if (bVar.daQ != null && !TextUtils.isEmpty(bVar.daQ.name)) {
                jSONObject.put("countyName", bVar.daQ.name);
            }
            if (bVar.daQ != null && !TextUtils.isEmpty(bVar.daQ.code)) {
                jSONObject.put("nationalCode", bVar.daQ.code);
            }
            if (!TextUtils.isEmpty(bVar.daR)) {
                jSONObject.put("detailInfo", bVar.daR);
            }
            if (!TextUtils.isEmpty(bVar.daM)) {
                jSONObject.put("telNumber", bVar.daM);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    public static List<a> e(b bVar) {
        if (bVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a aVar = new a("收货人", bVar.userName, "姓名");
        aVar.type = "name";
        arrayList.add(aVar);
        a aVar2 = new a("联系电话", bVar.daM, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.daL = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aDF(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.daR, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.daS, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.daL = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aDF() {
        StringBuilder sb = new StringBuilder();
        if (this.daO != null && !TextUtils.isEmpty(this.daO.name)) {
            sb.append(this.daO.name);
        }
        if (this.daP != null && !TextUtils.isEmpty(this.daP.name)) {
            sb.append(" " + this.daP.name);
        }
        if (this.daQ != null && !TextUtils.isEmpty(this.daQ.name)) {
            sb.append(" " + this.daQ.name);
        }
        return sb.toString();
    }

    public String aDG() {
        StringBuilder sb = new StringBuilder();
        sb.append(aDF());
        sb.append(" " + this.daR);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.daM) || TextUtils.isEmpty(aDF()) || TextUtils.isEmpty(this.daR) || this.daM.length() != 11 || !this.daM.startsWith("1")) ? false : true;
    }

    public static boolean sD(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return sF(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.daM)) {
                this.daM = bVar.daM;
            }
            if (!TextUtils.isEmpty(bVar.daN)) {
                this.daN = bVar.daN;
            }
            if (!TextUtils.isEmpty(bVar.daR)) {
                this.daR = bVar.daR;
            }
            if (!TextUtils.isEmpty(bVar.daS)) {
                this.daS = bVar.daS;
            }
            if (bVar.daO != null && bVar.daO.isValid()) {
                this.daO = bVar.daO;
            }
            if (bVar.daP != null && bVar.daP.isValid()) {
                this.daP = bVar.daP;
            }
            if (bVar.daQ != null && bVar.daQ.isValid()) {
                this.daQ = bVar.daQ;
            }
        }
    }

    public static boolean sE(String str) {
        return str.length() == 6 && sF(str);
    }

    public static boolean sF(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aDH() {
        if (sD(this.daM)) {
            this.daN = this.daM.substring(0, 3) + "*****" + this.daM.substring(8);
        }
    }
}
