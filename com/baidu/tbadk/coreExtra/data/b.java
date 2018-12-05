package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aNe;
    private String aNf;
    private String aNg;
    private String aNh;
    private String aNi;
    private boolean aNj;
    private String aNk;
    private boolean aNl;
    private String aNm;

    public boolean Gh() {
        return this.aNe;
    }

    public void bO(boolean z) {
        this.aNe = z;
    }

    public boolean Gi() {
        return this.aNl;
    }

    public String Gj() {
        return this.aNm;
    }

    public String Gk() {
        return this.aNk;
    }

    public boolean Gl() {
        return this.aNj;
    }

    public String Gm() {
        return this.aNi;
    }

    public String Gn() {
        return this.aNh;
    }

    public String Go() {
        return this.aNg;
    }

    public String Gp() {
        return this.aNf;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bO(jSONObject.optInt("switch") == 1);
            this.aNf = jSONObject.optString("feed_text");
            this.aNg = jSONObject.optString("enter_forum_text");
            this.aNh = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aNi = optLong == 0 ? "" : optLong + "";
            this.aNj = jSONObject.optInt("user_satisfy") == 1;
            this.aNk = jSONObject.optString("h5_url");
            this.aNl = jSONObject.optInt("person_item_switch") == 1;
            this.aNm = jSONObject.optString("person_item_text");
        }
    }
}
