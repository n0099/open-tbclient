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
    public String deg;
    public String deh;
    public d dei;
    public d dej;
    public d dek;
    public String del;
    public String dem;
    public boolean den;
    public String id;
    public String userName;

    public static b bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.deg = jSONObject.optString("phone");
        bVar.deh = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.dei = d.bg(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.dej = d.bg(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.dek = d.bg(optJSONObject3);
        }
        bVar.del = jSONObject.optString("street");
        bVar.dem = jSONObject.optString("zipcode");
        bVar.den = TextUtils.equals(jSONObject.optString(NotifyAdapterUtil.PRIMARY_CHANNEL), "1");
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
            bVar.deg = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.del = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.dem = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.dei = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.dej = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.dek = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.deg)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aFE())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.del) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.deg)) {
                jSONObject.put("phone", bVar.deg);
            }
            if (!TextUtils.isEmpty(bVar.deh)) {
                jSONObject.put("phone_cipher", bVar.deh);
            }
            JSONObject a = d.a(bVar.dei);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.dej);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.dek);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.del)) {
                jSONObject.put("street", bVar.del);
            }
            if (!TextUtils.isEmpty(bVar.dem)) {
                jSONObject.put("zipcode", bVar.dem);
            }
            jSONObject.put(NotifyAdapterUtil.PRIMARY_CHANNEL, bVar.den);
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
            if (!TextUtils.isEmpty(bVar.dem)) {
                jSONObject.put("postalCode", bVar.dem);
            }
            if (bVar.dei != null && !TextUtils.isEmpty(bVar.dei.name)) {
                jSONObject.put("provinceName", bVar.dei.name);
            }
            if (bVar.dej != null && !TextUtils.isEmpty(bVar.dej.name)) {
                jSONObject.put("cityName", bVar.dej.name);
            }
            if (bVar.dek != null && !TextUtils.isEmpty(bVar.dek.name)) {
                jSONObject.put("countyName", bVar.dek.name);
            }
            if (bVar.dek != null && !TextUtils.isEmpty(bVar.dek.code)) {
                jSONObject.put("nationalCode", bVar.dek.code);
            }
            if (!TextUtils.isEmpty(bVar.del)) {
                jSONObject.put("detailInfo", bVar.del);
            }
            if (!TextUtils.isEmpty(bVar.deg)) {
                jSONObject.put("telNumber", bVar.deg);
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
        a aVar2 = new a("联系电话", bVar.deg, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.def = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aFE(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.del, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.dem, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.def = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aFE() {
        StringBuilder sb = new StringBuilder();
        if (this.dei != null && !TextUtils.isEmpty(this.dei.name)) {
            sb.append(this.dei.name);
        }
        if (this.dej != null && !TextUtils.isEmpty(this.dej.name)) {
            sb.append(" " + this.dej.name);
        }
        if (this.dek != null && !TextUtils.isEmpty(this.dek.name)) {
            sb.append(" " + this.dek.name);
        }
        return sb.toString();
    }

    public String aFF() {
        StringBuilder sb = new StringBuilder();
        sb.append(aFE());
        sb.append(" " + this.del);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.deg) || TextUtils.isEmpty(aFE()) || TextUtils.isEmpty(this.del) || this.deg.length() != 11 || !this.deg.startsWith("1")) ? false : true;
    }

    public static boolean tu(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return tw(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.deg)) {
                this.deg = bVar.deg;
            }
            if (!TextUtils.isEmpty(bVar.deh)) {
                this.deh = bVar.deh;
            }
            if (!TextUtils.isEmpty(bVar.del)) {
                this.del = bVar.del;
            }
            if (!TextUtils.isEmpty(bVar.dem)) {
                this.dem = bVar.dem;
            }
            if (bVar.dei != null && bVar.dei.isValid()) {
                this.dei = bVar.dei;
            }
            if (bVar.dej != null && bVar.dej.isValid()) {
                this.dej = bVar.dej;
            }
            if (bVar.dek != null && bVar.dek.isValid()) {
                this.dek = bVar.dek;
            }
        }
    }

    public static boolean tv(String str) {
        return str.length() == 6 && tw(str);
    }

    public static boolean tw(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aFG() {
        if (tu(this.deg)) {
            this.deh = this.deg.substring(0, 3) + "*****" + this.deg.substring(8);
        }
    }
}
