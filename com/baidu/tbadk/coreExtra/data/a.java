package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int ajG;
    private int ajF = 1;
    private c ajH = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ajF = jSONObject.optInt("als_control", 1);
            this.ajG = jSONObject.optInt("new_log_enabled", 0);
            this.ajH.parserJson(jSONObject);
        }
    }

    public c xw() {
        return this.ajH;
    }

    public boolean xx() {
        return this.ajF > 0;
    }

    public boolean xy() {
        return this.ajG > 0;
    }
}
