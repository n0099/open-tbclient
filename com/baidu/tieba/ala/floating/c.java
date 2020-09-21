package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject fZs;
    private JSONObject fZx;

    public void dn(JSONObject jSONObject) {
        this.fZs = jSONObject;
    }

    public void dq(JSONObject jSONObject) {
        this.fZx = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.fZs);
            jSONObject.put("src", this.fZx);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
