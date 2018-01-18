package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean beS;
    private String beT;
    private String beU;
    private String beV;
    private String beW;
    private boolean beX;
    private boolean beY;
    private String beZ;
    private String h5Url;

    public boolean EL() {
        return this.beS;
    }

    public void bw(boolean z) {
        this.beS = z;
    }

    public boolean EM() {
        return this.beY;
    }

    public String EN() {
        return this.beZ;
    }

    public String EO() {
        return this.h5Url;
    }

    public boolean EP() {
        return this.beX;
    }

    public String EQ() {
        return this.beW;
    }

    public String ER() {
        return this.beV;
    }

    public String ES() {
        return this.beU;
    }

    public String ET() {
        return this.beT;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            bw(jSONObject.optInt("switch") == 1);
            this.beT = jSONObject.optString("feed_text");
            this.beU = jSONObject.optString("enter_forum_text");
            this.beV = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.beW = optLong == 0 ? "" : optLong + "";
            this.beX = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.beY = jSONObject.optInt("person_item_switch") == 1;
            this.beZ = jSONObject.optString("person_item_text");
        }
    }
}
