package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    private String akY;
    private String eAh;
    private String eAi;
    private String mIcon;
    private int mVersion;

    public void cY(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eAh = jSONObject.optString("tab_code");
        this.eAi = jSONObject.optString("pop_text");
        this.akY = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bmH() {
        return this.eAh;
    }

    public String getPopText() {
        return this.eAi;
    }

    public String getTid() {
        return this.akY;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
