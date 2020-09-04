package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String ala;
    private String eAl;
    private String eAm;
    private String mIcon;
    private int mVersion;

    public void cY(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eAl = jSONObject.optString("tab_code");
        this.eAm = jSONObject.optString("pop_text");
        this.ala = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bmH() {
        return this.eAl;
    }

    public String getPopText() {
        return this.eAm;
    }

    public String getTid() {
        return this.ala;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
