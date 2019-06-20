package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean cei;
    private String cej;
    private String cek;
    private String cel;
    private String cem;
    private boolean cen;
    private String ceo;
    private boolean cep;
    private String ceq;

    public boolean akL() {
        return this.cei;
    }

    public void ev(boolean z) {
        this.cei = z;
    }

    public boolean akM() {
        return this.cep;
    }

    public String akN() {
        return this.ceq;
    }

    public String akO() {
        return this.ceo;
    }

    public boolean akP() {
        return this.cen;
    }

    public String akQ() {
        return this.cem;
    }

    public String akR() {
        return this.cel;
    }

    public String akS() {
        return this.cej;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            ev(jSONObject.optInt("switch") == 1);
            this.cej = jSONObject.optString("feed_text");
            this.cek = jSONObject.optString("enter_forum_text");
            this.cel = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.cem = optLong == 0 ? "" : optLong + "";
            this.cen = jSONObject.optInt("user_satisfy") == 1;
            this.ceo = jSONObject.optString("h5_url");
            this.cep = jSONObject.optInt("person_item_switch") == 1;
            this.ceq = jSONObject.optString("person_item_text");
        }
    }
}
