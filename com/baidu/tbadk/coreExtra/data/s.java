package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private a activityPrizeData;
    private int arA;
    private int arB;
    private long arC;
    private int arD;
    private String arF;
    private String arG;
    private String arH;
    public int arJ;
    private String arL;
    private String arM;
    private int arN;
    private String arr;
    private String ars;
    private String art;
    private String aru;
    private String arv;
    private String arw;
    private String arx;
    private String ary;
    private long arz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int arE = 0;
    private int arI = 2;
    private String arK = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arr = jSONObject.optString("drop_pic");
                this.ars = jSONObject.optString("drop_pic_md5");
                this.art = jSONObject.optString("drop_pic_num");
                this.aru = jSONObject.optString("drop_bg_color_day");
                this.arv = jSONObject.optString("drop_bg_color_night");
                this.arw = jSONObject.optString("apply_vip_live_room_pid");
                this.arF = jSONObject.optString("max_cache");
                this.arG = jSONObject.optString("frs_max_cache");
                this.arH = jSONObject.optString("frs_pn");
                this.arx = jSONObject.optString("tail_link");
                this.ary = jSONObject.optString("bubble_link");
                this.arz = jSONObject.optLong("use_duration");
                this.arA = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.arM = jSONObject.optString("url_analyze_text");
                this.arB = jSONObject.optInt("new_resign", 0);
                this.arC = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arD = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.arI = jSONObject.optInt("localvideo_open", 2);
                this.arJ = jSONObject.optInt("card_show_statistic", 200);
                this.arK = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FO().fo(jSONObject.optInt("statlog_path_max", 3));
                this.arE = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.arL = jSONObject.optString("nickname_activity_link");
                this.arN = jSONObject.optInt("android_tab_show", 7);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.h(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                com.baidu.tieba.im.db.m.mO(jSONObject.optInt("android_max_stranger"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yk() {
        return this.arw;
    }

    public String yl() {
        return this.arr;
    }

    public String ym() {
        return this.ars;
    }

    public String yn() {
        return this.art;
    }

    public String yo() {
        return this.aru;
    }

    public String yp() {
        return this.arv;
    }

    public String yq() {
        return this.arF;
    }

    public String yr() {
        return this.arG;
    }

    public String ys() {
        return this.arH;
    }

    public String yt() {
        return this.arx;
    }

    public String yu() {
        return this.ary;
    }

    public long yv() {
        return this.arz;
    }

    public int yw() {
        return this.arA;
    }

    public long yx() {
        return this.lastUpdateTime;
    }

    public int yy() {
        return this.arN;
    }

    public long yz() {
        return this.arC;
    }

    public int yA() {
        return this.arD;
    }

    public int yB() {
        return this.arB;
    }

    public String yC() {
        return this.infoIconUrl;
    }

    public String yD() {
        return this.infoTargetUrl;
    }

    public long yE() {
        return this.infoTimeStamp;
    }

    public String yF() {
        return this.arK;
    }

    public boolean yG() {
        return this.arI == 1;
    }

    public int yH() {
        return this.arE;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yI() {
        return this.arL;
    }

    public String yJ() {
        return this.arM;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }
}
