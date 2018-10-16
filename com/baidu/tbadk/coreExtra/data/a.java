package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aIN = false;

    public boolean EQ() {
        return this.aIN;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                A(optJSONObject);
                B(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void A(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIN = true;
        }
    }

    public void ER() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                A(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", "");
        }
    }
}
