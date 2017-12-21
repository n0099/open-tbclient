package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean aqN;
    private String aqO;
    private String aqP;
    private String aqQ;
    private String aqR;
    private boolean aqS;
    private boolean aqT;
    private String aqU;
    private String h5Url;

    public boolean xv() {
        return this.aqN;
    }

    public void aQ(boolean z) {
        this.aqN = z;
    }

    public boolean xw() {
        return this.aqT;
    }

    public String xx() {
        return this.aqU;
    }

    public String xy() {
        return this.h5Url;
    }

    public boolean xz() {
        return this.aqS;
    }

    public String xA() {
        return this.aqR;
    }

    public String xB() {
        return this.aqQ;
    }

    public String xC() {
        return this.aqP;
    }

    public String xD() {
        return this.aqO;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aQ(jSONObject.optInt("switch") == 1);
            this.aqO = jSONObject.optString("feed_text");
            this.aqP = jSONObject.optString("enter_forum_text");
            this.aqQ = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.aqR = optLong == 0 ? "" : optLong + "";
            this.aqS = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.aqT = jSONObject.optInt("person_item_switch") == 1;
            this.aqU = jSONObject.optString("person_item_text");
        }
    }
}
