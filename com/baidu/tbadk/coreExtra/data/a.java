package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean ctA = false;

    public boolean aoN() {
        return this.ctA;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("zan_or_cai_smallflow");
                bw(optJSONObject);
                bx(optJSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void bw(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ctA = true;
        }
    }

    public void aoO() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("praise_abtest_switch_json", null);
            if (!TextUtils.isEmpty(string)) {
                bw(new JSONObject(string));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bx(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.tbadk.core.sharedPref.b.alP().putString("praise_abtest_switch_json", jSONObject.toString());
        } else {
            com.baidu.tbadk.core.sharedPref.b.alP().putString("praise_abtest_switch_json", "");
        }
    }
}
