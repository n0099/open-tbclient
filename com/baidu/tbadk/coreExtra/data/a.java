package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean frD = false;

    public boolean bvX() {
        return this.frD;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                dv(optJSONObject);
                dw(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.frD = true;
        }
    }

    public void dw(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("praise_abtest_switch_json", "");
        }
    }
}
