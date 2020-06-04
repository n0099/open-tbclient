package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String fzE = "";
    public int fzF = 0;
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
        aVar.fzE = jSONObject.optString("date");
        aVar.fzF = jSONObject.optInt("times");
        return aVar;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("date", this.fzE);
            jSONObject.put("times", this.fzF);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
