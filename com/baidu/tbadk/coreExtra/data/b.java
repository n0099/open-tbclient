package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean aJE;
    private String aJF;
    private String aJG;
    private String aJH;
    private String aJI;
    private boolean aJJ;
    private String aJK;
    private boolean aJL;
    private String aJM;

    public boolean Fd() {
        return this.aJE;
    }

    public void bN(boolean z) {
        this.aJE = z;
    }

    public boolean Fe() {
        return this.aJL;
    }

    public String Ff() {
        return this.aJM;
    }

    public String Fg() {
        return this.aJK;
    }

    public boolean Fh() {
        return this.aJJ;
    }

    public String Fi() {
        return this.aJI;
    }

    public String Fj() {
        return this.aJH;
    }

    public String Fk() {
        return this.aJG;
    }

    public String Fl() {
        return this.aJF;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bN(jSONObject.optInt("switch") == 1);
            this.aJF = jSONObject.optString("feed_text");
            this.aJG = jSONObject.optString("enter_forum_text");
            this.aJH = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aJI = optLong == 0 ? "" : optLong + "";
            this.aJJ = jSONObject.optInt("user_satisfy") == 1;
            this.aJK = jSONObject.optString("h5_url");
            this.aJL = jSONObject.optInt("person_item_switch") == 1;
            this.aJM = jSONObject.optString("person_item_text");
        }
    }
}
