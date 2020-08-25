package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class w {
    public String eAE;
    public boolean isShowRedDot;
    public String tabCode;
    public String tabName;
    public int tabType;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.tabType = jSONObject.optInt("tab_type");
            this.tabName = jSONObject.optString("tab_name");
            this.tabCode = jSONObject.optString("tab_code");
            this.eAE = jSONObject.optString("tab_version");
        }
    }

    public boolean isDirtyData() {
        return TextUtils.isEmpty(this.tabName) || this.tabType <= 0;
    }
}
