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
    public String cSo;
    public String cSp;
    public d cSq;
    public d cSr;
    public d cSs;
    public String cSt;
    public String cSu;
    public boolean cSv;
    public String id;
    public String userName;

    public static b aT(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.cSo = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.cSp = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.cSq = d.aU(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.cSr = d.aU(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.cSs = d.aU(optJSONObject3);
        }
        bVar.cSt = jSONObject.optString("street");
        bVar.cSu = jSONObject.optString("zipcode");
        bVar.cSv = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.cSo = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.cSt = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.cSu = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.cSq = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.cSr = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.cSs = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.cSo)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.ayA())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.cSt) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.cSo)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.cSo);
            }
            if (!TextUtils.isEmpty(bVar.cSp)) {
                jSONObject.put("phone_cipher", bVar.cSp);
            }
            JSONObject a = d.a(bVar.cSq);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.cSr);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.cSs);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.cSt)) {
                jSONObject.put("street", bVar.cSt);
            }
            if (!TextUtils.isEmpty(bVar.cSu)) {
                jSONObject.put("zipcode", bVar.cSu);
            }
            jSONObject.put("default", bVar.cSv);
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
            if (!TextUtils.isEmpty(bVar.cSu)) {
                jSONObject.put("postalCode", bVar.cSu);
            }
            if (bVar.cSq != null && !TextUtils.isEmpty(bVar.cSq.name)) {
                jSONObject.put("provinceName", bVar.cSq.name);
            }
            if (bVar.cSr != null && !TextUtils.isEmpty(bVar.cSr.name)) {
                jSONObject.put("cityName", bVar.cSr.name);
            }
            if (bVar.cSs != null && !TextUtils.isEmpty(bVar.cSs.name)) {
                jSONObject.put("countyName", bVar.cSs.name);
            }
            if (bVar.cSs != null && !TextUtils.isEmpty(bVar.cSs.code)) {
                jSONObject.put("nationalCode", bVar.cSs.code);
            }
            if (!TextUtils.isEmpty(bVar.cSt)) {
                jSONObject.put("detailInfo", bVar.cSt);
            }
            if (!TextUtils.isEmpty(bVar.cSo)) {
                jSONObject.put("telNumber", bVar.cSo);
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
        a aVar2 = new a("联系电话", bVar.cSo, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.cSn = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.ayA(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.cSt, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.cSu, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.cSn = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String ayA() {
        StringBuilder sb = new StringBuilder();
        if (this.cSq != null && !TextUtils.isEmpty(this.cSq.name)) {
            sb.append(this.cSq.name);
        }
        if (this.cSr != null && !TextUtils.isEmpty(this.cSr.name)) {
            sb.append(" " + this.cSr.name);
        }
        if (this.cSs != null && !TextUtils.isEmpty(this.cSs.name)) {
            sb.append(" " + this.cSs.name);
        }
        return sb.toString();
    }

    public String ayB() {
        StringBuilder sb = new StringBuilder();
        sb.append(ayA());
        sb.append(" " + this.cSt);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.cSo) || TextUtils.isEmpty(ayA()) || TextUtils.isEmpty(this.cSt) || this.cSo.length() != 11 || !this.cSo.startsWith("1")) ? false : true;
    }

    public static boolean rs(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return ru(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.cSo)) {
                this.cSo = bVar.cSo;
            }
            if (!TextUtils.isEmpty(bVar.cSp)) {
                this.cSp = bVar.cSp;
            }
            if (!TextUtils.isEmpty(bVar.cSt)) {
                this.cSt = bVar.cSt;
            }
            if (!TextUtils.isEmpty(bVar.cSu)) {
                this.cSu = bVar.cSu;
            }
            if (bVar.cSq != null && bVar.cSq.isValid()) {
                this.cSq = bVar.cSq;
            }
            if (bVar.cSr != null && bVar.cSr.isValid()) {
                this.cSr = bVar.cSr;
            }
            if (bVar.cSs != null && bVar.cSs.isValid()) {
                this.cSs = bVar.cSs;
            }
        }
    }

    public static boolean rt(String str) {
        return str.length() == 6 && ru(str);
    }

    public static boolean ru(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void ayC() {
        if (rs(this.cSo)) {
            this.cSp = this.cSo.substring(0, 3) + "*****" + this.cSo.substring(8);
        }
    }
}
