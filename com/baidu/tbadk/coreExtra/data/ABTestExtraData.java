package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.r.d0.b;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ABTestExtraData implements Serializable {
    public String mABTestResult;

    private void saveABTestExtraToSharedPref(JSONObject jSONObject) {
        b.j().x("abtest_extra_info_json", jSONObject != null ? jSONObject.toString() : "");
    }

    public String getABTestResult() {
        return this.mABTestResult;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.mABTestResult = null;
            saveABTestExtraToSharedPref(null);
            return;
        }
        try {
            this.mABTestResult = jSONObject.optString(TiebaStatic.Params.ABTEST_RESULT);
            saveABTestExtraToSharedPref(jSONObject);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserABTestExtraFormSharedPref() {
        try {
            String p = b.j().p("abtest_extra_info_json", null);
            if (TextUtils.isEmpty(p)) {
                return;
            }
            parseJson(new JSONObject(p));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
