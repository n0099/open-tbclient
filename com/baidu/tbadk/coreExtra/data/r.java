package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String arc;
    private String ard;
    private String are;
    private String arf;
    private String arg;
    private String arh;
    private String ari;
    private String arj;
    private int ark;
    private int arl;
    private long arm;
    private int arn;
    private String arq;
    private String arr;
    private String ars;
    public int aru;
    private String arw;
    private String arx;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aro = 0;
    private int arp = 0;
    private int art = 2;
    private String arv = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arc = jSONObject.optString("drop_pic");
                this.ard = jSONObject.optString("drop_pic_md5");
                this.are = jSONObject.optString("drop_pic_num");
                this.arf = jSONObject.optString("drop_bg_color_day");
                this.arg = jSONObject.optString("drop_bg_color_night");
                this.arh = jSONObject.optString("apply_vip_live_room_pid");
                this.arq = jSONObject.optString("max_cache");
                this.arr = jSONObject.optString("frs_max_cache");
                this.ars = jSONObject.optString("frs_pn");
                this.ari = jSONObject.optString("tail_link");
                this.arj = jSONObject.optString("bubble_link");
                this.ark = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.arx = jSONObject.optString("url_analyze_text");
                this.arl = jSONObject.optInt("new_resign", 0);
                this.arm = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arn = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aro = jSONObject.optInt("read_thread_switch", 0);
                this.art = jSONObject.optInt("localvideo_open", 2);
                this.aru = jSONObject.optInt("card_show_statistic", 200);
                this.arv = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FM().fc(jSONObject.optInt("statlog_path_max", 3));
                this.arp = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.arw = jSONObject.optString("nickname_activity_link");
                new WebCacheWhiteListData().saveString(jSONObject.optString("android_h5cache_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String ys() {
        return this.arh;
    }

    public String yt() {
        return this.arc;
    }

    public String yu() {
        return this.ard;
    }

    public String yv() {
        return this.are;
    }

    public String yw() {
        return this.arf;
    }

    public String yx() {
        return this.arg;
    }

    public String yy() {
        return this.arq;
    }

    public String yz() {
        return this.arr;
    }

    public String yA() {
        return this.ars;
    }

    public String yB() {
        return this.ari;
    }

    public String yC() {
        return this.arj;
    }

    public int yD() {
        return this.ark;
    }

    public long yE() {
        return this.lastUpdateTime;
    }

    public long yF() {
        return this.arm;
    }

    public int yG() {
        return this.arn;
    }

    public int yH() {
        return this.arl;
    }

    public String yI() {
        return this.infoIconUrl;
    }

    public String yJ() {
        return this.infoTargetUrl;
    }

    public long yK() {
        return this.infoTimeStamp;
    }

    public int yL() {
        return this.aro;
    }

    public String yM() {
        return this.arv;
    }

    public boolean yN() {
        return this.art == 1;
    }

    public int yO() {
        return this.arp;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yP() {
        return this.arw;
    }

    public String yQ() {
        return this.arx;
    }
}
