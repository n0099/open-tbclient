package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String asA;
    private String asB;
    private int asC;
    private int asD;
    private long asE;
    private int asF;
    private String asI;
    private String asJ;
    private String asK;
    public int asM;
    private String asO;
    private String asP;
    private String asu;
    private String asv;
    private String asw;
    private String asx;
    private String asy;
    private String asz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int asG = 0;
    private int asH = 0;
    private int asL = 2;
    private String asN = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asu = jSONObject.optString("drop_pic");
                this.asv = jSONObject.optString("drop_pic_md5");
                this.asw = jSONObject.optString("drop_pic_num");
                this.asx = jSONObject.optString("drop_bg_color_day");
                this.asy = jSONObject.optString("drop_bg_color_night");
                this.asz = jSONObject.optString("apply_vip_live_room_pid");
                this.asI = jSONObject.optString("max_cache");
                this.asJ = jSONObject.optString("frs_max_cache");
                this.asK = jSONObject.optString("frs_pn");
                this.asA = jSONObject.optString("tail_link");
                this.asB = jSONObject.optString("bubble_link");
                this.asC = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.asP = jSONObject.optString("url_analyze_text");
                this.asD = jSONObject.optInt("new_resign", 0);
                this.asE = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asF = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asG = jSONObject.optInt("read_thread_switch", 0);
                this.asL = jSONObject.optInt("localvideo_open", 2);
                this.asM = jSONObject.optInt("card_show_statistic", 200);
                this.asN = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FU().fe(jSONObject.optInt("statlog_path_max", 3));
                this.asH = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asO = jSONObject.optString("nickname_activity_link");
                new WebCacheWhiteListData().saveString(jSONObject.optString("android_h5cache_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yA() {
        return this.asz;
    }

    public String yB() {
        return this.asu;
    }

    public String yC() {
        return this.asv;
    }

    public String yD() {
        return this.asw;
    }

    public String yE() {
        return this.asx;
    }

    public String yF() {
        return this.asy;
    }

    public String yG() {
        return this.asI;
    }

    public String yH() {
        return this.asJ;
    }

    public String yI() {
        return this.asK;
    }

    public String yJ() {
        return this.asA;
    }

    public String yK() {
        return this.asB;
    }

    public int yL() {
        return this.asC;
    }

    public long yM() {
        return this.lastUpdateTime;
    }

    public long yN() {
        return this.asE;
    }

    public int yO() {
        return this.asF;
    }

    public int yP() {
        return this.asD;
    }

    public String yQ() {
        return this.infoIconUrl;
    }

    public String yR() {
        return this.infoTargetUrl;
    }

    public long yS() {
        return this.infoTimeStamp;
    }

    public int yT() {
        return this.asG;
    }

    public String yU() {
        return this.asN;
    }

    public boolean yV() {
        return this.asL == 1;
    }

    public int yW() {
        return this.asH;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yX() {
        return this.asO;
    }

    public String yY() {
        return this.asP;
    }
}
