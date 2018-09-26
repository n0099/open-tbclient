package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aEj = false;

    public boolean CM() {
        return this.aEj;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                x(optJSONObject);
                y(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void x(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEj = true;
        }
    }

    public void CN() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                x(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", "");
        }
    }
}
