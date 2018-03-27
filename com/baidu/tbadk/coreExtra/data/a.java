package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bgK;
    private String bgL;
    private String bgM;
    private String bgN;
    private String bgO;
    private boolean bgP;
    private boolean bgQ;
    private String bgR;
    private String h5Url;

    public boolean Fi() {
        return this.bgK;
    }

    public void bC(boolean z) {
        this.bgK = z;
    }

    public boolean Fj() {
        return this.bgQ;
    }

    public String Fk() {
        return this.bgR;
    }

    public String Fl() {
        return this.h5Url;
    }

    public boolean Fm() {
        return this.bgP;
    }

    public String Fn() {
        return this.bgO;
    }

    public String Fo() {
        return this.bgN;
    }

    public String Fp() {
        return this.bgM;
    }

    public String Fq() {
        return this.bgL;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bC(jSONObject.optInt("switch") == 1);
            this.bgL = jSONObject.optString("feed_text");
            this.bgM = jSONObject.optString("enter_forum_text");
            this.bgN = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bgO = optLong == 0 ? "" : optLong + "";
            this.bgP = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.bgQ = jSONObject.optInt("person_item_switch") == 1;
            this.bgR = jSONObject.optString("person_item_text");
        }
    }
}
