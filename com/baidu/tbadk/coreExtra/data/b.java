package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private String cfA;
    private boolean cfs;
    private String cft;
    private String cfu;
    private String cfv;
    private String cfw;
    private boolean cfx;
    private String cfy;
    private boolean cfz;

    public boolean alS() {
        return this.cfs;
    }

    public void ez(boolean z) {
        this.cfs = z;
    }

    public boolean alT() {
        return this.cfz;
    }

    public String alU() {
        return this.cfA;
    }

    public String alV() {
        return this.cfy;
    }

    public boolean alW() {
        return this.cfx;
    }

    public String alX() {
        return this.cfw;
    }

    public String alY() {
        return this.cfv;
    }

    public String alZ() {
        return this.cft;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            ez(jSONObject.optInt("switch") == 1);
            this.cft = jSONObject.optString("feed_text");
            this.cfu = jSONObject.optString("enter_forum_text");
            this.cfv = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.cfw = optLong == 0 ? "" : optLong + "";
            this.cfx = jSONObject.optInt("user_satisfy") == 1;
            this.cfy = jSONObject.optString("h5_url");
            this.cfz = jSONObject.optInt("person_item_switch") == 1;
            this.cfA = jSONObject.optString("person_item_text");
        }
    }
}
