package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a activityPrizeData;
    private String bfR;
    private String bfS;
    private String bfT;
    private String bfU;
    private String bfV;
    private String bfW;
    private String bfX;
    private String bfY;
    private long bfZ;
    private int bga;
    private int bgb;
    private long bgc;
    private int bgd;
    private String bgf;
    private String bgg;
    private String bgh;
    public int bgj;
    private String bgl;
    private String bgm;
    private int bgn;
    private long bgo;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int bge = 0;
    private int bgi = 2;
    private String bgk = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bfR = jSONObject.optString("drop_pic");
                this.bfS = jSONObject.optString("drop_pic_md5");
                this.bfT = jSONObject.optString("drop_pic_num");
                this.bfU = jSONObject.optString("drop_bg_color_day");
                this.bfV = jSONObject.optString("drop_bg_color_night");
                this.bfW = jSONObject.optString("apply_vip_live_room_pid");
                this.bgf = jSONObject.optString("max_cache");
                this.bgg = jSONObject.optString("frs_max_cache");
                this.bgh = jSONObject.optString("frs_pn");
                this.bfX = jSONObject.optString("tail_link");
                this.bfY = jSONObject.optString("bubble_link");
                this.bfZ = jSONObject.optLong("use_duration");
                this.bga = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bgm = jSONObject.optString("url_analyze_text");
                this.bgb = jSONObject.optInt("new_resign", 0);
                this.bgc = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bgd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bgi = jSONObject.optInt("localvideo_open", 2);
                this.bgj = jSONObject.optInt("card_show_statistic", 200);
                this.bgk = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Nv().im(jSONObject.optInt("statlog_path_max", 3));
                this.bge = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bgl = jSONObject.optString("nickname_activity_link");
                this.bgn = jSONObject.optInt("android_tab_show", 7);
                this.bgo = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                com.baidu.tieba.im.db.m.qb(jSONObject.optInt("android_max_stranger"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String FL() {
        return this.bfW;
    }

    public String FM() {
        return this.bfR;
    }

    public String FN() {
        return this.bfS;
    }

    public String FO() {
        return this.bfT;
    }

    public String FP() {
        return this.bfU;
    }

    public String FQ() {
        return this.bfV;
    }

    public String FR() {
        return this.bgf;
    }

    public String FS() {
        return this.bgg;
    }

    public String FT() {
        return this.bgh;
    }

    public String FU() {
        return this.bfX;
    }

    public String FV() {
        return this.bfY;
    }

    public long FW() {
        return this.bfZ;
    }

    public int FX() {
        return this.bga;
    }

    public long FY() {
        return this.lastUpdateTime;
    }

    public int FZ() {
        return this.bgn;
    }

    public long Ga() {
        return this.bgc;
    }

    public int Gb() {
        return this.bgd;
    }

    public int Gc() {
        return this.bgb;
    }

    public String Gd() {
        return this.infoIconUrl;
    }

    public String Ge() {
        return this.infoTargetUrl;
    }

    public long Gf() {
        return this.infoTimeStamp;
    }

    public String Gg() {
        return this.bgk;
    }

    public boolean Gh() {
        return this.bgi == 1;
    }

    public int Gi() {
        return this.bge;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Gj() {
        return this.bgl;
    }

    public String Gk() {
        return this.bgm;
    }

    public long Gl() {
        return this.bgo;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }
}
