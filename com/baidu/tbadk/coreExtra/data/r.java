package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String asA;
    private String asB;
    private String asC;
    private int asD;
    private int asE;
    private long asF;
    private int asG;
    private String asJ;
    private String asK;
    private String asL;
    public int asN;
    private String asP;
    private String asQ;
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
    private int asH = 0;
    private int asI = 0;
    private int asM = 2;
    private String asO = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asv = jSONObject.optString("drop_pic");
                this.asw = jSONObject.optString("drop_pic_md5");
                this.asx = jSONObject.optString("drop_pic_num");
                this.asy = jSONObject.optString("drop_bg_color_day");
                this.asz = jSONObject.optString("drop_bg_color_night");
                this.asA = jSONObject.optString("apply_vip_live_room_pid");
                this.asJ = jSONObject.optString("max_cache");
                this.asK = jSONObject.optString("frs_max_cache");
                this.asL = jSONObject.optString("frs_pn");
                this.asB = jSONObject.optString("tail_link");
                this.asC = jSONObject.optString("bubble_link");
                this.asD = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.asQ = jSONObject.optString("url_analyze_text");
                this.asE = jSONObject.optInt("new_resign", 0);
                this.asF = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asG = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asH = jSONObject.optInt("read_thread_switch", 0);
                this.asM = jSONObject.optInt("localvideo_open", 2);
                this.asN = jSONObject.optInt("card_show_statistic", 200);
                this.asO = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FU().fe(jSONObject.optInt("statlog_path_max", 3));
                this.asI = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asP = jSONObject.optString("nickname_activity_link");
                new WebCacheWhiteListData().saveString(jSONObject.optString("android_h5cache_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yA() {
        return this.asA;
    }

    public String yB() {
        return this.asv;
    }

    public String yC() {
        return this.asw;
    }

    public String yD() {
        return this.asx;
    }

    public String yE() {
        return this.asy;
    }

    public String yF() {
        return this.asz;
    }

    public String yG() {
        return this.asJ;
    }

    public String yH() {
        return this.asK;
    }

    public String yI() {
        return this.asL;
    }

    public String yJ() {
        return this.asB;
    }

    public String yK() {
        return this.asC;
    }

    public int yL() {
        return this.asD;
    }

    public long yM() {
        return this.lastUpdateTime;
    }

    public long yN() {
        return this.asF;
    }

    public int yO() {
        return this.asG;
    }

    public int yP() {
        return this.asE;
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
        return this.asH;
    }

    public String yU() {
        return this.asO;
    }

    public boolean yV() {
        return this.asM == 1;
    }

    public int yW() {
        return this.asI;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yX() {
        return this.asP;
    }

    public String yY() {
        return this.asQ;
    }
}
