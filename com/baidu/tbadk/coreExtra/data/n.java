package com.baidu.tbadk.coreExtra.data;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String alA;
    private String eCq;
    private String eCr;
    private String mIcon;
    private int mVersion;

    public void db(JSONObject jSONObject) {
        this.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.eCq = jSONObject.optString("tab_code");
        this.eCr = jSONObject.optString("pop_text");
        this.alA = jSONObject.optString("thread_id");
        this.mVersion = jSONObject.optInt("version");
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String bnB() {
        return this.eCq;
    }

    public String getPopText() {
        return this.eCr;
    }

    public String getTid() {
        return this.alA;
    }

    public int getVersion() {
        return this.mVersion;
    }
}
