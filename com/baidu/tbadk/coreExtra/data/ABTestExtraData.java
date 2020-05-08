package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ABTestExtraData implements Serializable {
    private String mABTestResult;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.mABTestResult = null;
            saveABTestExtraToSharedPref(null);
            return;
        }
        try {
            this.mABTestResult = jSONObject.optString("newabtest_result");
            saveABTestExtraToSharedPref(jSONObject);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public String getABTestResult() {
        return this.mABTestResult;
    }

    public void parserABTestExtraFormSharedPref() {
        try {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("abtest_extra_info_json", null);
            if (!TextUtils.isEmpty(string)) {
                parseJson(new JSONObject(string));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void saveABTestExtraToSharedPref(JSONObject jSONObject) {
        com.baidu.tbadk.core.sharedPref.b.aNT().putString("abtest_extra_info_json", jSONObject != null ? jSONObject.toString() : "");
    }
}
