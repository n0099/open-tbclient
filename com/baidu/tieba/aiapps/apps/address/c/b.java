package com.baidu.tieba.aiapps.apps.address.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.TbEnum;
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
    public String dnB;
    public String dnC;
    public d dnD;
    public d dnE;
    public d dnF;
    public String dnG;
    public String dnH;
    public boolean dnI;
    public String id;
    public String userName;

    public static b bC(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.dnB = jSONObject.optString("phone");
        bVar.dnC = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.dnD = d.bD(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.dnE = d.bD(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.dnF = d.bD(optJSONObject3);
        }
        bVar.dnG = jSONObject.optString("street");
        bVar.dnH = jSONObject.optString("zipcode");
        bVar.dnI = TextUtils.equals(jSONObject.optString("default"), "1");
        return bVar;
    }

    public static b s(Map<String, Object> map) {
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
            bVar.dnB = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.dnG = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.dnH = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.dnD = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.dnE = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.dnF = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.dnB)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aFQ())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.dnG) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.dnB)) {
                jSONObject.put("phone", bVar.dnB);
            }
            if (!TextUtils.isEmpty(bVar.dnC)) {
                jSONObject.put("phone_cipher", bVar.dnC);
            }
            JSONObject a = d.a(bVar.dnD);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.dnE);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.dnF);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.dnG)) {
                jSONObject.put("street", bVar.dnG);
            }
            if (!TextUtils.isEmpty(bVar.dnH)) {
                jSONObject.put("zipcode", bVar.dnH);
            }
            jSONObject.put("default", bVar.dnI);
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
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, bVar.userName);
            }
            if (!TextUtils.isEmpty(bVar.dnH)) {
                jSONObject.put("postalCode", bVar.dnH);
            }
            if (bVar.dnD != null && !TextUtils.isEmpty(bVar.dnD.name)) {
                jSONObject.put("provinceName", bVar.dnD.name);
            }
            if (bVar.dnE != null && !TextUtils.isEmpty(bVar.dnE.name)) {
                jSONObject.put("cityName", bVar.dnE.name);
            }
            if (bVar.dnF != null && !TextUtils.isEmpty(bVar.dnF.name)) {
                jSONObject.put("countyName", bVar.dnF.name);
            }
            if (bVar.dnF != null && !TextUtils.isEmpty(bVar.dnF.code)) {
                jSONObject.put("nationalCode", bVar.dnF.code);
            }
            if (!TextUtils.isEmpty(bVar.dnG)) {
                jSONObject.put("detailInfo", bVar.dnG);
            }
            if (!TextUtils.isEmpty(bVar.dnB)) {
                jSONObject.put("telNumber", bVar.dnB);
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
        a aVar2 = new a("联系电话", bVar.dnB, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.dnA = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aFQ(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.dnG, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.dnH, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.dnA = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aFQ() {
        StringBuilder sb = new StringBuilder();
        if (this.dnD != null && !TextUtils.isEmpty(this.dnD.name)) {
            sb.append(this.dnD.name);
        }
        if (this.dnE != null && !TextUtils.isEmpty(this.dnE.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.dnE.name);
        }
        if (this.dnF != null && !TextUtils.isEmpty(this.dnF.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.dnF.name);
        }
        return sb.toString();
    }

    public String aFR() {
        StringBuilder sb = new StringBuilder();
        sb.append(aFQ());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.dnG);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.dnB) || TextUtils.isEmpty(aFQ()) || TextUtils.isEmpty(this.dnG) || this.dnB.length() != 11 || !this.dnB.startsWith("1")) ? false : true;
    }

    public static boolean sd(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11 && str.startsWith("1")) {
            return sf(str);
        }
        return false;
    }

    public void f(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.userName)) {
                this.userName = bVar.userName;
            }
            if (!TextUtils.isEmpty(bVar.dnB)) {
                this.dnB = bVar.dnB;
            }
            if (!TextUtils.isEmpty(bVar.dnC)) {
                this.dnC = bVar.dnC;
            }
            if (!TextUtils.isEmpty(bVar.dnG)) {
                this.dnG = bVar.dnG;
            }
            if (!TextUtils.isEmpty(bVar.dnH)) {
                this.dnH = bVar.dnH;
            }
            if (bVar.dnD != null && bVar.dnD.isValid()) {
                this.dnD = bVar.dnD;
            }
            if (bVar.dnE != null && bVar.dnE.isValid()) {
                this.dnE = bVar.dnE;
            }
            if (bVar.dnF != null && bVar.dnF.isValid()) {
                this.dnF = bVar.dnF;
            }
        }
    }

    public static boolean se(String str) {
        return str.length() == 6 && sf(str);
    }

    public static boolean sf(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aFS() {
        if (sd(this.dnB)) {
            this.dnC = this.dnB.substring(0, 3) + "*****" + this.dnB.substring(8);
        }
    }
}
