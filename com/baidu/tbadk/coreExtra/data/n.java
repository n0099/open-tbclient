package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String amY;
    private String fjq;
    private String fjr;
    private String mIcon;
    private int mVersion;

    public void parserData(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.fjq = jSONObject.optString("tab_code");
        this.fjr = jSONObject.optString("pop_text");
        this.amY = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bxu() {
        return this.fjq;
    }

    public String getPopText() {
        return this.fjr;
    }

    public String getTid() {
        return this.amY;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
