package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String date = "";
    public int dsw = 0;
    public String id;

    public static a dw(JSONObject jSONObject) {
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
        aVar.dsw = jSONObject.optInt("times");
        return aVar;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dsw);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
