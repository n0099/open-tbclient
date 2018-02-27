package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bgH;
    private String bgI;
    private String bgJ;
    private String bgK;
    private String bgL;
    private boolean bgM;
    private boolean bgN;
    private String bgO;
    private String h5Url;

    public boolean Fh() {
        return this.bgH;
    }

    public void bC(boolean z) {
        this.bgH = z;
    }

    public boolean Fi() {
        return this.bgN;
    }

    public String Fj() {
        return this.bgO;
    }

    public String Fk() {
        return this.h5Url;
    }

    public boolean Fl() {
        return this.bgM;
    }

    public String Fm() {
        return this.bgL;
    }

    public String Fn() {
        return this.bgK;
    }

    public String Fo() {
        return this.bgJ;
    }

    public String Fp() {
        return this.bgI;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bC(jSONObject.optInt("switch") == 1);
            this.bgI = jSONObject.optString("feed_text");
            this.bgJ = jSONObject.optString("enter_forum_text");
            this.bgK = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bgL = optLong == 0 ? "" : optLong + "";
            this.bgM = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.bgN = jSONObject.optInt("person_item_switch") == 1;
            this.bgO = jSONObject.optString("person_item_text");
        }
    }
}
