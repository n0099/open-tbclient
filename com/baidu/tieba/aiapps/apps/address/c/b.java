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
    public String bGe;
    public String bGf;
    public d bGg;
    public d bGh;
    public d bGi;
    public String bGj;
    public String bGk;
    public boolean bGl;
    public String id;
    public String userName;

    public static b K(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bGe = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.bGf = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bGg = d.L(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bGh = d.L(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bGi = d.L(optJSONObject3);
        }
        bVar.bGj = jSONObject.optString("street");
        bVar.bGk = jSONObject.optString("zipcode");
        bVar.bGl = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.bGe = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.bGj = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bGk = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bGg = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bGh = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bGi = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.bGe)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.XX())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bGj) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bGe)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bGe);
            }
            if (!TextUtils.isEmpty(bVar.bGf)) {
                jSONObject.put("phone_cipher", bVar.bGf);
            }
            JSONObject a = d.a(bVar.bGg);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bGh);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bGi);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bGj)) {
                jSONObject.put("street", bVar.bGj);
            }
            if (!TextUtils.isEmpty(bVar.bGk)) {
                jSONObject.put("zipcode", bVar.bGk);
            }
            jSONObject.put("default", bVar.bGl);
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
            if (!TextUtils.isEmpty(bVar.bGk)) {
                jSONObject.put("postalCode", bVar.bGk);
            }
            if (bVar.bGg != null && !TextUtils.isEmpty(bVar.bGg.name)) {
                jSONObject.put("provinceName", bVar.bGg.name);
            }
            if (bVar.bGh != null && !TextUtils.isEmpty(bVar.bGh.name)) {
                jSONObject.put("cityName", bVar.bGh.name);
            }
            if (bVar.bGi != null && !TextUtils.isEmpty(bVar.bGi.name)) {
                jSONObject.put("countyName", bVar.bGi.name);
            }
            if (bVar.bGi != null && !TextUtils.isEmpty(bVar.bGi.code)) {
                jSONObject.put("nationalCode", bVar.bGi.code);
            }
            if (!TextUtils.isEmpty(bVar.bGj)) {
                jSONObject.put("detailInfo", bVar.bGj);
            }
            if (!TextUtils.isEmpty(bVar.bGe)) {
                jSONObject.put("telNumber", bVar.bGe);
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
        a aVar2 = new a("联系电话", bVar.bGe, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.bGd = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.XX(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bGj, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bGk, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bGd = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String XX() {
        StringBuilder sb = new StringBuilder();
        if (this.bGg != null && !TextUtils.isEmpty(this.bGg.name)) {
            sb.append(this.bGg.name);
        }
        if (this.bGh != null && !TextUtils.isEmpty(this.bGh.name)) {
            sb.append(" " + this.bGh.name);
        }
        if (this.bGi != null && !TextUtils.isEmpty(this.bGi.name)) {
            sb.append(" " + this.bGi.name);
        }
        return sb.toString();
    }

    public String XY() {
        StringBuilder sb = new StringBuilder();
        sb.append(XX());
        sb.append(" " + this.bGj);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bGe) || TextUtils.isEmpty(XX()) || TextUtils.isEmpty(this.bGj) || this.bGe.length() != 11 || !this.bGe.startsWith("1")) ? false : true;
    }

    public static boolean ks(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return ku(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bGe)) {
                this.bGe = bVar.bGe;
            }
            if (!TextUtils.isEmpty(bVar.bGf)) {
                this.bGf = bVar.bGf;
            }
            if (!TextUtils.isEmpty(bVar.bGj)) {
                this.bGj = bVar.bGj;
            }
            if (!TextUtils.isEmpty(bVar.bGk)) {
                this.bGk = bVar.bGk;
            }
            if (bVar.bGg != null && bVar.bGg.isValid()) {
                this.bGg = bVar.bGg;
            }
            if (bVar.bGh != null && bVar.bGh.isValid()) {
                this.bGh = bVar.bGh;
            }
            if (bVar.bGi != null && bVar.bGi.isValid()) {
                this.bGi = bVar.bGi;
            }
        }
    }

    public static boolean kt(String str) {
        return str.length() == 6 && ku(str);
    }

    public static boolean ku(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void XZ() {
        if (ks(this.bGe)) {
            this.bGf = this.bGe.substring(0, 3) + "*****" + this.bGe.substring(8);
        }
    }
}
