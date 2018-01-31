package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean bfa;
    private String bfc;
    private String bfd;
    private String bfe;
    private String bff;
    private boolean bfg;
    private boolean bfh;
    private String bfi;
    private String h5Url;

    public boolean EN() {
        return this.bfa;
    }

    public void bx(boolean z) {
        this.bfa = z;
    }

    public boolean EO() {
        return this.bfh;
    }

    public String EP() {
        return this.bfi;
    }

    public String EQ() {
        return this.h5Url;
    }

    public boolean ER() {
        return this.bfg;
    }

    public String ES() {
        return this.bff;
    }

    public String ET() {
        return this.bfe;
    }

    public String EU() {
        return this.bfd;
    }

    public String EV() {
        return this.bfc;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bx(jSONObject.optInt("switch") == 1);
            this.bfc = jSONObject.optString("feed_text");
            this.bfd = jSONObject.optString("enter_forum_text");
            this.bfe = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.bff = optLong == 0 ? "" : optLong + "";
            this.bfg = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.bfh = jSONObject.optInt("person_item_switch") == 1;
            this.bfi = jSONObject.optString("person_item_text");
        }
    }
}
