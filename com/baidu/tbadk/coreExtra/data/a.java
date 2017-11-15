package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aqp;
    private String aqq;
    private String aqr;
    private String aqs;
    private String aqt;
    private boolean aqu;
    private boolean aqv;
    private String h5Url;

    public boolean xv() {
        return this.aqp;
    }

    public void aP(boolean z) {
        this.aqp = z;
    }

    public boolean xw() {
        return this.aqv;
    }

    public String xx() {
        return this.h5Url;
    }

    public boolean xy() {
        return this.aqu;
    }

    public String xz() {
        return this.aqt;
    }

    public String xA() {
        return this.aqs;
    }

    public String xB() {
        return this.aqr;
    }

    public String xC() {
        return this.aqq;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            aP(jSONObject.optInt("switch") == 1);
            this.aqq = jSONObject.optString("feed_text");
            this.aqr = jSONObject.optString("enter_forum_text");
            this.aqs = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aqt = optLong == 0 ? "" : optLong + "";
            this.aqu = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.aqv = jSONObject.optInt("person_item_switch") == 1;
        }
    }
}
