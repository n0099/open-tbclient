package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
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
    public String dcm;
    public String dcn;
    public d dco;
    public d dcp;
    public d dcq;
    public String dcr;
    public String dcs;
    public boolean dct;
    public String id;
    public String userName;

    public static b bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.dcm = jSONObject.optString("phone");
        bVar.dcn = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.dco = d.bg(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.dcp = d.bg(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.dcq = d.bg(optJSONObject3);
        }
        bVar.dcr = jSONObject.optString("street");
        bVar.dcs = jSONObject.optString("zipcode");
        bVar.dct = TextUtils.equals(jSONObject.optString(NotifyAdapterUtil.PRIMARY_CHANNEL), "1");
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
        if (map.containsKey("phone")) {
            bVar.dcm = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.dcr = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.dcs = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.dco = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.dcp = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.dcq = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.dcm)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aEY())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.dcr) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.dcm)) {
                jSONObject.put("phone", bVar.dcm);
            }
            if (!TextUtils.isEmpty(bVar.dcn)) {
                jSONObject.put("phone_cipher", bVar.dcn);
            }
            JSONObject a = d.a(bVar.dco);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.dcp);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.dcq);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.dcr)) {
                jSONObject.put("street", bVar.dcr);
            }
            if (!TextUtils.isEmpty(bVar.dcs)) {
                jSONObject.put("zipcode", bVar.dcs);
            }
            jSONObject.put(NotifyAdapterUtil.PRIMARY_CHANNEL, bVar.dct);
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
            if (!TextUtils.isEmpty(bVar.dcs)) {
                jSONObject.put("postalCode", bVar.dcs);
            }
            if (bVar.dco != null && !TextUtils.isEmpty(bVar.dco.name)) {
                jSONObject.put("provinceName", bVar.dco.name);
            }
            if (bVar.dcp != null && !TextUtils.isEmpty(bVar.dcp.name)) {
                jSONObject.put("cityName", bVar.dcp.name);
            }
            if (bVar.dcq != null && !TextUtils.isEmpty(bVar.dcq.name)) {
                jSONObject.put("countyName", bVar.dcq.name);
            }
            if (bVar.dcq != null && !TextUtils.isEmpty(bVar.dcq.code)) {
                jSONObject.put("nationalCode", bVar.dcq.code);
            }
            if (!TextUtils.isEmpty(bVar.dcr)) {
                jSONObject.put("detailInfo", bVar.dcr);
            }
            if (!TextUtils.isEmpty(bVar.dcm)) {
                jSONObject.put("telNumber", bVar.dcm);
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
        a aVar2 = new a("联系电话", bVar.dcm, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.dcl = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aEY(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.dcr, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.dcs, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.dcl = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aEY() {
        StringBuilder sb = new StringBuilder();
        if (this.dco != null && !TextUtils.isEmpty(this.dco.name)) {
            sb.append(this.dco.name);
        }
        if (this.dcp != null && !TextUtils.isEmpty(this.dcp.name)) {
            sb.append(" " + this.dcp.name);
        }
        if (this.dcq != null && !TextUtils.isEmpty(this.dcq.name)) {
            sb.append(" " + this.dcq.name);
        }
        return sb.toString();
    }

    public String aEZ() {
        StringBuilder sb = new StringBuilder();
        sb.append(aEY());
        sb.append(" " + this.dcr);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.dcm) || TextUtils.isEmpty(aEY()) || TextUtils.isEmpty(this.dcr) || this.dcm.length() != 11 || !this.dcm.startsWith("1")) ? false : true;
    }

    public static boolean sV(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return sX(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.dcm)) {
                this.dcm = bVar.dcm;
            }
            if (!TextUtils.isEmpty(bVar.dcn)) {
                this.dcn = bVar.dcn;
            }
            if (!TextUtils.isEmpty(bVar.dcr)) {
                this.dcr = bVar.dcr;
            }
            if (!TextUtils.isEmpty(bVar.dcs)) {
                this.dcs = bVar.dcs;
            }
            if (bVar.dco != null && bVar.dco.isValid()) {
                this.dco = bVar.dco;
            }
            if (bVar.dcp != null && bVar.dcp.isValid()) {
                this.dcp = bVar.dcp;
            }
            if (bVar.dcq != null && bVar.dcq.isValid()) {
                this.dcq = bVar.dcq;
            }
        }
    }

    public static boolean sW(String str) {
        return str.length() == 6 && sX(str);
    }

    public static boolean sX(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aFa() {
        if (sV(this.dcm)) {
            this.dcn = this.dcm.substring(0, 3) + "*****" + this.dcm.substring(8);
        }
    }
}
