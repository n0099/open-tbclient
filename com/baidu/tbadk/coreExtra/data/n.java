package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String amC;
    private String eTL;
    private String fqH;
    private String mIcon;
    private int mVersion;

    public void parserData(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eTL = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.fqH = jSONObject.optString("pop_text");
        this.amC = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getTabCode() {
        return this.eTL;
    }

    public String getPopText() {
        return this.fqH;
    }

    public String getTid() {
        return this.amC;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
