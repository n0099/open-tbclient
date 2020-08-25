package com.baidu.tieba.ala.floating;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private JSONObject fWb;
    private JSONObject fWg;

    public void dj(JSONObject jSONObject) {
        this.fWb = jSONObject;
    }

    public void dk(JSONObject jSONObject) {
        this.fWg = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", this.fWb);
            jSONObject.put("src", this.fWg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
