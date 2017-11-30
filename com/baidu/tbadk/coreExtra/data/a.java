package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aqH;
    private String aqI;
    private String aqJ;
    private String aqK;
    private String aqL;
    private boolean aqM;
    private boolean aqN;
    private String h5Url;

    public boolean xw() {
        return this.aqH;
    }

    public void aP(boolean z) {
        this.aqH = z;
    }

    public boolean xx() {
        return this.aqN;
    }

    public String xy() {
        return this.h5Url;
    }

    public boolean xz() {
        return this.aqM;
    }

    public String xA() {
        return this.aqL;
    }

    public String xB() {
        return this.aqK;
    }

    public String xC() {
        return this.aqJ;
    }

    public String xD() {
        return this.aqI;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aP(jSONObject.optInt("switch") == 1);
            this.aqI = jSONObject.optString("feed_text");
            this.aqJ = jSONObject.optString("enter_forum_text");
            this.aqK = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aqL = optLong == 0 ? "" : optLong + "";
            this.aqM = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.aqN = jSONObject.optInt("person_item_switch") == 1;
        }
    }
}
