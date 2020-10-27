package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gvP;
    private JSONObject gvU;

    public void dz(JSONObject jSONObject) {
        this.gvP = jSONObject;
    }

    public void dA(JSONObject jSONObject) {
        this.gvU = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gvP);
            jSONObject.put("src", this.gvU);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
