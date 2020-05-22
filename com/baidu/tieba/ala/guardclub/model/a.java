package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String fzt = "";
    public int fzu = 0;
    public String id;

    public static a cN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        a aVar = new a();
        aVar.id = optString;
        aVar.fzt = jSONObject.optString("date");
        aVar.fzu = jSONObject.optInt("times");
        return aVar;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("date", this.fzt);
            jSONObject.put("times", this.fzu);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
