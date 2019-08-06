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
    public String dcA;
    public boolean dcB;
    public String dct;
    public String dcv;
    public d dcw;
    public d dcx;
    public d dcy;
    public String dcz;
    public String id;
    public String userName;

    public static b bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.dct = jSONObject.optString("phone");
        bVar.dcv = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.dcw = d.bg(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.dcx = d.bg(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.dcy = d.bg(optJSONObject3);
        }
        bVar.dcz = jSONObject.optString("street");
        bVar.dcA = jSONObject.optString("zipcode");
        bVar.dcB = TextUtils.equals(jSONObject.optString(NotifyAdapterUtil.PRIMARY_CHANNEL), "1");
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
            bVar.dct = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.dcz = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.dcA = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.dcw = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.dcx = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.dcy = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.dct)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aFa())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.dcz) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.dct)) {
                jSONObject.put("phone", bVar.dct);
            }
            if (!TextUtils.isEmpty(bVar.dcv)) {
                jSONObject.put("phone_cipher", bVar.dcv);
            }
            JSONObject a = d.a(bVar.dcw);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.dcx);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.dcy);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.dcz)) {
                jSONObject.put("street", bVar.dcz);
            }
            if (!TextUtils.isEmpty(bVar.dcA)) {
                jSONObject.put("zipcode", bVar.dcA);
            }
            jSONObject.put(NotifyAdapterUtil.PRIMARY_CHANNEL, bVar.dcB);
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
            if (!TextUtils.isEmpty(bVar.dcA)) {
                jSONObject.put("postalCode", bVar.dcA);
            }
            if (bVar.dcw != null && !TextUtils.isEmpty(bVar.dcw.name)) {
                jSONObject.put("provinceName", bVar.dcw.name);
            }
            if (bVar.dcx != null && !TextUtils.isEmpty(bVar.dcx.name)) {
                jSONObject.put("cityName", bVar.dcx.name);
            }
            if (bVar.dcy != null && !TextUtils.isEmpty(bVar.dcy.name)) {
                jSONObject.put("countyName", bVar.dcy.name);
            }
            if (bVar.dcy != null && !TextUtils.isEmpty(bVar.dcy.code)) {
                jSONObject.put("nationalCode", bVar.dcy.code);
            }
            if (!TextUtils.isEmpty(bVar.dcz)) {
                jSONObject.put("detailInfo", bVar.dcz);
            }
            if (!TextUtils.isEmpty(bVar.dct)) {
                jSONObject.put("telNumber", bVar.dct);
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
        a aVar2 = new a("联系电话", bVar.dct, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.dcs = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aFa(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.dcz, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.dcA, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.dcs = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aFa() {
        StringBuilder sb = new StringBuilder();
        if (this.dcw != null && !TextUtils.isEmpty(this.dcw.name)) {
            sb.append(this.dcw.name);
        }
        if (this.dcx != null && !TextUtils.isEmpty(this.dcx.name)) {
            sb.append(" " + this.dcx.name);
        }
        if (this.dcy != null && !TextUtils.isEmpty(this.dcy.name)) {
            sb.append(" " + this.dcy.name);
        }
        return sb.toString();
    }

    public String aFb() {
        StringBuilder sb = new StringBuilder();
        sb.append(aFa());
        sb.append(" " + this.dcz);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.dct) || TextUtils.isEmpty(aFa()) || TextUtils.isEmpty(this.dcz) || this.dct.length() != 11 || !this.dct.startsWith("1")) ? false : true;
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
            if (!TextUtils.isEmpty(bVar.dct)) {
                this.dct = bVar.dct;
            }
            if (!TextUtils.isEmpty(bVar.dcv)) {
                this.dcv = bVar.dcv;
            }
            if (!TextUtils.isEmpty(bVar.dcz)) {
                this.dcz = bVar.dcz;
            }
            if (!TextUtils.isEmpty(bVar.dcA)) {
                this.dcA = bVar.dcA;
            }
            if (bVar.dcw != null && bVar.dcw.isValid()) {
                this.dcw = bVar.dcw;
            }
            if (bVar.dcx != null && bVar.dcx.isValid()) {
                this.dcx = bVar.dcx;
            }
            if (bVar.dcy != null && bVar.dcy.isValid()) {
                this.dcy = bVar.dcy;
            }
        }
    }

    public static boolean sW(String str) {
        return str.length() == 6 && sX(str);
    }

    public static boolean sX(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aFc() {
        if (sV(this.dct)) {
            this.dcv = this.dct.substring(0, 3) + "*****" + this.dct.substring(8);
        }
    }
}
