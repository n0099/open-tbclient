package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aBf;
    private String aBg;
    private String aBh;
    private String aBi;
    private String aBj;
    private boolean aBk;
    private String aBl;
    private boolean aBm;
    private String aBn;

    public boolean BA() {
        return this.aBf;
    }

    public void ba(boolean z) {
        this.aBf = z;
    }

    public boolean BB() {
        return this.aBm;
    }

    public String BC() {
        return this.aBn;
    }

    public String BD() {
        return this.aBl;
    }

    public boolean BE() {
        return this.aBk;
    }

    public String BF() {
        return this.aBj;
    }

    public String BG() {
        return this.aBi;
    }

    public String BH() {
        return this.aBh;
    }

    public String BI() {
        return this.aBg;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            ba(jSONObject.optInt("switch") == 1);
            this.aBg = jSONObject.optString("feed_text");
            this.aBh = jSONObject.optString("enter_forum_text");
            this.aBi = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aBj = optLong == 0 ? "" : optLong + "";
            this.aBk = jSONObject.optInt("user_satisfy") == 1;
            this.aBl = jSONObject.optString("h5_url");
            this.aBm = jSONObject.optInt("person_item_switch") == 1;
            this.aBn = jSONObject.optString("person_item_text");
        }
    }
}
