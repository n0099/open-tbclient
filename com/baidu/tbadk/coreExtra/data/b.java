package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean bWl;
    private String bWm;
    private String bWn;
    private String bWo;
    private String bWp;
    private boolean bWq;
    private String bWr;
    private boolean bWs;
    private String bWt;

    public boolean afM() {
        return this.bWl;
    }

    public void dY(boolean z) {
        this.bWl = z;
    }

    public boolean afN() {
        return this.bWs;
    }

    public String afO() {
        return this.bWt;
    }

    public String afP() {
        return this.bWr;
    }

    public boolean afQ() {
        return this.bWq;
    }

    public String afR() {
        return this.bWp;
    }

    public String afS() {
        return this.bWo;
    }

    public String afT() {
        return this.bWm;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            dY(jSONObject.optInt("switch") == 1);
            this.bWm = jSONObject.optString("feed_text");
            this.bWn = jSONObject.optString("enter_forum_text");
            this.bWo = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bWp = optLong == 0 ? "" : optLong + "";
            this.bWq = jSONObject.optInt("user_satisfy") == 1;
            this.bWr = jSONObject.optString("h5_url");
            this.bWs = jSONObject.optInt("person_item_switch") == 1;
            this.bWt = jSONObject.optString("person_item_text");
        }
    }
}
