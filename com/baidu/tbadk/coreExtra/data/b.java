package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private boolean ceh;
    private String cei;
    private String cej;
    private String cek;
    private String cel;
    private boolean cem;
    private String cen;
    private boolean ceo;
    private String cep;

    public boolean akL() {
        return this.ceh;
    }

    public void ev(boolean z) {
        this.ceh = z;
    }

    public boolean akM() {
        return this.ceo;
    }

    public String akN() {
        return this.cep;
    }

    public String akO() {
        return this.cen;
    }

    public boolean akP() {
        return this.cem;
    }

    public String akQ() {
        return this.cel;
    }

    public String akR() {
        return this.cek;
    }

    public String akS() {
        return this.cei;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            ev(jSONObject.optInt("switch") == 1);
            this.cei = jSONObject.optString("feed_text");
            this.cej = jSONObject.optString("enter_forum_text");
            this.cek = jSONObject.optString("my_tab_text");
            long optLong = jSONObject.optLong("dot_timestamp");
            this.cel = optLong == 0 ? "" : optLong + "";
            this.cem = jSONObject.optInt("user_satisfy") == 1;
            this.cen = jSONObject.optString("h5_url");
            this.ceo = jSONObject.optInt("person_item_switch") == 1;
            this.cep = jSONObject.optString("person_item_text");
        }
    }
}
