package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean dlF = false;

    public boolean aIY() {
        return this.dlF;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cm(optJSONObject);
                cn(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cm(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dlF = true;
        }
    }

    public void aIZ() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                cm(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cn(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("praise_abtest_switch_json", "");
        }
    }
}
