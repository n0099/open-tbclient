package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gBk;
    private JSONObject gBp;

    public void dz(JSONObject jSONObject) {
        this.gBk = jSONObject;
    }

    public void dA(JSONObject jSONObject) {
        this.gBp = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gBk);
            jSONObject.put("src", this.gBp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
