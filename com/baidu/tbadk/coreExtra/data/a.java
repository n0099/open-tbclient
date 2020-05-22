package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean eav = false;

    public boolean aXE() {
        return this.eav;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                cD(optJSONObject);
                cE(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cD(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eav = true;
        }
    }

    public void aXF() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                cD(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cE(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("praise_abtest_switch_json", "");
        }
    }
}
