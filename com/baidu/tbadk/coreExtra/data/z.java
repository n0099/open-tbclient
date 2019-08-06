package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private long ajm;
    private String cgR;
    private String cgS;
    private String cgT;
    private String cgU;
    private String cgV;
    private String cgW;
    private String cgX;
    private String cgY;
    private long cgZ;
    private String chA;
    private int chB;
    private long chC;
    private long chD;
    private u chF;
    private boolean chG;
    private boolean chH;
    private String chI;
    private int cha;
    private int chb;
    private long chc;
    private int chd;
    private String chf;
    private String chg;
    private String chh;
    public int chj;
    private String chl;
    private String chm;
    private int chn;
    private int cho;
    private int chp;
    private int chq;
    private long chr;
    private long chs;
    private s cht;
    private String chu;
    private String chy;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int che = 0;
    private int chi = 2;
    private String chk = "";
    private int chv = 0;
    private int chw = 0;
    private int chx = 0;
    private int chz = 0;
    private boolean chE = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cgR = jSONObject.optString("drop_pic");
                this.cgS = jSONObject.optString("drop_pic_md5");
                this.cgT = jSONObject.optString("drop_pic_num");
                this.cgU = jSONObject.optString("drop_bg_color_day");
                this.cgV = jSONObject.optString("drop_bg_color_night");
                this.cgW = jSONObject.optString("apply_vip_live_room_pid");
                this.chf = jSONObject.optString("max_cache");
                this.chg = jSONObject.optString("frs_max_cache");
                this.chh = jSONObject.optString("frs_pn");
                this.cgX = jSONObject.optString("tail_link");
                this.cgY = jSONObject.optString("bubble_link");
                this.cgZ = jSONObject.optLong("use_duration");
                this.cha = jSONObject.optInt("xiaoying_time");
                this.ajm = jSONObject.optLong("last_update_time", 0L);
                this.chm = jSONObject.optString("url_analyze_text");
                this.chb = jSONObject.optInt("new_resign", 0);
                this.chc = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.chd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.chi = jSONObject.optInt("localvideo_open", 2);
                this.chj = jSONObject.optInt("card_show_statistic", 200);
                this.chk = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.avb().kQ(jSONObject.optInt("statlog_path_max", 3));
                this.che = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.chl = jSONObject.optString("nickname_activity_link");
                this.chn = jSONObject.optInt("android_tab_show", 23);
                this.cho = jSONObject.optInt("ribao_switch", 0);
                this.chp = jSONObject.optInt("default_page", 0);
                this.chq = jSONObject.optInt("remember_page", 0);
                this.chr = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.chs = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cht = new s();
                    this.cht.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_game_video", optString6);
                    }
                }
                com.baidu.tieba.im.db.n.vs(jSONObject.optInt("android_max_stranger"));
                this.chv = jSONObject.optInt("style_ab_switch", 0);
                this.chw = jSONObject.optInt("abstract_ab_switch", 0);
                this.chu = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_video_splash_config", this.chu);
                this.chx = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.chy = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.chy)) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_baidu_password_re", this.chy);
                }
                this.chA = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.chA)) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_redpacket_pop", this.chA);
                }
                this.chB = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_video_guide_max_count", this.chB);
                this.chz = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_concern_tab_tips_switch", this.chz);
                this.chC = jSONObject.optInt("dialog_pull_time", 60) * aq.bTG;
                this.chD = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.chE = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString7 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString7)) {
                    if (this.chF == null) {
                        this.chF = new u();
                    }
                    this.chF.parserJson(optString7);
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("shake_data", optString7);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.chG = false;
                } else if (optInt == 1) {
                    this.chG = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("pb_fold_small_flow_json", this.chG);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.chH = false;
                } else if (optInt2 == 1) {
                    this.chH = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("person_center_show_lite_game", this.chH);
                this.chI = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("profile_swan_app_key", this.chI);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.ahQ().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String amP() {
        return this.cgW;
    }

    public String amQ() {
        return this.cgR;
    }

    public String amR() {
        return this.cgS;
    }

    public String amS() {
        return this.cgT;
    }

    public String amT() {
        return this.cgU;
    }

    public String amU() {
        return this.cgV;
    }

    public String amV() {
        return this.chf;
    }

    public String amW() {
        return this.chg;
    }

    public String amX() {
        return this.chh;
    }

    public String amY() {
        return this.cgX;
    }

    public String amZ() {
        return this.cgY;
    }

    public long ana() {
        return this.cgZ;
    }

    public int anb() {
        return this.cha;
    }

    public long anc() {
        return this.ajm;
    }

    public int and() {
        return this.chn;
    }

    public int ane() {
        return this.cho;
    }

    public int anf() {
        return this.chp;
    }

    public int ang() {
        return this.chq;
    }

    public long anh() {
        return this.chc;
    }

    public int ani() {
        return this.chd;
    }

    public int anj() {
        return this.chb;
    }

    public String ank() {
        return this.infoIconUrl;
    }

    public String anl() {
        return this.infoTargetUrl;
    }

    public long anm() {
        return this.infoTimeStamp;
    }

    public String ann() {
        return this.chk;
    }

    public boolean ano() {
        return this.chi == 1;
    }

    public int anp() {
        return this.che;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String anq() {
        return this.chl;
    }

    public String anr() {
        return this.chm;
    }

    public long ans() {
        return this.chr;
    }

    public long ant() {
        return this.chs;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int anu() {
        return this.chv;
    }

    public int anv() {
        return this.chw;
    }

    public s anw() {
        return this.cht;
    }

    public int anx() {
        return this.chx;
    }

    public long any() {
        return this.chC;
    }

    public long anz() {
        return this.chD;
    }

    public boolean anA() {
        return this.chE;
    }

    public u anB() {
        return this.chF;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean anC() {
        return this.chG;
    }

    public boolean anD() {
        return this.chH;
    }

    public String anE() {
        return this.chI;
    }
}
