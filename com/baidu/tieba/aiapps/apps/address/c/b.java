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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public String cSs;
    public String cSt;
    public d cSu;
    public d cSv;
    public d cSw;
    public String cSx;
    public String cSy;
    public boolean cSz;
    public String id;
    public String userName;

    public static b aT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cSs = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.cSt = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.cSu = d.aU(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.cSv = d.aU(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cSw = d.aU(optJSONObject3);
        }
        bVar.cSx = jSONObject.optString("street");
        bVar.cSy = jSONObject.optString("zipcode");
        bVar.cSz = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.cSs = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.cSx = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.cSy = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.cSu = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.cSv = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cSw = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.cSs)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.ayA())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cSx) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cSs)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.cSs);
            }
            if (!TextUtils.isEmpty(bVar.cSt)) {
                jSONObject.put("phone_cipher", bVar.cSt);
            }
            JSONObject a = d.a(bVar.cSu);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.cSv);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cSw);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cSx)) {
                jSONObject.put("street", bVar.cSx);
            }
            if (!TextUtils.isEmpty(bVar.cSy)) {
                jSONObject.put("zipcode", bVar.cSy);
            }
            jSONObject.put("default", bVar.cSz);
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
            if (!TextUtils.isEmpty(bVar.cSy)) {
                jSONObject.put("postalCode", bVar.cSy);
            }
            if (bVar.cSu != null && !TextUtils.isEmpty(bVar.cSu.name)) {
                jSONObject.put("provinceName", bVar.cSu.name);
            }
            if (bVar.cSv != null && !TextUtils.isEmpty(bVar.cSv.name)) {
                jSONObject.put("cityName", bVar.cSv.name);
            }
            if (bVar.cSw != null && !TextUtils.isEmpty(bVar.cSw.name)) {
                jSONObject.put("countyName", bVar.cSw.name);
            }
            if (bVar.cSw != null && !TextUtils.isEmpty(bVar.cSw.code)) {
                jSONObject.put("nationalCode", bVar.cSw.code);
            }
            if (!TextUtils.isEmpty(bVar.cSx)) {
                jSONObject.put("detailInfo", bVar.cSx);
            }
            if (!TextUtils.isEmpty(bVar.cSs)) {
                jSONObject.put("telNumber", bVar.cSs);
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
        a aVar2 = new a("联系电话", bVar.cSs, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.cSr = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.ayA(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cSx, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.cSy, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cSr = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String ayA() {
        StringBuilder sb = new StringBuilder();
        if (this.cSu != null && !TextUtils.isEmpty(this.cSu.name)) {
            sb.append(this.cSu.name);
        }
        if (this.cSv != null && !TextUtils.isEmpty(this.cSv.name)) {
            sb.append(" " + this.cSv.name);
        }
        if (this.cSw != null && !TextUtils.isEmpty(this.cSw.name)) {
            sb.append(" " + this.cSw.name);
        }
        return sb.toString();
    }

    public String ayB() {
        StringBuilder sb = new StringBuilder();
        sb.append(ayA());
        sb.append(" " + this.cSx);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cSs) || TextUtils.isEmpty(ayA()) || TextUtils.isEmpty(this.cSx) || this.cSs.length() != 11 || !this.cSs.startsWith("1")) ? false : true;
    }

    public static boolean rt(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return rv(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.cSs)) {
                this.cSs = bVar.cSs;
            }
            if (!TextUtils.isEmpty(bVar.cSt)) {
                this.cSt = bVar.cSt;
            }
            if (!TextUtils.isEmpty(bVar.cSx)) {
                this.cSx = bVar.cSx;
            }
            if (!TextUtils.isEmpty(bVar.cSy)) {
                this.cSy = bVar.cSy;
            }
            if (bVar.cSu != null && bVar.cSu.isValid()) {
                this.cSu = bVar.cSu;
            }
            if (bVar.cSv != null && bVar.cSv.isValid()) {
                this.cSv = bVar.cSv;
            }
            if (bVar.cSw != null && bVar.cSw.isValid()) {
                this.cSw = bVar.cSw;
            }
        }
    }

    public static boolean ru(String str) {
        return str.length() == 6 && rv(str);
    }

    public static boolean rv(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void ayC() {
        if (rt(this.cSs)) {
            this.cSt = this.cSs.substring(0, 3) + "*****" + this.cSs.substring(8);
        }
    }
}
