package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean bWi;
    private String bWj;
    private String bWk;
    private String bWl;
    private String bWm;
    private boolean bWn;
    private String bWo;
    private boolean bWp;
    private String bWq;

    public boolean afP() {
        return this.bWi;
    }

    public void dY(boolean z) {
        this.bWi = z;
    }

    public boolean afQ() {
        return this.bWp;
    }

    public String afR() {
        return this.bWq;
    }

    public String afS() {
        return this.bWo;
    }

    public boolean afT() {
        return this.bWn;
    }

    public String afU() {
        return this.bWm;
    }

    public String afV() {
        return this.bWl;
    }

    public String afW() {
        return this.bWj;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            dY(jSONObject.optInt("switch") == 1);
            this.bWj = jSONObject.optString("feed_text");
            this.bWk = jSONObject.optString("enter_forum_text");
            this.bWl = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bWm = optLong == 0 ? "" : optLong + "";
            this.bWn = jSONObject.optInt("user_satisfy") == 1;
            this.bWo = jSONObject.optString("h5_url");
            this.bWp = jSONObject.optInt("person_item_switch") == 1;
            this.bWq = jSONObject.optString("person_item_text");
        }
    }
}
