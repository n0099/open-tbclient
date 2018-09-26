package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aEk;
    private String aEl;
    private String aEm;
    private String aEn;
    private String aEo;
    private boolean aEp;
    private String aEq;
    private boolean aEr;
    private String aEs;

    public boolean CO() {
        return this.aEk;
    }

    public void bm(boolean z) {
        this.aEk = z;
    }

    public boolean CP() {
        return this.aEr;
    }

    public String CQ() {
        return this.aEs;
    }

    public String CR() {
        return this.aEq;
    }

    public boolean CS() {
        return this.aEp;
    }

    public String CT() {
        return this.aEo;
    }

    public String CU() {
        return this.aEn;
    }

    public String CV() {
        return this.aEm;
    }

    public String CW() {
        return this.aEl;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bm(jSONObject.optInt("switch") == 1);
            this.aEl = jSONObject.optString("feed_text");
            this.aEm = jSONObject.optString("enter_forum_text");
            this.aEn = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aEo = optLong == 0 ? "" : optLong + "";
            this.aEp = jSONObject.optInt("user_satisfy") == 1;
            this.aEq = jSONObject.optString("h5_url");
            this.aEr = jSONObject.optInt("person_item_switch") == 1;
            this.aEs = jSONObject.optString("person_item_text");
        }
    }
}
