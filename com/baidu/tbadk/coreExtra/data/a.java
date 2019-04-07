package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bWk = false;

    public boolean afK() {
        return this.bWk;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                aL(optJSONObject);
                aM(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void aL(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bWk = true;
        }
    }

    public void afL() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                aL(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aM(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("praise_abtest_switch_json", "");
        }
    }
}
