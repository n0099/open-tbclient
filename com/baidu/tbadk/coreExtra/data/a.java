package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean beM;
    private String beN;
    private String beO;
    private String beP;
    private String beQ;
    private boolean beR;
    private boolean beS;
    private String beT;
    private String h5Url;

    public boolean EU() {
        return this.beM;
    }

    public void bw(boolean z) {
        this.beM = z;
    }

    public boolean EV() {
        return this.beS;
    }

    public String EW() {
        return this.beT;
    }

    public String EX() {
        return this.h5Url;
    }

    public boolean EY() {
        return this.beR;
    }

    public String EZ() {
        return this.beQ;
    }

    public String Fa() {
        return this.beP;
    }

    public String Fb() {
        return this.beO;
    }

    public String Fc() {
        return this.beN;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bw(jSONObject.optInt("switch") == 1);
            this.beN = jSONObject.optString("feed_text");
            this.beO = jSONObject.optString("enter_forum_text");
            this.beP = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.beQ = optLong == 0 ? "" : optLong + "";
            this.beR = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.beS = jSONObject.optInt("person_item_switch") == 1;
            this.beT = jSONObject.optString("person_item_text");
        }
    }
}
