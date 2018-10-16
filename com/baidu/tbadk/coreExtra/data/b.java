package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aIO;
    private String aIP;
    private String aIQ;
    private String aIR;
    private String aIS;
    private boolean aIT;
    private String aIU;
    private boolean aIV;
    private String aIW;

    public boolean ES() {
        return this.aIO;
    }

    public void bw(boolean z) {
        this.aIO = z;
    }

    public boolean ET() {
        return this.aIV;
    }

    public String EU() {
        return this.aIW;
    }

    public String EV() {
        return this.aIU;
    }

    public boolean EW() {
        return this.aIT;
    }

    public String EX() {
        return this.aIS;
    }

    public String EY() {
        return this.aIR;
    }

    public String EZ() {
        return this.aIQ;
    }

    public String Fa() {
        return this.aIP;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bw(jSONObject.optInt("switch") == 1);
            this.aIP = jSONObject.optString("feed_text");
            this.aIQ = jSONObject.optString("enter_forum_text");
            this.aIR = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aIS = optLong == 0 ? "" : optLong + "";
            this.aIT = jSONObject.optInt("user_satisfy") == 1;
            this.aIU = jSONObject.optString("h5_url");
            this.aIV = jSONObject.optInt("person_item_switch") == 1;
            this.aIW = jSONObject.optString("person_item_text");
        }
    }
}
