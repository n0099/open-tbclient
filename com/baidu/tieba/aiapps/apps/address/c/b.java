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
    public String bBZ;
    public String bCa;
    public d bCb;
    public d bCc;
    public d bCd;
    public String bCe;
    public String bCf;
    public boolean bCg;
    public String id;
    public String userName;

    public static b J(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bBZ = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.bCa = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bCb = d.K(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bCc = d.K(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bCd = d.K(optJSONObject3);
        }
        bVar.bCe = jSONObject.optString("street");
        bVar.bCf = jSONObject.optString("zipcode");
        bVar.bCg = TextUtils.equals(jSONObject.optString("default"), "1");
        return bVar;
    }

    public static b n(Map<String, Object> map) {
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
            bVar.bBZ = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.bCe = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bCf = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bCb = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bCc = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bCd = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.bBZ)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.WK())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bCe) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bBZ)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bBZ);
            }
            if (!TextUtils.isEmpty(bVar.bCa)) {
                jSONObject.put("phone_cipher", bVar.bCa);
            }
            JSONObject a = d.a(bVar.bCb);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bCc);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bCd);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bCe)) {
                jSONObject.put("street", bVar.bCe);
            }
            if (!TextUtils.isEmpty(bVar.bCf)) {
                jSONObject.put("zipcode", bVar.bCf);
            }
            jSONObject.put("default", bVar.bCg);
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
            if (!TextUtils.isEmpty(bVar.bCf)) {
                jSONObject.put("postalCode", bVar.bCf);
            }
            if (bVar.bCb != null && !TextUtils.isEmpty(bVar.bCb.name)) {
                jSONObject.put("provinceName", bVar.bCb.name);
            }
            if (bVar.bCc != null && !TextUtils.isEmpty(bVar.bCc.name)) {
                jSONObject.put("cityName", bVar.bCc.name);
            }
            if (bVar.bCd != null && !TextUtils.isEmpty(bVar.bCd.name)) {
                jSONObject.put("countyName", bVar.bCd.name);
            }
            if (bVar.bCd != null && !TextUtils.isEmpty(bVar.bCd.code)) {
                jSONObject.put("nationalCode", bVar.bCd.code);
            }
            if (!TextUtils.isEmpty(bVar.bCe)) {
                jSONObject.put("detailInfo", bVar.bCe);
            }
            if (!TextUtils.isEmpty(bVar.bBZ)) {
                jSONObject.put("telNumber", bVar.bBZ);
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
        a aVar2 = new a("联系电话", bVar.bBZ, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.bBY = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.WK(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bCe, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bCf, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bBY = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String WK() {
        StringBuilder sb = new StringBuilder();
        if (this.bCb != null && !TextUtils.isEmpty(this.bCb.name)) {
            sb.append(this.bCb.name);
        }
        if (this.bCc != null && !TextUtils.isEmpty(this.bCc.name)) {
            sb.append(" " + this.bCc.name);
        }
        if (this.bCd != null && !TextUtils.isEmpty(this.bCd.name)) {
            sb.append(" " + this.bCd.name);
        }
        return sb.toString();
    }

    public String WL() {
        StringBuilder sb = new StringBuilder();
        sb.append(WK());
        sb.append(" " + this.bCe);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bBZ) || TextUtils.isEmpty(WK()) || TextUtils.isEmpty(this.bCe) || this.bBZ.length() != 11 || !this.bBZ.startsWith("1")) ? false : true;
    }

    public static boolean jY(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return ka(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bBZ)) {
                this.bBZ = bVar.bBZ;
            }
            if (!TextUtils.isEmpty(bVar.bCa)) {
                this.bCa = bVar.bCa;
            }
            if (!TextUtils.isEmpty(bVar.bCe)) {
                this.bCe = bVar.bCe;
            }
            if (!TextUtils.isEmpty(bVar.bCf)) {
                this.bCf = bVar.bCf;
            }
            if (bVar.bCb != null && bVar.bCb.isValid()) {
                this.bCb = bVar.bCb;
            }
            if (bVar.bCc != null && bVar.bCc.isValid()) {
                this.bCc = bVar.bCc;
            }
            if (bVar.bCd != null && bVar.bCd.isValid()) {
                this.bCd = bVar.bCd;
            }
        }
    }

    public static boolean jZ(String str) {
        return str.length() == 6 && ka(str);
    }

    public static boolean ka(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void WM() {
        if (jY(this.bBZ)) {
            this.bCa = this.bBZ.substring(0, 3) + "*****" + this.bBZ.substring(8);
        }
    }
}
