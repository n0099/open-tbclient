package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aNI;
    private String aNJ;
    private String aNK;
    private String aNL;
    private String aNM;
    private boolean aNN;
    private String aNO;
    private boolean aNP;
    private String aNQ;

    public boolean Gv() {
        return this.aNI;
    }

    public void bP(boolean z) {
        this.aNI = z;
    }

    public boolean Gw() {
        return this.aNP;
    }

    public String Gx() {
        return this.aNQ;
    }

    public String Gy() {
        return this.aNO;
    }

    public boolean Gz() {
        return this.aNN;
    }

    public String GA() {
        return this.aNM;
    }

    public String GB() {
        return this.aNL;
    }

    public String GC() {
        return this.aNK;
    }

    public String GD() {
        return this.aNJ;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bP(jSONObject.optInt("switch") == 1);
            this.aNJ = jSONObject.optString("feed_text");
            this.aNK = jSONObject.optString("enter_forum_text");
            this.aNL = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aNM = optLong == 0 ? "" : optLong + "";
            this.aNN = jSONObject.optInt("user_satisfy") == 1;
            this.aNO = jSONObject.optString("h5_url");
            this.aNP = jSONObject.optInt("person_item_switch") == 1;
            this.aNQ = jSONObject.optString("person_item_text");
        }
    }
}
