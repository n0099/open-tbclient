package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String arA;
    private int arB;
    private String arg;
    private String arh;
    private String ari;
    private String arj;
    private String ark;
    private String arl;
    private String arm;
    private String arn;
    private int aro;
    private int arp;
    private long arq;
    private int arr;
    private String art;
    private String aru;
    private String arv;
    public int arx;
    private String arz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int ars = 0;
    private int arw = 2;
    private String ary = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arg = jSONObject.optString("drop_pic");
                this.arh = jSONObject.optString("drop_pic_md5");
                this.ari = jSONObject.optString("drop_pic_num");
                this.arj = jSONObject.optString("drop_bg_color_day");
                this.ark = jSONObject.optString("drop_bg_color_night");
                this.arl = jSONObject.optString("apply_vip_live_room_pid");
                this.art = jSONObject.optString("max_cache");
                this.aru = jSONObject.optString("frs_max_cache");
                this.arv = jSONObject.optString("frs_pn");
                this.arm = jSONObject.optString("tail_link");
                this.arn = jSONObject.optString("bubble_link");
                this.aro = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.arA = jSONObject.optString("url_analyze_text");
                this.arp = jSONObject.optInt("new_resign", 0);
                this.arq = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arr = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.arw = jSONObject.optInt("localvideo_open", 2);
                this.arx = jSONObject.optInt("card_show_statistic", 200);
                this.ary = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Fx().fp(jSONObject.optInt("statlog_path_max", 3));
                this.ars = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.arz = jSONObject.optString("nickname_activity_link");
                this.arB = jSONObject.optInt("android_tab_show", 7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yc() {
        return this.arl;
    }

    public String yd() {
        return this.arg;
    }

    public String ye() {
        return this.arh;
    }

    public String yf() {
        return this.ari;
    }

    public String yg() {
        return this.arj;
    }

    public String yh() {
        return this.ark;
    }

    public String yi() {
        return this.art;
    }

    public String yj() {
        return this.aru;
    }

    public String yk() {
        return this.arv;
    }

    public String yl() {
        return this.arm;
    }

    public String ym() {
        return this.arn;
    }

    public int yn() {
        return this.aro;
    }

    public long yo() {
        return this.lastUpdateTime;
    }

    public int yp() {
        return this.arB;
    }

    public long yq() {
        return this.arq;
    }

    public int yr() {
        return this.arr;
    }

    public int ys() {
        return this.arp;
    }

    public String yt() {
        return this.infoIconUrl;
    }

    public String yu() {
        return this.infoTargetUrl;
    }

    public long yv() {
        return this.infoTimeStamp;
    }

    public String yw() {
        return this.ary;
    }

    public boolean yx() {
        return this.arw == 1;
    }

    public int yy() {
        return this.ars;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yz() {
        return this.arz;
    }

    public String yA() {
        return this.arA;
    }
}
