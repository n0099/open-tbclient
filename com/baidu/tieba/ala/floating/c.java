package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject glK;
    private JSONObject glP;

    public void du(JSONObject jSONObject) {
        this.glK = jSONObject;
    }

    public void dv(JSONObject jSONObject) {
        this.glP = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.glK);
            jSONObject.put("src", this.glP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
