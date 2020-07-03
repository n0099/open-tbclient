package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean ejf = false;

    public boolean aZL() {
        return this.ejf;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cK(optJSONObject);
                cL(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cK(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ejf = true;
        }
    }

    public void cL(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("praise_abtest_switch_json", "");
        }
    }
}
