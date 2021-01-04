package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private JSONObject gVV;
    private JSONObject gWa;

    public void dJ(JSONObject jSONObject) {
        this.gVV = jSONObject;
    }

    public void dK(JSONObject jSONObject) {
        this.gWa = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gVV);
            jSONObject.put("src", this.gWa);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
