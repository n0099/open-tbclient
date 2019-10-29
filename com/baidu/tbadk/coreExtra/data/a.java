package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean cus = false;

    public boolean aoP() {
        return this.cus;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                bv(optJSONObject);
                bw(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void bv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cus = true;
        }
    }

    public void aoQ() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                bv(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bw(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.alR().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.alR().putString("praise_abtest_switch_json", "");
        }
    }
}
