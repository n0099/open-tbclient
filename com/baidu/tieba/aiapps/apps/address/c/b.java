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
    public String dmJ;
    public String dmK;
    public d dmL;
    public d dmM;
    public d dmN;
    public String dmO;
    public String dmP;
    public boolean dmQ;
    public String id;
    public String userName;

    public static b bD(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.id = jSONObject.optString("id");
        bVar.userName = jSONObject.optString("name");
        bVar.dmJ = jSONObject.optString("phone");
        bVar.dmK = jSONObject.optString("phone_cipher");
        JSONObject optJSONObject = jSONObject.optJSONObject("l1");
        if (optJSONObject != null) {
            bVar.dmL = d.bE(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("l2");
        if (optJSONObject2 != null) {
            bVar.dmM = d.bE(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("l3");
        if (optJSONObject3 != null) {
            bVar.dmN = d.bE(optJSONObject3);
        }
        bVar.dmO = jSONObject.optString("street");
        bVar.dmP = jSONObject.optString("zipcode");
        bVar.dmQ = TextUtils.equals(jSONObject.optString("default"), "1");
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
            bVar.dmJ = String.valueOf(map.get("phone"));
        }
        if (map.containsKey("street")) {
            bVar.dmO = String.valueOf(map.get("street"));
        }
        if (map.containsKey("zipcode")) {
            bVar.dmP = String.valueOf(map.get("zipcode"));
        }
        if (map.containsKey("l1")) {
            Object obj = map.get("l1");
            if (obj instanceof d) {
                bVar.dmL = (d) obj;
            }
        }
        if (map.containsKey("l2")) {
            Object obj2 = map.get("l2");
            if (obj2 instanceof d) {
                bVar.dmM = (d) obj2;
            }
        }
        if (map.containsKey("l3")) {
            Object obj3 = map.get("l3");
            if (obj3 instanceof d) {
                bVar.dmN = (d) obj3;
            }
        }
        return bVar;
    }

    public static Map<String, Boolean> b(b bVar) {
        HashMap hashMap = new HashMap(4);
        if (bVar != null) {
            hashMap.put("name", Boolean.valueOf(!TextUtils.isEmpty(bVar.userName)));
            hashMap.put("phone", Boolean.valueOf(!TextUtils.isEmpty(bVar.dmJ)));
            hashMap.put("region", Boolean.valueOf(!TextUtils.isEmpty(bVar.aFO())));
            hashMap.put("street", Boolean.valueOf(TextUtils.isEmpty(bVar.dmO) ? false : true));
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
            if (!TextUtils.isEmpty(bVar.dmJ)) {
                jSONObject.put("phone", bVar.dmJ);
            }
            if (!TextUtils.isEmpty(bVar.dmK)) {
                jSONObject.put("phone_cipher", bVar.dmK);
            }
            JSONObject a = d.a(bVar.dmL);
            if (a != null) {
                jSONObject.put("l1", a);
            }
            JSONObject a2 = d.a(bVar.dmM);
            if (a2 != null) {
                jSONObject.put("l2", a2);
            }
            JSONObject a3 = d.a(bVar.dmN);
            if (a3 != null) {
                jSONObject.put("l3", a3);
            }
            if (!TextUtils.isEmpty(bVar.dmO)) {
                jSONObject.put("street", bVar.dmO);
            }
            if (!TextUtils.isEmpty(bVar.dmP)) {
                jSONObject.put("zipcode", bVar.dmP);
            }
            jSONObject.put("default", bVar.dmQ);
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
            if (!TextUtils.isEmpty(bVar.dmP)) {
                jSONObject.put("postalCode", bVar.dmP);
            }
            if (bVar.dmL != null && !TextUtils.isEmpty(bVar.dmL.name)) {
                jSONObject.put("provinceName", bVar.dmL.name);
            }
            if (bVar.dmM != null && !TextUtils.isEmpty(bVar.dmM.name)) {
                jSONObject.put("cityName", bVar.dmM.name);
            }
            if (bVar.dmN != null && !TextUtils.isEmpty(bVar.dmN.name)) {
                jSONObject.put("countyName", bVar.dmN.name);
            }
            if (bVar.dmN != null && !TextUtils.isEmpty(bVar.dmN.code)) {
                jSONObject.put("nationalCode", bVar.dmN.code);
            }
            if (!TextUtils.isEmpty(bVar.dmO)) {
                jSONObject.put("detailInfo", bVar.dmO);
            }
            if (!TextUtils.isEmpty(bVar.dmJ)) {
                jSONObject.put("telNumber", bVar.dmJ);
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
        a aVar2 = new a("联系电话", bVar.dmJ, "手机号码或座机");
        aVar2.type = "phone";
        aVar2.dmI = true;
        arrayList.add(aVar2);
        a aVar3 = new a("所在地区", bVar.aFO(), "地区选择");
        aVar3.type = "region";
        arrayList.add(aVar3);
        a aVar4 = new a("详细地址", bVar.dmO, "街道门牌信息");
        aVar4.type = "street";
        arrayList.add(aVar4);
        a aVar5 = new a("邮政编码", bVar.dmP, "邮政编码");
        aVar5.type = "zipcode";
        aVar5.dmI = true;
        arrayList.add(aVar5);
        return arrayList;
    }

    private String aFO() {
        StringBuilder sb = new StringBuilder();
        if (this.dmL != null && !TextUtils.isEmpty(this.dmL.name)) {
            sb.append(this.dmL.name);
        }
        if (this.dmM != null && !TextUtils.isEmpty(this.dmM.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.dmM.name);
        }
        if (this.dmN != null && !TextUtils.isEmpty(this.dmN.name)) {
            sb.append(HanziToPinyin.Token.SEPARATOR + this.dmN.name);
        }
        return sb.toString();
    }

    public String aFP() {
        StringBuilder sb = new StringBuilder();
        sb.append(aFO());
        sb.append(HanziToPinyin.Token.SEPARATOR + this.dmO);
        return sb.toString();
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.userName) || TextUtils.isEmpty(this.dmJ) || TextUtils.isEmpty(aFO()) || TextUtils.isEmpty(this.dmO) || this.dmJ.length() != 11 || !this.dmJ.startsWith("1")) ? false : true;
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
            if (!TextUtils.isEmpty(bVar.dmJ)) {
                this.dmJ = bVar.dmJ;
            }
            if (!TextUtils.isEmpty(bVar.dmK)) {
                this.dmK = bVar.dmK;
            }
            if (!TextUtils.isEmpty(bVar.dmO)) {
                this.dmO = bVar.dmO;
            }
            if (!TextUtils.isEmpty(bVar.dmP)) {
                this.dmP = bVar.dmP;
            }
            if (bVar.dmL != null && bVar.dmL.isValid()) {
                this.dmL = bVar.dmL;
            }
            if (bVar.dmM != null && bVar.dmM.isValid()) {
                this.dmM = bVar.dmM;
            }
            if (bVar.dmN != null && bVar.dmN.isValid()) {
                this.dmN = bVar.dmN;
            }
        }
    }

    public static boolean se(String str) {
        return str.length() == 6 && sf(str);
    }

    public static boolean sf(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void aFQ() {
        if (sd(this.dmJ)) {
            this.dmK = this.dmJ.substring(0, 3) + "*****" + this.dmJ.substring(8);
        }
    }
}
