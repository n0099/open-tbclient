package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String anD;
    private String fsZ;
    private String fta;
    private String mIcon;
    private int mVersion;

    public void parserData(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.fsZ = jSONObject.optString("tab_code");
        this.fta = jSONObject.optString("pop_text");
        this.anD = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bzO() {
        return this.fsZ;
    }

    public String getPopText() {
        return this.fta;
    }

    public String getTid() {
        return this.anD;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
