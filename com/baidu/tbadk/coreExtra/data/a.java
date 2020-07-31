package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean epr = false;

    public boolean bdI() {
        return this.epr;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cQ(optJSONObject);
                cR(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.epr = true;
        }
    }

    public void cR(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("praise_abtest_switch_json", "");
        }
    }
}
