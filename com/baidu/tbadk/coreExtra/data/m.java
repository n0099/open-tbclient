package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int agA;
    private long agB;
    private String agC;
    private String agD;
    private String agE;
    private String ags;
    private String agt;
    private String agu;
    private String agv;
    private String agw;
    private String agx;
    private String agy;
    private String agz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ags = jSONObject.optString("drop_pic");
                this.agt = jSONObject.optString("drop_pic_md5");
                this.agu = jSONObject.optString("drop_pic_num");
                this.agv = jSONObject.optString("drop_bg_color_day");
                this.agw = jSONObject.optString("drop_bg_color_night");
                this.agx = jSONObject.optString("apply_vip_live_room_pid");
                this.agC = jSONObject.optString("max_cache");
                this.agD = jSONObject.optString("frs_max_cache");
                this.agE = jSONObject.optString("frs_pn");
                this.agy = jSONObject.optString("tail_link");
                this.agz = jSONObject.optString("bubble_link");
                this.agA = jSONObject.optInt("xiaoying_time");
                this.agB = jSONObject.optLong("last_update_time", 0L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wu() {
        return this.agx;
    }

    public String wv() {
        return this.ags;
    }

    public String ww() {
        return this.agt;
    }

    public String wx() {
        return this.agu;
    }

    public String wy() {
        return this.agv;
    }

    public String wz() {
        return this.agw;
    }

    public String wA() {
        return this.agC;
    }

    public String wB() {
        return this.agD;
    }

    public String wC() {
        return this.agE;
    }

    public String wD() {
        return this.agy;
    }

    public String wE() {
        return this.agz;
    }

    public int wF() {
        return this.agA;
    }

    public long wG() {
        return this.agB;
    }
}
