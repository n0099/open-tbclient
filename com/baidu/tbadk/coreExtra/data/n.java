package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String amM;
    private String foo;
    private String fop;
    private String mIcon;
    private int mVersion;

    public void parserData(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.foo = jSONObject.optString("tab_code");
        this.fop = jSONObject.optString("pop_text");
        this.amM = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bvV() {
        return this.foo;
    }

    public String getPopText() {
        return this.fop;
    }

    public String getTid() {
        return this.amM;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
