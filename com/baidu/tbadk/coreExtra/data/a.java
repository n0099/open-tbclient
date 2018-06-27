package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aBo;
    private String aBp;
    private String aBq;
    private String aBr;
    private String aBs;
    private boolean aBt;
    private String aBu;
    private boolean aBv;
    private String aBw;

    public boolean BL() {
        return this.aBo;
    }

    public void bb(boolean z) {
        this.aBo = z;
    }

    public boolean BM() {
        return this.aBv;
    }

    public String BN() {
        return this.aBw;
    }

    public String BO() {
        return this.aBu;
    }

    public boolean BP() {
        return this.aBt;
    }

    public String BQ() {
        return this.aBs;
    }

    public String BR() {
        return this.aBr;
    }

    public String BS() {
        return this.aBq;
    }

    public String BT() {
        return this.aBp;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bb(jSONObject.optInt("switch") == 1);
            this.aBp = jSONObject.optString("feed_text");
            this.aBq = jSONObject.optString("enter_forum_text");
            this.aBr = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aBs = optLong == 0 ? "" : optLong + "";
            this.aBt = jSONObject.optInt("user_satisfy") == 1;
            this.aBu = jSONObject.optString("h5_url");
            this.aBv = jSONObject.optInt("person_item_switch") == 1;
            this.aBw = jSONObject.optString("person_item_text");
        }
    }
}
