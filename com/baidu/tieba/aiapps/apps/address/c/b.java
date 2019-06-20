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
    public String daO;
    public String daP;
    public d daQ;
    public d daR;
    public d daS;
    public String daT;
    public String daU;
    public boolean daV;
    public String id;
    public String userName;

    public static b bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.daO = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.daP = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.daQ = d.bg(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.daR = d.bg(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.daS = d.bg(optJSONObject3);
        }
        bVar.daT = jSONObject.optString("street");
        bVar.daU = jSONObject.optString("zipcode");
        bVar.daV = TextUtils.equals(jSONObject.optString(NotifyAdapterUtil.PRIMARY_CHANNEL), "1");
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
            bVar.daO = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.daT = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.daU = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.daQ = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.daR = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.daS = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.daO)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aDI())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.daT) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.daO)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.daO);
            }
            if (!TextUtils.isEmpty(bVar.daP)) {
                jSONObject.put("phone_cipher", bVar.daP);
            }
            JSONObject a = d.a(bVar.daQ);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.daR);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.daS);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.daT)) {
                jSONObject.put("street", bVar.daT);
            }
            if (!TextUtils.isEmpty(bVar.daU)) {
                jSONObject.put("zipcode", bVar.daU);
            }
            jSONObject.put(NotifyAdapterUtil.PRIMARY_CHANNEL, bVar.daV);
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
            if (!TextUtils.isEmpty(bVar.daU)) {
                jSONObject.put("postalCode", bVar.daU);
            }
            if (bVar.daQ != null && !TextUtils.isEmpty(bVar.daQ.name)) {
                jSONObject.put("provinceName", bVar.daQ.name);
            }
            if (bVar.daR != null && !TextUtils.isEmpty(bVar.daR.name)) {
                jSONObject.put("cityName", bVar.daR.name);
            }
            if (bVar.daS != null && !TextUtils.isEmpty(bVar.daS.name)) {
                jSONObject.put("countyName", bVar.daS.name);
            }
            if (bVar.daS != null && !TextUtils.isEmpty(bVar.daS.code)) {
                jSONObject.put("nationalCode", bVar.daS.code);
            }
            if (!TextUtils.isEmpty(bVar.daT)) {
                jSONObject.put("detailInfo", bVar.daT);
            }
            if (!TextUtils.isEmpty(bVar.daO)) {
                jSONObject.put("telNumber", bVar.daO);
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
        a aVar2 = new a("联系电话", bVar.daO, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.daN = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aDI(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.daT, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.daU, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.daN = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aDI() {
        StringBuilder sb = new StringBuilder();
        if (this.daQ != null && !TextUtils.isEmpty(this.daQ.name)) {
            sb.append(this.daQ.name);
        }
        if (this.daR != null && !TextUtils.isEmpty(this.daR.name)) {
            sb.append(" " + this.daR.name);
        }
        if (this.daS != null && !TextUtils.isEmpty(this.daS.name)) {
            sb.append(" " + this.daS.name);
        }
        return sb.toString();
    }

    public String aDJ() {
        StringBuilder sb = new StringBuilder();
        sb.append(aDI());
        sb.append(" " + this.daT);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.daO) || TextUtils.isEmpty(aDI()) || TextUtils.isEmpty(this.daT) || this.daO.length() != 11 || !this.daO.startsWith("1")) ? false : true;
    }

    public static boolean sC(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return sE(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.daO)) {
                this.daO = bVar.daO;
            }
            if (!TextUtils.isEmpty(bVar.daP)) {
                this.daP = bVar.daP;
            }
            if (!TextUtils.isEmpty(bVar.daT)) {
                this.daT = bVar.daT;
            }
            if (!TextUtils.isEmpty(bVar.daU)) {
                this.daU = bVar.daU;
            }
            if (bVar.daQ != null && bVar.daQ.isValid()) {
                this.daQ = bVar.daQ;
            }
            if (bVar.daR != null && bVar.daR.isValid()) {
                this.daR = bVar.daR;
            }
            if (bVar.daS != null && bVar.daS.isValid()) {
                this.daS = bVar.daS;
            }
        }
    }

    public static boolean sD(String str) {
        return str.length() == 6 && sE(str);
    }

    public static boolean sE(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aDK() {
        if (sC(this.daO)) {
            this.daP = this.daO.substring(0, 3) + "*****" + this.daO.substring(8);
        }
    }
}
