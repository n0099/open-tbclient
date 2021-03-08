package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String anU;
    private String eVm;
    private String fsi;
    private String mIcon;
    private int mVersion;

    public void parserData(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eVm = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.fsi = jSONObject.optString("pop_text");
        this.anU = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getTabCode() {
        return this.eVm;
    }

    public String getPopText() {
        return this.fsi;
    }

    public String getTid() {
        return this.anU;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
