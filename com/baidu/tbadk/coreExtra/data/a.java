package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean eWo = false;

    public boolean brL() {
        return this.eWo;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                dj(optJSONObject);
                dk(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dj(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eWo = true;
        }
    }

    public void dk(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.bnH().putString("praise_abtest_switch_json", "");
        }
    }
}
