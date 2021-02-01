package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean fqc = false;

    public boolean bvU() {
        return this.fqc;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                dt(optJSONObject);
                du(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dt(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fqc = true;
        }
    }

    public void du(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("praise_abtest_switch_json", "");
        }
    }
}
