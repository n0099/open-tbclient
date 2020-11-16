package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String alZ;
    private String fbQ;
    private String fbR;
    private String mIcon;
    private int mVersion;

    public void dl(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.fbQ = jSONObject.optString("tab_code");
        this.fbR = jSONObject.optString("pop_text");
        this.alZ = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String btU() {
        return this.fbQ;
    }

    public String getPopText() {
        return this.fbR;
    }

    public String getTid() {
        return this.alZ;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
