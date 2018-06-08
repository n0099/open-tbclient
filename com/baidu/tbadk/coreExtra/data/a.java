package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aAA;
    private boolean aAB;
    private boolean aAC;
    private String aAD;
    private boolean aAw;
    private String aAx;
    private String aAy;
    private String aAz;
    private String h5Url;

    public boolean Bu() {
        return this.aAw;
    }

    public void aY(boolean z) {
        this.aAw = z;
    }

    public boolean Bv() {
        return this.aAC;
    }

    public String Bw() {
        return this.aAD;
    }

    public String Bx() {
        return this.h5Url;
    }

    public boolean By() {
        return this.aAB;
    }

    public String Bz() {
        return this.aAA;
    }

    public String BA() {
        return this.aAz;
    }

    public String BB() {
        return this.aAy;
    }

    public String BC() {
        return this.aAx;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aY(jSONObject.optInt("switch") == 1);
            this.aAx = jSONObject.optString("feed_text");
            this.aAy = jSONObject.optString("enter_forum_text");
            this.aAz = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aAA = optLong == 0 ? "" : optLong + "";
            this.aAB = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.aAC = jSONObject.optInt("person_item_switch") == 1;
            this.aAD = jSONObject.optString("person_item_text");
        }
    }
}
