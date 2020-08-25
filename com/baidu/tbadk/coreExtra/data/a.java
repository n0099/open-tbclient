package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private boolean ezD = false;

    public boolean bmo() {
        return this.ezD;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cW(optJSONObject);
                cX(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cW(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ezD = true;
        }
    }

    public void cX(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putString("praise_abtest_switch_json", "");
        }
    }
}
