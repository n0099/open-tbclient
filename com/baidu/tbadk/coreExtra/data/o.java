package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private String ail;
    private String aim;
    private String ain;
    private String aio;
    private String aip;
    private String aiq;
    private String air;
    private String ais;
    private int ait;
    private String aiu;
    private String aiv;
    private String aiw;
    private long lastUpdateTime;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ail = jSONObject.optString("drop_pic");
                this.aim = jSONObject.optString("drop_pic_md5");
                this.ain = jSONObject.optString("drop_pic_num");
                this.aio = jSONObject.optString("drop_bg_color_day");
                this.aip = jSONObject.optString("drop_bg_color_night");
                this.aiq = jSONObject.optString("apply_vip_live_room_pid");
                this.aiu = jSONObject.optString("max_cache");
                this.aiv = jSONObject.optString("frs_max_cache");
                this.aiw = jSONObject.optString("frs_pn");
                this.air = jSONObject.optString("tail_link");
                this.ais = jSONObject.optString("bubble_link");
                this.ait = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xr() {
        return this.aiq;
    }

    public String xs() {
        return this.ail;
    }

    public String xt() {
        return this.aim;
    }

    public String xu() {
        return this.ain;
    }

    public String xv() {
        return this.aio;
    }

    public String xw() {
        return this.aip;
    }

    public String xx() {
        return this.aiu;
    }

    public String xy() {
        return this.aiv;
    }

    public String xz() {
        return this.aiw;
    }

    public String xA() {
        return this.air;
    }

    public String xB() {
        return this.ais;
    }

    public int xC() {
        return this.ait;
    }

    public long xD() {
        return this.lastUpdateTime;
    }
}
