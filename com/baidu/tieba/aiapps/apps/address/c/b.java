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
    public String bGh;
    public String bGi;
    public d bGj;
    public d bGk;
    public d bGl;
    public String bGm;
    public String bGn;
    public boolean bGo;
    public String id;
    public String userName;

    public static b K(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bGh = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.bGi = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bGj = d.L(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bGk = d.L(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bGl = d.L(optJSONObject3);
        }
        bVar.bGm = jSONObject.optString("street");
        bVar.bGn = jSONObject.optString("zipcode");
        bVar.bGo = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.bGh = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.bGm = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bGn = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bGj = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bGk = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bGl = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.bGh)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.XZ())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bGm) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bGh)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bGh);
            }
            if (!TextUtils.isEmpty(bVar.bGi)) {
                jSONObject.put("phone_cipher", bVar.bGi);
            }
            JSONObject a = d.a(bVar.bGj);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bGk);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bGl);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bGm)) {
                jSONObject.put("street", bVar.bGm);
            }
            if (!TextUtils.isEmpty(bVar.bGn)) {
                jSONObject.put("zipcode", bVar.bGn);
            }
            jSONObject.put("default", bVar.bGo);
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
            if (!TextUtils.isEmpty(bVar.bGn)) {
                jSONObject.put("postalCode", bVar.bGn);
            }
            if (bVar.bGj != null && !TextUtils.isEmpty(bVar.bGj.name)) {
                jSONObject.put("provinceName", bVar.bGj.name);
            }
            if (bVar.bGk != null && !TextUtils.isEmpty(bVar.bGk.name)) {
                jSONObject.put("cityName", bVar.bGk.name);
            }
            if (bVar.bGl != null && !TextUtils.isEmpty(bVar.bGl.name)) {
                jSONObject.put("countyName", bVar.bGl.name);
            }
            if (bVar.bGl != null && !TextUtils.isEmpty(bVar.bGl.code)) {
                jSONObject.put("nationalCode", bVar.bGl.code);
            }
            if (!TextUtils.isEmpty(bVar.bGm)) {
                jSONObject.put("detailInfo", bVar.bGm);
            }
            if (!TextUtils.isEmpty(bVar.bGh)) {
                jSONObject.put("telNumber", bVar.bGh);
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
        a aVar2 = new a("联系电话", bVar.bGh, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.bGg = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.XZ(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bGm, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bGn, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bGg = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String XZ() {
        StringBuilder sb = new StringBuilder();
        if (this.bGj != null && !TextUtils.isEmpty(this.bGj.name)) {
            sb.append(this.bGj.name);
        }
        if (this.bGk != null && !TextUtils.isEmpty(this.bGk.name)) {
            sb.append(" " + this.bGk.name);
        }
        if (this.bGl != null && !TextUtils.isEmpty(this.bGl.name)) {
            sb.append(" " + this.bGl.name);
        }
        return sb.toString();
    }

    public String Ya() {
        StringBuilder sb = new StringBuilder();
        sb.append(XZ());
        sb.append(" " + this.bGm);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bGh) || TextUtils.isEmpty(XZ()) || TextUtils.isEmpty(this.bGm) || this.bGh.length() != 11 || !this.bGh.startsWith("1")) ? false : true;
    }

    public static boolean kt(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return kv(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bGh)) {
                this.bGh = bVar.bGh;
            }
            if (!TextUtils.isEmpty(bVar.bGi)) {
                this.bGi = bVar.bGi;
            }
            if (!TextUtils.isEmpty(bVar.bGm)) {
                this.bGm = bVar.bGm;
            }
            if (!TextUtils.isEmpty(bVar.bGn)) {
                this.bGn = bVar.bGn;
            }
            if (bVar.bGj != null && bVar.bGj.isValid()) {
                this.bGj = bVar.bGj;
            }
            if (bVar.bGk != null && bVar.bGk.isValid()) {
                this.bGk = bVar.bGk;
            }
            if (bVar.bGl != null && bVar.bGl.isValid()) {
                this.bGl = bVar.bGl;
            }
        }
    }

    public static boolean ku(String str) {
        return str.length() == 6 && kv(str);
    }

    public static boolean kv(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void Yb() {
        if (kt(this.bGh)) {
            this.bGi = this.bGh.substring(0, 3) + "*****" + this.bGh.substring(8);
        }
    }
}
