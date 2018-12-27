package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aNf = false;

    public boolean Gg() {
        return this.aNf;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                B(optJSONObject);
                C(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void B(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNf = true;
        }
    }

    public void Gh() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                B(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void C(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", "");
        }
    }
}
