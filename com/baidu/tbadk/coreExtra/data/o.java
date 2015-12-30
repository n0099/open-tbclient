package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private String ajA;
    private String ajB;
    private String ajC;
    private String ajo;
    private String ajp;
    private String ajq;
    private String ajr;
    private String ajs;
    private String ajt;
    private String aju;
    private String ajv;
    private int ajw;
    private int ajx;
    private long ajy;
    private int ajz;
    private long lastUpdateTime;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ajo = jSONObject.optString("drop_pic");
                this.ajp = jSONObject.optString("drop_pic_md5");
                this.ajq = jSONObject.optString("drop_pic_num");
                this.ajr = jSONObject.optString("drop_bg_color_day");
                this.ajs = jSONObject.optString("drop_bg_color_night");
                this.ajt = jSONObject.optString("apply_vip_live_room_pid");
                this.ajA = jSONObject.optString("max_cache");
                this.ajB = jSONObject.optString("frs_max_cache");
                this.ajC = jSONObject.optString("frs_pn");
                this.aju = jSONObject.optString("tail_link");
                this.ajv = jSONObject.optString("bubble_link");
                this.ajw = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ajx = jSONObject.optInt("new_resign", 0);
                this.ajy = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.ajz = jSONObject.optInt("personalized_max_count", 300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xa() {
        return this.ajt;
    }

    public String xb() {
        return this.ajo;
    }

    public String xc() {
        return this.ajp;
    }

    public String xd() {
        return this.ajq;
    }

    public String xe() {
        return this.ajr;
    }

    public String xf() {
        return this.ajs;
    }

    public String xg() {
        return this.ajA;
    }

    public String xh() {
        return this.ajB;
    }

    public String xi() {
        return this.ajC;
    }

    public String xj() {
        return this.aju;
    }

    public String xk() {
        return this.ajv;
    }

    public int xl() {
        return this.ajw;
    }

    public long xm() {
        return this.lastUpdateTime;
    }

    public long xn() {
        return this.ajy;
    }

    public int xo() {
        return this.ajz;
    }

    public int xp() {
        return this.ajx;
    }
}
