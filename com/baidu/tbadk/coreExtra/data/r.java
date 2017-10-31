package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String arA;
    private String arB;
    public int arD;
    private String arF;
    private String arG;
    private int arH;
    private String arl;
    private String arm;
    private String arn;
    private String aro;
    private String arp;
    private String arq;
    private String arr;
    private String ars;
    private long art;
    private int aru;
    private int arv;
    private long arw;
    private int arx;
    private String arz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int ary = 0;
    private int arC = 2;
    private String arE = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arl = jSONObject.optString("drop_pic");
                this.arm = jSONObject.optString("drop_pic_md5");
                this.arn = jSONObject.optString("drop_pic_num");
                this.aro = jSONObject.optString("drop_bg_color_day");
                this.arp = jSONObject.optString("drop_bg_color_night");
                this.arq = jSONObject.optString("apply_vip_live_room_pid");
                this.arz = jSONObject.optString("max_cache");
                this.arA = jSONObject.optString("frs_max_cache");
                this.arB = jSONObject.optString("frs_pn");
                this.arr = jSONObject.optString("tail_link");
                this.ars = jSONObject.optString("bubble_link");
                this.art = jSONObject.optLong("use_duration");
                this.aru = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.arG = jSONObject.optString("url_analyze_text");
                this.arv = jSONObject.optInt("new_resign", 0);
                this.arw = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arx = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.arC = jSONObject.optInt("localvideo_open", 2);
                this.arD = jSONObject.optInt("card_show_statistic", 200);
                this.arE = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FD().fp(jSONObject.optInt("statlog_path_max", 3));
                this.ary = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.arF = jSONObject.optString("nickname_activity_link");
                this.arH = jSONObject.optInt("android_tab_show", 7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yc() {
        return this.arq;
    }

    public String yd() {
        return this.arl;
    }

    public String ye() {
        return this.arm;
    }

    public String yf() {
        return this.arn;
    }

    public String yg() {
        return this.aro;
    }

    public String yh() {
        return this.arp;
    }

    public String yi() {
        return this.arz;
    }

    public String yj() {
        return this.arA;
    }

    public String yk() {
        return this.arB;
    }

    public String yl() {
        return this.arr;
    }

    public String ym() {
        return this.ars;
    }

    public long yn() {
        return this.art;
    }

    public int yo() {
        return this.aru;
    }

    public long yp() {
        return this.lastUpdateTime;
    }

    public int yq() {
        return this.arH;
    }

    public long yr() {
        return this.arw;
    }

    public int ys() {
        return this.arx;
    }

    public int yt() {
        return this.arv;
    }

    public String yu() {
        return this.infoIconUrl;
    }

    public String yv() {
        return this.infoTargetUrl;
    }

    public long yw() {
        return this.infoTimeStamp;
    }

    public String yx() {
        return this.arE;
    }

    public boolean yy() {
        return this.arC == 1;
    }

    public int yz() {
        return this.ary;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yA() {
        return this.arF;
    }

    public String yB() {
        return this.arG;
    }
}
