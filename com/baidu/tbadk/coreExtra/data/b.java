package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aNJ;
    private String aNK;
    private String aNL;
    private String aNM;
    private String aNN;
    private boolean aNO;
    private String aNP;
    private boolean aNQ;
    private String aNR;

    public boolean Gv() {
        return this.aNJ;
    }

    public void bP(boolean z) {
        this.aNJ = z;
    }

    public boolean Gw() {
        return this.aNQ;
    }

    public String Gx() {
        return this.aNR;
    }

    public String Gy() {
        return this.aNP;
    }

    public boolean Gz() {
        return this.aNO;
    }

    public String GA() {
        return this.aNN;
    }

    public String GB() {
        return this.aNM;
    }

    public String GC() {
        return this.aNL;
    }

    public String GD() {
        return this.aNK;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bP(jSONObject.optInt("switch") == 1);
            this.aNK = jSONObject.optString("feed_text");
            this.aNL = jSONObject.optString("enter_forum_text");
            this.aNM = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aNN = optLong == 0 ? "" : optLong + "";
            this.aNO = jSONObject.optInt("user_satisfy") == 1;
            this.aNP = jSONObject.optString("h5_url");
            this.aNQ = jSONObject.optInt("person_item_switch") == 1;
            this.aNR = jSONObject.optString("person_item_text");
        }
    }
}
