package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean cfl;
    private String cfm;
    private String cfn;
    private String cfo;
    private String cfp;
    private boolean cfq;
    private String cfr;
    private boolean cfs;
    private String cft;

    public boolean alQ() {
        return this.cfl;
    }

    public void ez(boolean z) {
        this.cfl = z;
    }

    public boolean alR() {
        return this.cfs;
    }

    public String alS() {
        return this.cft;
    }

    public String alT() {
        return this.cfr;
    }

    public boolean alU() {
        return this.cfq;
    }

    public String alV() {
        return this.cfp;
    }

    public String alW() {
        return this.cfo;
    }

    public String alX() {
        return this.cfm;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            ez(jSONObject.optInt("switch") == 1);
            this.cfm = jSONObject.optString("feed_text");
            this.cfn = jSONObject.optString("enter_forum_text");
            this.cfo = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.cfp = optLong == 0 ? "" : optLong + "";
            this.cfq = jSONObject.optInt("user_satisfy") == 1;
            this.cfr = jSONObject.optString("h5_url");
            this.cfs = jSONObject.optInt("person_item_switch") == 1;
            this.cft = jSONObject.optString("person_item_text");
        }
    }
}
