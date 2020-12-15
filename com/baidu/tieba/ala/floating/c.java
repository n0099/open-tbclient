package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONObject gKj;
    private JSONObject gKo;

    public void dA(JSONObject jSONObject) {
        this.gKj = jSONObject;
    }

    public void dB(JSONObject jSONObject) {
        this.gKo = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.gKj);
            jSONObject.put("src", this.gKo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
