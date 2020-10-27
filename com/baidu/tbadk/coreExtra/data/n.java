package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String alT;
    private String eWT;
    private String eWU;
    private String mIcon;
    private int mVersion;

    public void dl(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eWT = jSONObject.optString("tab_code");
        this.eWU = jSONObject.optString("pop_text");
        this.alT = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bse() {
        return this.eWT;
    }

    public String getPopText() {
        return this.eWU;
    }

    public String getTid() {
        return this.alT;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
