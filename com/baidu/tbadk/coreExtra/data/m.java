package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String agA;
    private String agB;
    private String agC;
    private String agD;
    private String agE;
    private String agF;
    private String agG;
    private int agH;
    private long agI;
    private String agJ;
    private String agK;
    private String agL;
    private String agz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agz = jSONObject.optString("drop_pic");
                this.agA = jSONObject.optString("drop_pic_md5");
                this.agB = jSONObject.optString("drop_pic_num");
                this.agC = jSONObject.optString("drop_bg_color_day");
                this.agD = jSONObject.optString("drop_bg_color_night");
                this.agE = jSONObject.optString("apply_vip_live_room_pid");
                this.agJ = jSONObject.optString("max_cache");
                this.agK = jSONObject.optString("frs_max_cache");
                this.agL = jSONObject.optString("frs_pn");
                this.agF = jSONObject.optString("tail_link");
                this.agG = jSONObject.optString("bubble_link");
                this.agH = jSONObject.optInt("xiaoying_time");
                this.agI = jSONObject.optLong("last_update_time", 0L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String ww() {
        return this.agE;
    }

    public String wx() {
        return this.agz;
    }

    public String wy() {
        return this.agA;
    }

    public String wz() {
        return this.agB;
    }

    public String wA() {
        return this.agC;
    }

    public String wB() {
        return this.agD;
    }

    public String wC() {
        return this.agJ;
    }

    public String wD() {
        return this.agK;
    }

    public String wE() {
        return this.agL;
    }

    public String wF() {
        return this.agF;
    }

    public String wG() {
        return this.agG;
    }

    public int wH() {
        return this.agH;
    }

    public long wI() {
        return this.agI;
    }
}
