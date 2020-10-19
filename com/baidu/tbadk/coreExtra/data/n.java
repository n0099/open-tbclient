package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String alS;
    private String eOx;
    private String eOy;
    private String mIcon;
    private int mVersion;

    public void di(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eOx = jSONObject.optString("tab_code");
        this.eOy = jSONObject.optString("pop_text");
        this.alS = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bql() {
        return this.eOx;
    }

    public String getPopText() {
        return this.eOy;
    }

    public String getTid() {
        return this.alS;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
