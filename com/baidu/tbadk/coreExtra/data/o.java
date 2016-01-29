package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private String aDKillerUrl;
    private String akb;
    private String akc;
    private String akd;
    private String ake;
    private String akf;
    private String akg;
    private String akh;
    private String aki;
    private int akj;
    private int akk;
    private long akl;
    private int akm;
    private int akn = 0;
    private String ako;
    private String akp;
    private String akq;
    private String akr;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akb = jSONObject.optString("drop_pic");
                this.akc = jSONObject.optString("drop_pic_md5");
                this.akd = jSONObject.optString("drop_pic_num");
                this.ake = jSONObject.optString("drop_bg_color_day");
                this.akf = jSONObject.optString("drop_bg_color_night");
                this.akg = jSONObject.optString("apply_vip_live_room_pid");
                this.ako = jSONObject.optString("max_cache");
                this.akp = jSONObject.optString("frs_max_cache");
                this.akq = jSONObject.optString("frs_pn");
                this.akh = jSONObject.optString("tail_link");
                this.aki = jSONObject.optString("bubble_link");
                this.akj = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.akk = jSONObject.optInt("new_resign", 0);
                this.akl = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.akm = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.akr = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.akn = jSONObject.optInt("read_thread_switch", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yn() {
        return this.akg;
    }

    public String yo() {
        return this.akb;
    }

    public String yp() {
        return this.akc;
    }

    public String yq() {
        return this.akd;
    }

    public String yr() {
        return this.ake;
    }

    public String ys() {
        return this.akf;
    }

    public String yt() {
        return this.ako;
    }

    public String yu() {
        return this.akp;
    }

    public String yv() {
        return this.akq;
    }

    public String yw() {
        return this.akh;
    }

    public String yx() {
        return this.aki;
    }

    public int yy() {
        return this.akj;
    }

    public long yz() {
        return this.lastUpdateTime;
    }

    public long yA() {
        return this.akl;
    }

    public int yB() {
        return this.akm;
    }

    public int yC() {
        return this.akk;
    }

    public String yD() {
        return this.infoIconUrl;
    }

    public String yE() {
        return this.infoTargetUrl;
    }

    public long yF() {
        return this.infoTimeStamp;
    }

    public String yG() {
        return this.akr;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int yH() {
        return this.akn;
    }
}
