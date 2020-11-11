package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String alT;
    private String fcJ;
    private String fcK;
    private String mIcon;
    private int mVersion;

    public void dr(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.fcJ = jSONObject.optString("tab_code");
        this.fcK = jSONObject.optString("pop_text");
        this.alT = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String buE() {
        return this.fcJ;
    }

    public String getPopText() {
        return this.fcK;
    }

    public String getTid() {
        return this.alT;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
