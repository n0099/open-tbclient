package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean bWm;
    private String bWn;
    private String bWo;
    private String bWp;
    private String bWq;
    private boolean bWr;
    private String bWs;
    private boolean bWt;
    private String bWu;

    public boolean afM() {
        return this.bWm;
    }

    public void dY(boolean z) {
        this.bWm = z;
    }

    public boolean afN() {
        return this.bWt;
    }

    public String afO() {
        return this.bWu;
    }

    public String afP() {
        return this.bWs;
    }

    public boolean afQ() {
        return this.bWr;
    }

    public String afR() {
        return this.bWq;
    }

    public String afS() {
        return this.bWp;
    }

    public String afT() {
        return this.bWn;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            dY(jSONObject.optInt("switch") == 1);
            this.bWn = jSONObject.optString("feed_text");
            this.bWo = jSONObject.optString("enter_forum_text");
            this.bWp = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bWq = optLong == 0 ? "" : optLong + "";
            this.bWr = jSONObject.optInt("user_satisfy") == 1;
            this.bWs = jSONObject.optString("h5_url");
            this.bWt = jSONObject.optInt("person_item_switch") == 1;
            this.bWu = jSONObject.optString("person_item_text");
        }
    }
}
