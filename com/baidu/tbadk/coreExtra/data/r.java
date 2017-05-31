package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String apA;
    private String apB;
    private String apC;
    public int apE;
    private String apl;
    private String apm;
    private String apn;
    private String apo;
    private String apq;
    private String apr;
    private String aps;
    private String apt;
    private int apu;
    private int apv;
    private long apw;
    private int apx;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int apy = 0;
    private int apz = 0;
    private int apD = 2;
    private String apF = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.apl = jSONObject.optString("drop_pic");
                this.apm = jSONObject.optString("drop_pic_md5");
                this.apn = jSONObject.optString("drop_pic_num");
                this.apo = jSONObject.optString("drop_bg_color_day");
                this.apq = jSONObject.optString("drop_bg_color_night");
                this.apr = jSONObject.optString("apply_vip_live_room_pid");
                this.apA = jSONObject.optString("max_cache");
                this.apB = jSONObject.optString("frs_max_cache");
                this.apC = jSONObject.optString("frs_pn");
                this.aps = jSONObject.optString("tail_link");
                this.apt = jSONObject.optString("bubble_link");
                this.apu = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.apv = jSONObject.optInt("new_resign", 0);
                this.apw = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.apx = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.apy = jSONObject.optInt("read_thread_switch", 0);
                this.apD = jSONObject.optInt("localvideo_open", 2);
                this.apE = jSONObject.optInt("card_show_statistic", 200);
                this.apF = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.EZ().eX(jSONObject.optInt("statlog_path_max", 3));
                this.apz = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xQ() {
        return this.apr;
    }

    public String xR() {
        return this.apl;
    }

    public String xS() {
        return this.apm;
    }

    public String xT() {
        return this.apn;
    }

    public String xU() {
        return this.apo;
    }

    public String xV() {
        return this.apq;
    }

    public String xW() {
        return this.apA;
    }

    public String xX() {
        return this.apB;
    }

    public String xY() {
        return this.apC;
    }

    public String xZ() {
        return this.aps;
    }

    public String ya() {
        return this.apt;
    }

    public int yb() {
        return this.apu;
    }

    public long yc() {
        return this.lastUpdateTime;
    }

    public long yd() {
        return this.apw;
    }

    public int ye() {
        return this.apx;
    }

    public int yf() {
        return this.apv;
    }

    public String yg() {
        return this.infoIconUrl;
    }

    public String yh() {
        return this.infoTargetUrl;
    }

    public long yi() {
        return this.infoTimeStamp;
    }

    public int yj() {
        return this.apy;
    }

    public String yk() {
        return this.apF;
    }

    public boolean yl() {
        return this.apD == 1;
    }

    public int ym() {
        return this.apz;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }
}
