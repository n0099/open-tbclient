package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String aqU;
    private String aqV;
    private String aqW;
    private String aqX;
    private String aqY;
    private String aqZ;
    private String ara;
    private String arb;
    private long arc;
    private int ard;
    private int are;
    private long arf;
    private int arg;
    private String ari;
    private String arj;
    private String ark;
    public int arm;
    private String aro;
    private String arp;
    private int arq;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int arh = 0;
    private int arl = 2;
    private String arn = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqU = jSONObject.optString("drop_pic");
                this.aqV = jSONObject.optString("drop_pic_md5");
                this.aqW = jSONObject.optString("drop_pic_num");
                this.aqX = jSONObject.optString("drop_bg_color_day");
                this.aqY = jSONObject.optString("drop_bg_color_night");
                this.aqZ = jSONObject.optString("apply_vip_live_room_pid");
                this.ari = jSONObject.optString("max_cache");
                this.arj = jSONObject.optString("frs_max_cache");
                this.ark = jSONObject.optString("frs_pn");
                this.ara = jSONObject.optString("tail_link");
                this.arb = jSONObject.optString("bubble_link");
                this.arc = jSONObject.optLong("use_duration");
                this.ard = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.arp = jSONObject.optString("url_analyze_text");
                this.are = jSONObject.optInt("new_resign", 0);
                this.arf = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arg = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.arl = jSONObject.optInt("localvideo_open", 2);
                this.arm = jSONObject.optInt("card_show_statistic", 200);
                this.arn = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Fr().fo(jSONObject.optInt("statlog_path_max", 3));
                this.arh = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aro = jSONObject.optString("nickname_activity_link");
                this.arq = jSONObject.optInt("android_tab_show", 7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xV() {
        return this.aqZ;
    }

    public String xW() {
        return this.aqU;
    }

    public String xX() {
        return this.aqV;
    }

    public String xY() {
        return this.aqW;
    }

    public String xZ() {
        return this.aqX;
    }

    public String ya() {
        return this.aqY;
    }

    public String yb() {
        return this.ari;
    }

    public String yc() {
        return this.arj;
    }

    public String yd() {
        return this.ark;
    }

    public String ye() {
        return this.ara;
    }

    public String yf() {
        return this.arb;
    }

    public long yg() {
        return this.arc;
    }

    public int yh() {
        return this.ard;
    }

    public long yi() {
        return this.lastUpdateTime;
    }

    public int yj() {
        return this.arq;
    }

    public long yk() {
        return this.arf;
    }

    public int yl() {
        return this.arg;
    }

    public int ym() {
        return this.are;
    }

    public String yn() {
        return this.infoIconUrl;
    }

    public String yo() {
        return this.infoTargetUrl;
    }

    public long yp() {
        return this.infoTimeStamp;
    }

    public String yq() {
        return this.arn;
    }

    public boolean yr() {
        return this.arl == 1;
    }

    public int ys() {
        return this.arh;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yt() {
        return this.aro;
    }

    public String yu() {
        return this.arp;
    }
}
