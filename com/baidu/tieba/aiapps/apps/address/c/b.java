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
    public String bCL;
    public String bCM;
    public d bCN;
    public d bCO;
    public d bCP;
    public String bCQ;
    public String bCR;
    public boolean bCS;
    public String id;
    public String userName;

    public static b J(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.bCL = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
        bVar.bCM = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.bCN = d.K(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.bCO = d.K(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.bCP = d.K(optJSONObject3);
        }
        bVar.bCQ = jSONObject.optString("street");
        bVar.bCR = jSONObject.optString("zipcode");
        bVar.bCS = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.bCL = String.valueOf(map.get(ISapiAccount.SAPI_ACCOUNT_PHONE));
        }
        if (map.containsKey("street")) {
            bVar.bCQ = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.bCR = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.bCN = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.bCO = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.bCP = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PHONE, Boolean.valueOf(!TextUtils.isEmpty(bVar.bCL)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.WU())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.bCQ) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.bCL)) {
                jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PHONE, bVar.bCL);
            }
            if (!TextUtils.isEmpty(bVar.bCM)) {
                jSONObject.put("phone_cipher", bVar.bCM);
            }
            JSONObject a = d.a(bVar.bCN);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.bCO);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.bCP);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.bCQ)) {
                jSONObject.put("street", bVar.bCQ);
            }
            if (!TextUtils.isEmpty(bVar.bCR)) {
                jSONObject.put("zipcode", bVar.bCR);
            }
            jSONObject.put("default", bVar.bCS);
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
            if (!TextUtils.isEmpty(bVar.bCR)) {
                jSONObject.put("postalCode", bVar.bCR);
            }
            if (bVar.bCN != null && !TextUtils.isEmpty(bVar.bCN.name)) {
                jSONObject.put("provinceName", bVar.bCN.name);
            }
            if (bVar.bCO != null && !TextUtils.isEmpty(bVar.bCO.name)) {
                jSONObject.put("cityName", bVar.bCO.name);
            }
            if (bVar.bCP != null && !TextUtils.isEmpty(bVar.bCP.name)) {
                jSONObject.put("countyName", bVar.bCP.name);
            }
            if (bVar.bCP != null && !TextUtils.isEmpty(bVar.bCP.code)) {
                jSONObject.put("nationalCode", bVar.bCP.code);
            }
            if (!TextUtils.isEmpty(bVar.bCQ)) {
                jSONObject.put("detailInfo", bVar.bCQ);
            }
            if (!TextUtils.isEmpty(bVar.bCL)) {
                jSONObject.put("telNumber", bVar.bCL);
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
        a aVar2 = new a("联系电话", bVar.bCL, "手机号码或座机");
        aVar2.type = ISapiAccount.SAPI_ACCOUNT_PHONE;
        aVar2.bCK = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.WU(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.bCQ, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.bCR, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.bCK = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String WU() {
        StringBuilder sb = new StringBuilder();
        if (this.bCN != null && !TextUtils.isEmpty(this.bCN.name)) {
            sb.append(this.bCN.name);
        }
        if (this.bCO != null && !TextUtils.isEmpty(this.bCO.name)) {
            sb.append(" " + this.bCO.name);
        }
        if (this.bCP != null && !TextUtils.isEmpty(this.bCP.name)) {
            sb.append(" " + this.bCP.name);
        }
        return sb.toString();
    }

    public String WV() {
        StringBuilder sb = new StringBuilder();
        sb.append(WU());
        sb.append(" " + this.bCQ);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.bCL) || TextUtils.isEmpty(WU()) || TextUtils.isEmpty(this.bCQ) || this.bCL.length() != 11 || !this.bCL.startsWith("1")) ? false : true;
    }

    public static boolean ka(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return kc(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.bCL)) {
                this.bCL = bVar.bCL;
            }
            if (!TextUtils.isEmpty(bVar.bCM)) {
                this.bCM = bVar.bCM;
            }
            if (!TextUtils.isEmpty(bVar.bCQ)) {
                this.bCQ = bVar.bCQ;
            }
            if (!TextUtils.isEmpty(bVar.bCR)) {
                this.bCR = bVar.bCR;
            }
            if (bVar.bCN != null && bVar.bCN.isValid()) {
                this.bCN = bVar.bCN;
            }
            if (bVar.bCO != null && bVar.bCO.isValid()) {
                this.bCO = bVar.bCO;
            }
            if (bVar.bCP != null && bVar.bCP.isValid()) {
                this.bCP = bVar.bCP;
            }
        }
    }

    public static boolean kb(String str) {
        return str.length() == 6 && kc(str);
    }

    public static boolean kc(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void WW() {
        if (ka(this.bCL)) {
            this.bCM = this.bCL.substring(0, 3) + "*****" + this.bCL.substring(8);
        }
    }
}
