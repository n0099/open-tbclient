package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean cfr = false;

    public boolean alQ() {
        return this.cfr;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                aX(optJSONObject);
                aY(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void aX(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfr = true;
        }
    }

    public void alR() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                aX(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aY(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putString("praise_abtest_switch_json", "");
        }
    }
}
