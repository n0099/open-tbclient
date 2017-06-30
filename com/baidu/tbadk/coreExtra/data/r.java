package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String aqA;
    private String aqB;
    public int aqD;
    private String aqF;
    private String aqG;
    private String aql;
    private String aqm;
    private String aqn;
    private String aqo;
    private String aqp;
    private String aqq;
    private String aqr;
    private String aqs;
    private int aqt;
    private int aqu;
    private long aqv;
    private int aqw;
    private String aqz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aqx = 0;
    private int aqy = 0;
    private int aqC = 2;
    private String aqE = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aql = jSONObject.optString("drop_pic");
                this.aqm = jSONObject.optString("drop_pic_md5");
                this.aqn = jSONObject.optString("drop_pic_num");
                this.aqo = jSONObject.optString("drop_bg_color_day");
                this.aqp = jSONObject.optString("drop_bg_color_night");
                this.aqq = jSONObject.optString("apply_vip_live_room_pid");
                this.aqz = jSONObject.optString("max_cache");
                this.aqA = jSONObject.optString("frs_max_cache");
                this.aqB = jSONObject.optString("frs_pn");
                this.aqr = jSONObject.optString("tail_link");
                this.aqs = jSONObject.optString("bubble_link");
                this.aqt = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aqG = jSONObject.optString("url_analyze_text");
                this.aqu = jSONObject.optInt("new_resign", 0);
                this.aqv = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aqw = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aqx = jSONObject.optInt("read_thread_switch", 0);
                this.aqC = jSONObject.optInt("localvideo_open", 2);
                this.aqD = jSONObject.optInt("card_show_statistic", 200);
                this.aqE = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Fw().eZ(jSONObject.optInt("statlog_path_max", 3));
                this.aqy = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aqF = jSONObject.optString("nickname_activity_link");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yh() {
        return this.aqq;
    }

    public String yi() {
        return this.aql;
    }

    public String yj() {
        return this.aqm;
    }

    public String yk() {
        return this.aqn;
    }

    public String yl() {
        return this.aqo;
    }

    public String ym() {
        return this.aqp;
    }

    public String yn() {
        return this.aqz;
    }

    public String yo() {
        return this.aqA;
    }

    public String yp() {
        return this.aqB;
    }

    public String yq() {
        return this.aqr;
    }

    public String yr() {
        return this.aqs;
    }

    public int ys() {
        return this.aqt;
    }

    public long yt() {
        return this.lastUpdateTime;
    }

    public long yu() {
        return this.aqv;
    }

    public int yv() {
        return this.aqw;
    }

    public int yw() {
        return this.aqu;
    }

    public String yx() {
        return this.infoIconUrl;
    }

    public String yy() {
        return this.infoTargetUrl;
    }

    public long yz() {
        return this.infoTimeStamp;
    }

    public int yA() {
        return this.aqx;
    }

    public String yB() {
        return this.aqE;
    }

    public boolean yC() {
        return this.aqC == 1;
    }

    public int yD() {
        return this.aqy;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yE() {
        return this.aqF;
    }

    public String yF() {
        return this.aqG;
    }
}
