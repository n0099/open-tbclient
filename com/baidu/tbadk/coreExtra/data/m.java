package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String acg;
    private String ach;
    private String aci;
    private String acj;
    private String ack;
    private String acl;
    private String acm;
    private String acn;
    private String aco;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.acg = jSONObject.optString("drop_pic");
                this.ach = jSONObject.optString("drop_pic_md5");
                this.aci = jSONObject.optString("drop_pic_num");
                this.acj = jSONObject.optString("drop_bg_color_day");
                this.ack = jSONObject.optString("drop_bg_color_night");
                this.acl = jSONObject.optString("apply_vip_live_room_pid");
                this.acm = jSONObject.optString("max_cache");
                this.acn = jSONObject.optString("frs_max_cache");
                this.aco = jSONObject.optString("frs_pn");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String vx() {
        return this.acl;
    }

    public String vy() {
        return this.acg;
    }

    public String vz() {
        return this.ach;
    }

    public String vA() {
        return this.aci;
    }

    public String vB() {
        return this.acj;
    }

    public String vC() {
        return this.ack;
    }

    public String vD() {
        return this.acm;
    }

    public String vE() {
        return this.acn;
    }

    public String vF() {
        return this.aco;
    }
}
