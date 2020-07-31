package com.baidu.tieba.ala.liveroom.v;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    int cVg;
    String date;
    String uid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a dn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.uid = jSONObject.optString("uid");
        this.date = jSONObject.optString("date");
        this.cVg = jSONObject.optInt("times");
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", this.uid);
            jSONObject.put("date", this.date);
            jSONObject.put("times", this.cVg);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
