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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String cSq;
    public String cSr;
    public d cSs;
    public d cSt;
    public d cSu;
    public String cSv;
    public String cSw;
    public boolean cSx;
    public String id;
    public String userName;

    public static b aT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cSq = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.cSr = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.cSs = d.aU(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.cSt = d.aU(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cSu = d.aU(optJSONObject3);
        }
        bVar.cSv = jSONObject.optString("street");
        bVar.cSw = jSONObject.optString("zipcode");
        bVar.cSx = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.cSq = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.cSv = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.cSw = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.cSs = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.cSt = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cSu = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.cSq)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.ayx())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cSv) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cSq)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.cSq);
            }
            if (!TextUtils.isEmpty(bVar.cSr)) {
                jSONObject.put("phone_cipher", bVar.cSr);
            }
            JSONObject a = d.a(bVar.cSs);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.cSt);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cSu);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cSv)) {
                jSONObject.put("street", bVar.cSv);
            }
            if (!TextUtils.isEmpty(bVar.cSw)) {
                jSONObject.put("zipcode", bVar.cSw);
            }
            jSONObject.put("default", bVar.cSx);
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
            if (!TextUtils.isEmpty(bVar.cSw)) {
                jSONObject.put("postalCode", bVar.cSw);
            }
            if (bVar.cSs != null && !TextUtils.isEmpty(bVar.cSs.name)) {
                jSONObject.put("provinceName", bVar.cSs.name);
            }
            if (bVar.cSt != null && !TextUtils.isEmpty(bVar.cSt.name)) {
                jSONObject.put("cityName", bVar.cSt.name);
            }
            if (bVar.cSu != null && !TextUtils.isEmpty(bVar.cSu.name)) {
                jSONObject.put("countyName", bVar.cSu.name);
            }
            if (bVar.cSu != null && !TextUtils.isEmpty(bVar.cSu.code)) {
                jSONObject.put("nationalCode", bVar.cSu.code);
            }
            if (!TextUtils.isEmpty(bVar.cSv)) {
                jSONObject.put("detailInfo", bVar.cSv);
            }
            if (!TextUtils.isEmpty(bVar.cSq)) {
                jSONObject.put("telNumber", bVar.cSq);
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
        a aVar2 = new a("联系电话", bVar.cSq, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.cSp = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.ayx(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cSv, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.cSw, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cSp = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String ayx() {
        StringBuilder sb = new StringBuilder();
        if (this.cSs != null && !TextUtils.isEmpty(this.cSs.name)) {
            sb.append(this.cSs.name);
        }
        if (this.cSt != null && !TextUtils.isEmpty(this.cSt.name)) {
            sb.append(" " + this.cSt.name);
        }
        if (this.cSu != null && !TextUtils.isEmpty(this.cSu.name)) {
            sb.append(" " + this.cSu.name);
        }
        return sb.toString();
    }

    public String ayy() {
        StringBuilder sb = new StringBuilder();
        sb.append(ayx());
        sb.append(" " + this.cSv);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cSq) || TextUtils.isEmpty(ayx()) || TextUtils.isEmpty(this.cSv) || this.cSq.length() != 11 || !this.cSq.startsWith("1")) ? false : true;
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
            if (!TextUtils.isEmpty(bVar.cSq)) {
                this.cSq = bVar.cSq;
            }
            if (!TextUtils.isEmpty(bVar.cSr)) {
                this.cSr = bVar.cSr;
            }
            if (!TextUtils.isEmpty(bVar.cSv)) {
                this.cSv = bVar.cSv;
            }
            if (!TextUtils.isEmpty(bVar.cSw)) {
                this.cSw = bVar.cSw;
            }
            if (bVar.cSs != null && bVar.cSs.isValid()) {
                this.cSs = bVar.cSs;
            }
            if (bVar.cSt != null && bVar.cSt.isValid()) {
                this.cSt = bVar.cSt;
            }
            if (bVar.cSu != null && bVar.cSu.isValid()) {
                this.cSu = bVar.cSu;
            }
        }
    }

    public static boolean ru(String str) {
        return str.length() == 6 && rv(str);
    }

    public static boolean rv(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void ayz() {
        if (rt(this.cSq)) {
            this.cSr = this.cSq.substring(0, 3) + "*****" + this.cSq.substring(8);
        }
    }
}
