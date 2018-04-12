package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private boolean asp;
    private String asq;
    private String asr;
    private String ass;
    private String ast;
    private boolean asu;
    private boolean asv;
    private String asw;
    private String h5Url;

    public boolean xV() {
        return this.asp;
    }

    public void aU(boolean z) {
        this.asp = z;
    }

    public boolean xW() {
        return this.asv;
    }

    public String xX() {
        return this.asw;
    }

    public String xY() {
        return this.h5Url;
    }

    public boolean xZ() {
        return this.asu;
    }

    public String ya() {
        return this.ast;
    }

    public String yb() {
        return this.ass;
    }

    public String yc() {
        return this.asr;
    }

    public String yd() {
        return this.asq;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            aU(jSONObject.optInt("switch") == 1);
            this.asq = jSONObject.optString("feed_text");
            this.asr = jSONObject.optString("enter_forum_text");
            this.ass = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.ast = optLong == 0 ? "" : optLong + "";
            this.asu = jSONObject.optInt("user_satisfy") == 1;
            this.h5Url = jSONObject.optString("h5_url");
            this.asv = jSONObject.optInt("person_item_switch") == 1;
            this.asw = jSONObject.optString("person_item_text");
        }
    }
}
