package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean dMa = false;

    public boolean aRA() {
        return this.dMa;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cx(optJSONObject);
                cy(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cx(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dMa = true;
        }
    }

    public void aRB() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                cx(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cy(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("praise_abtest_switch_json", "");
        }
    }
}
