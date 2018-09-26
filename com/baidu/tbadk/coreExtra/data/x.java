package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private String aFJ;
    private String aFK;
    private String aFL;
    private String aFM;
    private String aFN;
    private String aFO;
    private String aFP;
    private String aFQ;
    private long aFR;
    private int aFS;
    private int aFT;
    private long aFU;
    private int aFV;
    private String aFX;
    private String aFY;
    private String aFZ;
    public int aGb;
    private String aGd;
    private String aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGi;
    private long aGj;
    private r aGk;
    private String aGl;
    private String aGp;
    private String aGr;
    private int aGs;
    private long aGt;
    private long aGu;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aFW = 0;
    private int aGa = 2;
    private String aGc = "";
    private int aGm = 0;
    private int aGn = 0;
    private int aGo = 0;
    private int aGq = 0;
    private boolean aGv = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aFJ = jSONObject.optString("drop_pic");
                this.aFK = jSONObject.optString("drop_pic_md5");
                this.aFL = jSONObject.optString("drop_pic_num");
                this.aFM = jSONObject.optString("drop_bg_color_day");
                this.aFN = jSONObject.optString("drop_bg_color_night");
                this.aFO = jSONObject.optString("apply_vip_live_room_pid");
                this.aFX = jSONObject.optString("max_cache");
                this.aFY = jSONObject.optString("frs_max_cache");
                this.aFZ = jSONObject.optString("frs_pn");
                this.aFP = jSONObject.optString("tail_link");
                this.aFQ = jSONObject.optString("bubble_link");
                this.aFR = jSONObject.optLong("use_duration");
                this.aFS = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aGe = jSONObject.optString("url_analyze_text");
                this.aFT = jSONObject.optInt("new_resign", 0);
                this.aFU = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aFV = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aGa = jSONObject.optInt("localvideo_open", 2);
                this.aGb = jSONObject.optInt("card_show_statistic", 200);
                this.aGc = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.LG().fw(jSONObject.optInt("statlog_path_max", 3));
                this.aFW = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aGd = jSONObject.optString("nickname_activity_link");
                this.aGf = jSONObject.optInt("android_tab_show", 7);
                this.aGg = jSONObject.optInt("ribao_switch", 0);
                this.aGh = jSONObject.optInt("default_page", 0);
                this.aGi = jSONObject.optInt("remember_page", 0);
                this.aGj = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aGk = new r();
                    this.aGk.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString("concern", "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_daily", optString4);
                    }
                }
                com.baidu.tieba.im.db.n.oD(jSONObject.optInt("android_max_stranger"));
                this.aGm = jSONObject.optInt("style_ab_switch", 0);
                this.aGn = jSONObject.optInt("abstract_ab_switch", 0);
                this.aGl = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aGl);
                this.aGo = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aGp = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aGp)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aGp);
                }
                this.aGr = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aGr)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aGr);
                }
                this.aGs = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aGs);
                this.aGq = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aGq);
                this.aGt = jSONObject.optInt("dialog_pull_time", 60) * ao.atp;
                this.aGu = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aGv = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String DN() {
        return this.aFO;
    }

    public String DO() {
        return this.aFJ;
    }

    public String DP() {
        return this.aFK;
    }

    public String DQ() {
        return this.aFL;
    }

    public String DR() {
        return this.aFM;
    }

    public String DS() {
        return this.aFN;
    }

    public String DT() {
        return this.aFX;
    }

    public String DU() {
        return this.aFY;
    }

    public String DV() {
        return this.aFZ;
    }

    public String DW() {
        return this.aFP;
    }

    public String DX() {
        return this.aFQ;
    }

    public long DY() {
        return this.aFR;
    }

    public int DZ() {
        return this.aFS;
    }

    public long Ea() {
        return this.lastUpdateTime;
    }

    public int Eb() {
        return this.aGf;
    }

    public int Ec() {
        return this.aGg;
    }

    public int Ed() {
        return this.aGh;
    }

    public int Ee() {
        return this.aGi;
    }

    public long Ef() {
        return this.aFU;
    }

    public int Eg() {
        return this.aFV;
    }

    public int Eh() {
        return this.aFT;
    }

    public String Ei() {
        return this.infoIconUrl;
    }

    public String Ej() {
        return this.infoTargetUrl;
    }

    public long Ek() {
        return this.infoTimeStamp;
    }

    public String El() {
        return this.aGc;
    }

    public boolean Em() {
        return this.aGa == 1;
    }

    public int En() {
        return this.aFW;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Eo() {
        return this.aGd;
    }

    public String Ep() {
        return this.aGe;
    }

    public long Eq() {
        return this.aGj;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Er() {
        return this.aGm;
    }

    public int Es() {
        return this.aGn;
    }

    public r Et() {
        return this.aGk;
    }

    public int Eu() {
        return this.aGo;
    }

    public long Ev() {
        return this.aGt;
    }

    public long Ew() {
        return this.aGu;
    }

    public boolean Ex() {
        return this.aGv;
    }
}
