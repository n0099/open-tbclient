package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean cgl;
    private String cgm;
    private String cgn;
    private String cgo;
    private String cgp;
    private boolean cgq;
    private String cgr;
    private boolean cgs;
    private String cgt;

    public boolean ame() {
        return this.cgl;
    }

    public void eC(boolean z) {
        this.cgl = z;
    }

    public boolean amf() {
        return this.cgs;
    }

    public String amg() {
        return this.cgt;
    }

    public String amh() {
        return this.cgr;
    }

    public boolean ami() {
        return this.cgq;
    }

    public String amj() {
        return this.cgp;
    }

    public String amk() {
        return this.cgo;
    }

    public String aml() {
        return this.cgm;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            eC(jSONObject.optInt("switch") == 1);
            this.cgm = jSONObject.optString("feed_text");
            this.cgn = jSONObject.optString("enter_forum_text");
            this.cgo = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.cgp = optLong == 0 ? "" : optLong + "";
            this.cgq = jSONObject.optInt("user_satisfy") == 1;
            this.cgr = jSONObject.optString("h5_url");
            this.cgs = jSONObject.optInt("person_item_switch") == 1;
            this.cgt = jSONObject.optString("person_item_text");
        }
    }
}
