package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String bGU;
    public String bGV;
    public d bGW;
    public d bGX;
    public d bGY;
    public String bGZ;
    public String bHa;
    public boolean bHb;
    public String id;
    public String userName;

    public static b K(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bGU = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.bGV = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bGW = d.L(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bGX = d.L(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bGY = d.L(optJSONObject3);
        }
        bVar.bGZ = jSONObject.optString("street");
        bVar.bHa = jSONObject.optString("zipcode");
        bVar.bHb = TextUtils.equals(jSONObject.optString("default"), "1");
        return bVar;
    }

    public static b q(Map<String, Object> map) {
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
            bVar.bGU = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.bGZ = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bHa = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bGW = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bGX = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bGY = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.bGU)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.Yw())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bGZ) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bGU)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bGU);
            }
            if (!TextUtils.isEmpty(bVar.bGV)) {
                jSONObject.put("phone_cipher", bVar.bGV);
            }
            JSONObject a = d.a(bVar.bGW);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bGX);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bGY);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bGZ)) {
                jSONObject.put("street", bVar.bGZ);
            }
            if (!TextUtils.isEmpty(bVar.bHa)) {
                jSONObject.put("zipcode", bVar.bHa);
            }
            jSONObject.put("default", bVar.bHb);
            return jSONObject;
        } catch (JSONException e) {
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
            if (!TextUtils.isEmpty(bVar.bHa)) {
                jSONObject.put("postalCode", bVar.bHa);
            }
            if (bVar.bGW != null && !TextUtils.isEmpty(bVar.bGW.name)) {
                jSONObject.put("provinceName", bVar.bGW.name);
            }
            if (bVar.bGX != null && !TextUtils.isEmpty(bVar.bGX.name)) {
                jSONObject.put("cityName", bVar.bGX.name);
            }
            if (bVar.bGY != null && !TextUtils.isEmpty(bVar.bGY.name)) {
                jSONObject.put("countyName", bVar.bGY.name);
            }
            if (bVar.bGY != null && !TextUtils.isEmpty(bVar.bGY.code)) {
                jSONObject.put("nationalCode", bVar.bGY.code);
            }
            if (!TextUtils.isEmpty(bVar.bGZ)) {
                jSONObject.put("detailInfo", bVar.bGZ);
            }
            if (!TextUtils.isEmpty(bVar.bGU)) {
                jSONObject.put("telNumber", bVar.bGU);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
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
        a aVar2 = new a("联系电话", bVar.bGU, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.bGT = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.Yw(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bGZ, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bHa, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bGT = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String Yw() {
        StringBuilder sb = new StringBuilder();
        if (this.bGW != null && !TextUtils.isEmpty(this.bGW.name)) {
            sb.append(this.bGW.name);
        }
        if (this.bGX != null && !TextUtils.isEmpty(this.bGX.name)) {
            sb.append(" " + this.bGX.name);
        }
        if (this.bGY != null && !TextUtils.isEmpty(this.bGY.name)) {
            sb.append(" " + this.bGY.name);
        }
        return sb.toString();
    }

    public String Yx() {
        StringBuilder sb = new StringBuilder();
        sb.append(Yw());
        sb.append(" " + this.bGZ);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bGU) || TextUtils.isEmpty(Yw()) || TextUtils.isEmpty(this.bGZ) || this.bGU.length() != 11 || !this.bGU.startsWith("1")) ? false : true;
    }

    public static boolean kJ(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return kL(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bGU)) {
                this.bGU = bVar.bGU;
            }
            if (!TextUtils.isEmpty(bVar.bGV)) {
                this.bGV = bVar.bGV;
            }
            if (!TextUtils.isEmpty(bVar.bGZ)) {
                this.bGZ = bVar.bGZ;
            }
            if (!TextUtils.isEmpty(bVar.bHa)) {
                this.bHa = bVar.bHa;
            }
            if (bVar.bGW != null && bVar.bGW.isValid()) {
                this.bGW = bVar.bGW;
            }
            if (bVar.bGX != null && bVar.bGX.isValid()) {
                this.bGX = bVar.bGX;
            }
            if (bVar.bGY != null && bVar.bGY.isValid()) {
                this.bGY = bVar.bGY;
            }
        }
    }

    public static boolean kK(String str) {
        return str.length() == 6 && kL(str);
    }

    public static boolean kL(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void Yy() {
        if (kJ(this.bGU)) {
            this.bGV = this.bGU.substring(0, 3) + "*****" + this.bGU.substring(8);
        }
    }
}
