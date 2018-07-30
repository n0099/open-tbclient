package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aBi;
    private String aBj;
    private String aBk;
    private String aBl;
    private String aBm;
    private boolean aBn;
    private String aBo;
    private boolean aBp;
    private String aBq;

    public boolean BD() {
        return this.aBi;
    }

    public void aZ(boolean z) {
        this.aBi = z;
    }

    public boolean BE() {
        return this.aBp;
    }

    public String BF() {
        return this.aBq;
    }

    public String BG() {
        return this.aBo;
    }

    public boolean BH() {
        return this.aBn;
    }

    public String BI() {
        return this.aBm;
    }

    public String BJ() {
        return this.aBl;
    }

    public String BK() {
        return this.aBk;
    }

    public String BL() {
        return this.aBj;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aZ(jSONObject.optInt("switch") == 1);
            this.aBj = jSONObject.optString("feed_text");
            this.aBk = jSONObject.optString("enter_forum_text");
            this.aBl = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aBm = optLong == 0 ? "" : optLong + "";
            this.aBn = jSONObject.optInt("user_satisfy") == 1;
            this.aBo = jSONObject.optString("h5_url");
            this.aBp = jSONObject.optInt("person_item_switch") == 1;
            this.aBq = jSONObject.optString("person_item_text");
        }
    }
}
