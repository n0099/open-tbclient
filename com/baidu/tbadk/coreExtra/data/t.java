package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private String aDKillerUrl;
    private String akd;
    private String ake;
    private String akf;
    private String akg;
    private String akh;
    private String aki;
    private String akj;
    private String akk;
    private int akl;
    private int akm;
    private long akn;
    private int ako;
    private String akq;
    private String akr;
    private String aks;
    private String akt;
    public int akv;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int akp = 0;
    private int aku = 2;
    public int akw = 0;
    public String akx = "";
    public String aky = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akd = jSONObject.optString("drop_pic");
                this.ake = jSONObject.optString("drop_pic_md5");
                this.akf = jSONObject.optString("drop_pic_num");
                this.akg = jSONObject.optString("drop_bg_color_day");
                this.akh = jSONObject.optString("drop_bg_color_night");
                this.aki = jSONObject.optString("apply_vip_live_room_pid");
                this.akq = jSONObject.optString("max_cache");
                this.akr = jSONObject.optString("frs_max_cache");
                this.aks = jSONObject.optString("frs_pn");
                this.akj = jSONObject.optString("tail_link");
                this.akk = jSONObject.optString("bubble_link");
                this.akl = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.akm = jSONObject.optInt("new_resign", 0);
                this.akn = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.ako = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.akt = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.akp = jSONObject.optInt("read_thread_switch", 0);
                this.aku = jSONObject.optInt("localvideo_open", 2);
                this.akv = jSONObject.optInt("card_show_statistic", 200);
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.akw = optJSONObject.optInt("switch", 0);
                    this.akx = optJSONObject.optString("tabName", "");
                    this.aky = optJSONObject.optString("url", "");
                }
                com.baidu.tbadk.pageStayDuration.e.FL().eZ(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xZ() {
        return this.aki;
    }

    public String ya() {
        return this.akd;
    }

    public String yb() {
        return this.ake;
    }

    public String yc() {
        return this.akf;
    }

    public String yd() {
        return this.akg;
    }

    public String ye() {
        return this.akh;
    }

    public String yf() {
        return this.akq;
    }

    public String yg() {
        return this.akr;
    }

    public String yh() {
        return this.aks;
    }

    public String yi() {
        return this.akj;
    }

    public String yj() {
        return this.akk;
    }

    public int yk() {
        return this.akl;
    }

    public long yl() {
        return this.lastUpdateTime;
    }

    public long ym() {
        return this.akn;
    }

    public int yn() {
        return this.ako;
    }

    public int yo() {
        return this.akm;
    }

    public String yp() {
        return this.infoIconUrl;
    }

    public String yq() {
        return this.infoTargetUrl;
    }

    public long yr() {
        return this.infoTimeStamp;
    }

    public String ys() {
        return this.akt;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int yt() {
        return this.akp;
    }

    public int yu() {
        return this.akw;
    }

    public String yv() {
        return this.akx;
    }

    public String yw() {
        return this.aky;
    }

    public boolean yx() {
        return this.aku == 1;
    }
}
