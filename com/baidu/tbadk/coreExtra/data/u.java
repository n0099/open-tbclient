package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private a activityPrizeData;
    private long bgA;
    private int bgB;
    private String bgD;
    private String bgE;
    private String bgF;
    public int bgH;
    private String bgJ;
    private String bgK;
    private int bgL;
    private long bgM;
    private q bgO;
    private String bgo;
    private String bgp;
    private String bgq;
    private String bgr;
    private String bgt;
    private String bgu;
    private String bgv;
    private String bgw;
    private long bgx;
    private int bgy;
    private int bgz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int bgC = 0;
    private int bgG = 2;
    private String bgI = "";
    private int bgN = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bgo = jSONObject.optString("drop_pic");
                this.bgp = jSONObject.optString("drop_pic_md5");
                this.bgq = jSONObject.optString("drop_pic_num");
                this.bgr = jSONObject.optString("drop_bg_color_day");
                this.bgt = jSONObject.optString("drop_bg_color_night");
                this.bgu = jSONObject.optString("apply_vip_live_room_pid");
                this.bgD = jSONObject.optString("max_cache");
                this.bgE = jSONObject.optString("frs_max_cache");
                this.bgF = jSONObject.optString("frs_pn");
                this.bgv = jSONObject.optString("tail_link");
                this.bgw = jSONObject.optString("bubble_link");
                this.bgx = jSONObject.optLong("use_duration");
                this.bgy = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bgK = jSONObject.optString("url_analyze_text");
                this.bgz = jSONObject.optInt("new_resign", 0);
                this.bgA = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bgB = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bgG = jSONObject.optInt("localvideo_open", 2);
                this.bgH = jSONObject.optInt("card_show_statistic", 200);
                this.bgI = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Nl().ii(jSONObject.optInt("statlog_path_max", 3));
                this.bgC = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bgJ = jSONObject.optString("nickname_activity_link");
                this.bgL = jSONObject.optInt("android_tab_show", 7);
                this.bgM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bgO = new q();
                    this.bgO.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.m.pU(jSONObject.optInt("android_max_stranger"));
                this.bgN = jSONObject.optInt("style_ab_switch", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String FE() {
        return this.bgu;
    }

    public String FF() {
        return this.bgo;
    }

    public String FG() {
        return this.bgp;
    }

    public String FH() {
        return this.bgq;
    }

    public String FI() {
        return this.bgr;
    }

    public String FJ() {
        return this.bgt;
    }

    public String FK() {
        return this.bgD;
    }

    public String FL() {
        return this.bgE;
    }

    public String FM() {
        return this.bgF;
    }

    public String FN() {
        return this.bgv;
    }

    public String FO() {
        return this.bgw;
    }

    public long FP() {
        return this.bgx;
    }

    public int FQ() {
        return this.bgy;
    }

    public long FR() {
        return this.lastUpdateTime;
    }

    public int FS() {
        return this.bgL;
    }

    public long FT() {
        return this.bgA;
    }

    public int FU() {
        return this.bgB;
    }

    public int FV() {
        return this.bgz;
    }

    public String FW() {
        return this.infoIconUrl;
    }

    public String FX() {
        return this.infoTargetUrl;
    }

    public long FY() {
        return this.infoTimeStamp;
    }

    public String FZ() {
        return this.bgI;
    }

    public boolean Ga() {
        return this.bgG == 1;
    }

    public int Gb() {
        return this.bgC;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Gc() {
        return this.bgJ;
    }

    public String Gd() {
        return this.bgK;
    }

    public long Ge() {
        return this.bgM;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Gf() {
        return this.bgN;
    }

    public q Gg() {
        return this.bgO;
    }
}
