package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String id;
    public String date = "";
    public int bnO = 0;

    public static a dM(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        a aVar = new a();
        aVar.id = optString;
        aVar.date = jSONObject.optString("date");
        aVar.bnO = jSONObject.optInt("times");
        return aVar;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.bnO);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
