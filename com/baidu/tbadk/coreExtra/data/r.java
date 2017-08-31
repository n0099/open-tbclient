package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String asb;
    private String asc;
    private String asd;
    private String ase;
    private String asf;
    private String asg;
    private String ash;
    private String asi;
    private int asj;
    private int ask;
    private long asl;
    private int asm;
    private String asp;
    private String asq;
    private String asr;
    public int ast;
    private String asv;
    private String asw;
    private int asx;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int asn = 0;
    private int aso = 0;
    private int ass = 2;
    private String asu = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asb = jSONObject.optString("drop_pic");
                this.asc = jSONObject.optString("drop_pic_md5");
                this.asd = jSONObject.optString("drop_pic_num");
                this.ase = jSONObject.optString("drop_bg_color_day");
                this.asf = jSONObject.optString("drop_bg_color_night");
                this.asg = jSONObject.optString("apply_vip_live_room_pid");
                this.asp = jSONObject.optString("max_cache");
                this.asq = jSONObject.optString("frs_max_cache");
                this.asr = jSONObject.optString("frs_pn");
                this.ash = jSONObject.optString("tail_link");
                this.asi = jSONObject.optString("bubble_link");
                this.asj = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.asw = jSONObject.optString("url_analyze_text");
                this.ask = jSONObject.optInt("new_resign", 0);
                this.asl = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asm = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asn = jSONObject.optInt("read_thread_switch", 0);
                this.ass = jSONObject.optInt("localvideo_open", 2);
                this.ast = jSONObject.optInt("card_show_statistic", 200);
                this.asu = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FS().fe(jSONObject.optInt("statlog_path_max", 3));
                this.aso = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asv = jSONObject.optString("nickname_activity_link");
                this.asx = jSONObject.optInt("android_tab_show", 7);
                new WebCacheWhiteListData().saveString(jSONObject.optString("android_h5cache_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yD() {
        return this.asg;
    }

    public String yE() {
        return this.asb;
    }

    public String yF() {
        return this.asc;
    }

    public String yG() {
        return this.asd;
    }

    public String yH() {
        return this.ase;
    }

    public String yI() {
        return this.asf;
    }

    public String yJ() {
        return this.asp;
    }

    public String yK() {
        return this.asq;
    }

    public String yL() {
        return this.asr;
    }

    public String yM() {
        return this.ash;
    }

    public String yN() {
        return this.asi;
    }

    public int yO() {
        return this.asj;
    }

    public long yP() {
        return this.lastUpdateTime;
    }

    public int yQ() {
        return this.asx;
    }

    public long yR() {
        return this.asl;
    }

    public int yS() {
        return this.asm;
    }

    public int yT() {
        return this.ask;
    }

    public String yU() {
        return this.infoIconUrl;
    }

    public String yV() {
        return this.infoTargetUrl;
    }

    public long yW() {
        return this.infoTimeStamp;
    }

    public int yX() {
        return this.asn;
    }

    public String yY() {
        return this.asu;
    }

    public boolean yZ() {
        return this.ass == 1;
    }

    public int za() {
        return this.aso;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String zb() {
        return this.asv;
    }

    public String zc() {
        return this.asw;
    }
}
