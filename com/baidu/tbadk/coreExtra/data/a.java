package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bgT;
    private String bgU;
    private String bgV;
    private String bgW;
    private String bgX;
    private boolean bgY;
    private boolean bgZ;
    private String bha;
    private String h5Url;

    public boolean Fi() {
        return this.bgT;
    }

    public void bC(boolean z) {
        this.bgT = z;
    }

    public boolean Fj() {
        return this.bgZ;
    }

    public String Fk() {
        return this.bha;
    }

    public String Fl() {
        return this.h5Url;
    }

    public boolean Fm() {
        return this.bgY;
    }

    public String Fn() {
        return this.bgX;
    }

    public String Fo() {
        return this.bgW;
    }

    public String Fp() {
        return this.bgV;
    }

    public String Fq() {
        return this.bgU;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bC(jSONObject.optInt("switch") == 1);
            this.bgU = jSONObject.optString("feed_text");
            this.bgV = jSONObject.optString("enter_forum_text");
            this.bgW = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bgX = optLong == 0 ? "" : optLong + "";
            this.bgY = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.bgZ = jSONObject.optInt("person_item_switch") == 1;
            this.bha = jSONObject.optString("person_item_text");
        }
    }
}
