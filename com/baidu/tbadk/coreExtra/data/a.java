package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean cfk = false;

    public boolean alO() {
        return this.cfk;
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
            this.cfk = true;
        }
    }

    public void alP() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                aX(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aY(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahO().putString("praise_abtest_switch_json", "");
        }
    }
}
