package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String agA;
    private int agB;
    private long agC;
    private String agD;
    private String agE;
    private String agF;
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
                this.agt = jSONObject.optString("drop_pic");
                this.agu = jSONObject.optString("drop_pic_md5");
                this.agv = jSONObject.optString("drop_pic_num");
                this.agw = jSONObject.optString("drop_bg_color_day");
                this.agx = jSONObject.optString("drop_bg_color_night");
                this.agy = jSONObject.optString("apply_vip_live_room_pid");
                this.agD = jSONObject.optString("max_cache");
                this.agE = jSONObject.optString("frs_max_cache");
                this.agF = jSONObject.optString("frs_pn");
                this.agz = jSONObject.optString("tail_link");
                this.agA = jSONObject.optString("bubble_link");
                this.agB = jSONObject.optInt("xiaoying_time");
                this.agC = jSONObject.optLong("last_update_time", 0L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wu() {
        return this.agy;
    }

    public String wv() {
        return this.agt;
    }

    public String ww() {
        return this.agu;
    }

    public String wx() {
        return this.agv;
    }

    public String wy() {
        return this.agw;
    }

    public String wz() {
        return this.agx;
    }

    public String wA() {
        return this.agD;
    }

    public String wB() {
        return this.agE;
    }

    public String wC() {
        return this.agF;
    }

    public String wD() {
        return this.agz;
    }

    public String wE() {
        return this.agA;
    }

    public int wF() {
        return this.agB;
    }

    public long wG() {
        return this.agC;
    }
}
