package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean bWj;
    private String bWk;
    private String bWl;
    private String bWm;
    private String bWn;
    private boolean bWo;
    private String bWp;
    private boolean bWq;
    private String bWr;

    public boolean afP() {
        return this.bWj;
    }

    public void dY(boolean z) {
        this.bWj = z;
    }

    public boolean afQ() {
        return this.bWq;
    }

    public String afR() {
        return this.bWr;
    }

    public String afS() {
        return this.bWp;
    }

    public boolean afT() {
        return this.bWo;
    }

    public String afU() {
        return this.bWn;
    }

    public String afV() {
        return this.bWm;
    }

    public String afW() {
        return this.bWk;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            dY(jSONObject.optInt("switch") == 1);
            this.bWk = jSONObject.optString("feed_text");
            this.bWl = jSONObject.optString("enter_forum_text");
            this.bWm = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bWn = optLong == 0 ? "" : optLong + "";
            this.bWo = jSONObject.optInt("user_satisfy") == 1;
            this.bWp = jSONObject.optString("h5_url");
            this.bWq = jSONObject.optInt("person_item_switch") == 1;
            this.bWr = jSONObject.optString("person_item_text");
        }
    }
}
