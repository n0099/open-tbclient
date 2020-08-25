package com.baidu.tieba.ala.liveroom.w;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    String date;
    int dej;
    String uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a dx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.uid = jSONObject.optString("uid");
        this.date = jSONObject.optString("date");
        this.dej = jSONObject.optInt("times");
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.dej);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
