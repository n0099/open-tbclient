package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String abc;
    private String abd;
    private String abe;
    private String abf;
    private String abg;
    private String abh;
    private String abi;
    private String abj;
    private String abk;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abc = jSONObject.optString("drop_pic");
                this.abd = jSONObject.optString("drop_pic_md5");
                this.abe = jSONObject.optString("drop_pic_num");
                this.abf = jSONObject.optString("drop_bg_color_day");
                this.abg = jSONObject.optString("drop_bg_color_night");
                this.abh = jSONObject.optString("apply_vip_live_room_pid");
                this.abi = jSONObject.optString("max_cache");
                this.abj = jSONObject.optString("frs_max_cache");
                this.abk = jSONObject.optString("frs_pn");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String uN() {
        return this.abh;
    }

    public String uO() {
        return this.abc;
    }

    public String uP() {
        return this.abd;
    }

    public String uQ() {
        return this.abe;
    }

    public String uR() {
        return this.abf;
    }

    public String uS() {
        return this.abg;
    }

    public String uT() {
        return this.abi;
    }

    public String uU() {
        return this.abj;
    }

    public String uV() {
        return this.abk;
    }
}
