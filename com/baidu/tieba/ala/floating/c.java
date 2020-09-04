package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private JSONObject fWf;
    private JSONObject fWk;

    public void dj(JSONObject jSONObject) {
        this.fWf = jSONObject;
    }

    public void dk(JSONObject jSONObject) {
        this.fWk = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.fWf);
            jSONObject.put("src", this.fWk);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
