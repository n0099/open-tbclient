package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gBD;
    private JSONObject gBI;

    public void dF(JSONObject jSONObject) {
        this.gBD = jSONObject;
    }

    public void dG(JSONObject jSONObject) {
        this.gBI = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gBD);
            jSONObject.put("src", this.gBI);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
