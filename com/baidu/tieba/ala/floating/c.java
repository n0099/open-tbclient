package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gKh;
    private JSONObject gKm;

    public void dA(JSONObject jSONObject) {
        this.gKh = jSONObject;
    }

    public void dB(JSONObject jSONObject) {
        this.gKm = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gKh);
            jSONObject.put("src", this.gKm);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
