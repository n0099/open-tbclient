package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aNg;
    private String aNh;
    private String aNi;
    private String aNj;
    private String aNk;
    private boolean aNl;
    private String aNm;
    private boolean aNn;
    private String aNo;

    public boolean Gi() {
        return this.aNg;
    }

    public void bO(boolean z) {
        this.aNg = z;
    }

    public boolean Gj() {
        return this.aNn;
    }

    public String Gk() {
        return this.aNo;
    }

    public String Gl() {
        return this.aNm;
    }

    public boolean Gm() {
        return this.aNl;
    }

    public String Gn() {
        return this.aNk;
    }

    public String Go() {
        return this.aNj;
    }

    public String Gp() {
        return this.aNi;
    }

    public String Gq() {
        return this.aNh;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bO(jSONObject.optInt("switch") == 1);
            this.aNh = jSONObject.optString("feed_text");
            this.aNi = jSONObject.optString("enter_forum_text");
            this.aNj = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aNk = optLong == 0 ? "" : optLong + "";
            this.aNl = jSONObject.optInt("user_satisfy") == 1;
            this.aNm = jSONObject.optString("h5_url");
            this.aNn = jSONObject.optInt("person_item_switch") == 1;
            this.aNo = jSONObject.optString("person_item_text");
        }
    }
}
