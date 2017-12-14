package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aqK;
    private String aqL;
    private String aqM;
    private String aqN;
    private String aqO;
    private boolean aqP;
    private boolean aqQ;
    private String aqR;
    private String h5Url;

    public boolean xv() {
        return this.aqK;
    }

    public void aQ(boolean z) {
        this.aqK = z;
    }

    public boolean xw() {
        return this.aqQ;
    }

    public String xx() {
        return this.aqR;
    }

    public String xy() {
        return this.h5Url;
    }

    public boolean xz() {
        return this.aqP;
    }

    public String xA() {
        return this.aqO;
    }

    public String xB() {
        return this.aqN;
    }

    public String xC() {
        return this.aqM;
    }

    public String xD() {
        return this.aqL;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aQ(jSONObject.optInt("switch") == 1);
            this.aqL = jSONObject.optString("feed_text");
            this.aqM = jSONObject.optString("enter_forum_text");
            this.aqN = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aqO = optLong == 0 ? "" : optLong + "";
            this.aqP = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.aqQ = jSONObject.optInt("person_item_switch") == 1;
            this.aqR = jSONObject.optString("person_item_text");
        }
    }
}
