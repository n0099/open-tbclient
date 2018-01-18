package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private a activityPrizeData;
    private String bgB;
    private String bgC;
    private int bgD;
    private long bgE;
    private q bgG;
    private String bgg;
    private String bgh;
    private String bgi;
    private String bgj;
    private String bgk;
    private String bgl;
    private String bgm;
    private String bgn;
    private long bgo;
    private int bgp;
    private int bgq;
    private long bgr;
    private int bgt;
    private String bgv;
    private String bgw;
    private String bgx;
    public int bgz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int bgu = 0;
    private int bgy = 2;
    private String bgA = "";
    private int bgF = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bgg = jSONObject.optString("drop_pic");
                this.bgh = jSONObject.optString("drop_pic_md5");
                this.bgi = jSONObject.optString("drop_pic_num");
                this.bgj = jSONObject.optString("drop_bg_color_day");
                this.bgk = jSONObject.optString("drop_bg_color_night");
                this.bgl = jSONObject.optString("apply_vip_live_room_pid");
                this.bgv = jSONObject.optString("max_cache");
                this.bgw = jSONObject.optString("frs_max_cache");
                this.bgx = jSONObject.optString("frs_pn");
                this.bgm = jSONObject.optString("tail_link");
                this.bgn = jSONObject.optString("bubble_link");
                this.bgo = jSONObject.optLong("use_duration");
                this.bgp = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bgC = jSONObject.optString("url_analyze_text");
                this.bgq = jSONObject.optInt("new_resign", 0);
                this.bgr = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bgt = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bgy = jSONObject.optInt("localvideo_open", 2);
                this.bgz = jSONObject.optInt("card_show_statistic", 200);
                this.bgA = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Nj().ii(jSONObject.optInt("statlog_path_max", 3));
                this.bgu = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bgB = jSONObject.optString("nickname_activity_link");
                this.bgD = jSONObject.optInt("android_tab_show", 7);
                this.bgE = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bgG = new q();
                    this.bgG.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.m.pU(jSONObject.optInt("android_max_stranger"));
                this.bgF = jSONObject.optInt("style_ab_switch", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String FC() {
        return this.bgl;
    }

    public String FD() {
        return this.bgg;
    }

    public String FE() {
        return this.bgh;
    }

    public String FF() {
        return this.bgi;
    }

    public String FG() {
        return this.bgj;
    }

    public String FH() {
        return this.bgk;
    }

    public String FI() {
        return this.bgv;
    }

    public String FJ() {
        return this.bgw;
    }

    public String FK() {
        return this.bgx;
    }

    public String FL() {
        return this.bgm;
    }

    public String FM() {
        return this.bgn;
    }

    public long FN() {
        return this.bgo;
    }

    public int FO() {
        return this.bgp;
    }

    public long FP() {
        return this.lastUpdateTime;
    }

    public int FQ() {
        return this.bgD;
    }

    public long FR() {
        return this.bgr;
    }

    public int FS() {
        return this.bgt;
    }

    public int FT() {
        return this.bgq;
    }

    public String FU() {
        return this.infoIconUrl;
    }

    public String FV() {
        return this.infoTargetUrl;
    }

    public long FW() {
        return this.infoTimeStamp;
    }

    public String FX() {
        return this.bgA;
    }

    public boolean FY() {
        return this.bgy == 1;
    }

    public int FZ() {
        return this.bgu;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Ga() {
        return this.bgB;
    }

    public String Gb() {
        return this.bgC;
    }

    public long Gc() {
        return this.bgE;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Gd() {
        return this.bgF;
    }

    public q Ge() {
        return this.bgG;
    }
}
