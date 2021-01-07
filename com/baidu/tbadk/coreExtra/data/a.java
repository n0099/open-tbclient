package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean fsu = false;

    public boolean bzv() {
        return this.fsu;
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
            this.fsu = true;
        }
    }

    public void du(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("praise_abtest_switch_json", "");
        }
    }
}
