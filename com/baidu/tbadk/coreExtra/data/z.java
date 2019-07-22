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
    private String cgK;
    private String cgL;
    private String cgM;
    private String cgN;
    private String cgO;
    private String cgP;
    private String cgQ;
    private String cgR;
    private long cgS;
    private int cgT;
    private int cgU;
    private long cgV;
    private int cgW;
    private String cgY;
    private String cgZ;
    private boolean chA;
    private String chB;
    private String cha;
    public int chc;
    private String che;
    private String chf;
    private int chg;
    private int chh;
    private int chi;
    private int chj;
    private long chk;
    private long chl;
    private s chm;
    private String chn;
    private String chr;
    private String cht;
    private int chu;
    private long chv;
    private long chw;
    private u chy;
    private boolean chz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int cgX = 0;
    private int chb = 2;
    private String chd = "";
    private int cho = 0;
    private int chp = 0;
    private int chq = 0;
    private int chs = 0;
    private boolean chx = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cgK = jSONObject.optString("drop_pic");
                this.cgL = jSONObject.optString("drop_pic_md5");
                this.cgM = jSONObject.optString("drop_pic_num");
                this.cgN = jSONObject.optString("drop_bg_color_day");
                this.cgO = jSONObject.optString("drop_bg_color_night");
                this.cgP = jSONObject.optString("apply_vip_live_room_pid");
                this.cgY = jSONObject.optString("max_cache");
                this.cgZ = jSONObject.optString("frs_max_cache");
                this.cha = jSONObject.optString("frs_pn");
                this.cgQ = jSONObject.optString("tail_link");
                this.cgR = jSONObject.optString("bubble_link");
                this.cgS = jSONObject.optLong("use_duration");
                this.cgT = jSONObject.optInt("xiaoying_time");
                this.ajm = jSONObject.optLong("last_update_time", 0L);
                this.chf = jSONObject.optString("url_analyze_text");
                this.cgU = jSONObject.optInt("new_resign", 0);
                this.cgV = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.cgW = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.chb = jSONObject.optInt("localvideo_open", 2);
                this.chc = jSONObject.optInt("card_show_statistic", 200);
                this.chd = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.auZ().kP(jSONObject.optInt("statlog_path_max", 3));
                this.cgX = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.che = jSONObject.optString("nickname_activity_link");
                this.chg = jSONObject.optInt("android_tab_show", 23);
                this.chh = jSONObject.optInt("ribao_switch", 0);
                this.chi = jSONObject.optInt("default_page", 0);
                this.chj = jSONObject.optInt("remember_page", 0);
                this.chk = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.chl = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.chm = new s();
                    this.chm.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_game_video", optString6);
                    }
                }
                com.baidu.tieba.im.db.n.vq(jSONObject.optInt("android_max_stranger"));
                this.cho = jSONObject.optInt("style_ab_switch", 0);
                this.chp = jSONObject.optInt("abstract_ab_switch", 0);
                this.chn = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_video_splash_config", this.chn);
                this.chq = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.chr = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.chr)) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_baidu_password_re", this.chr);
                }
                this.cht = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.cht)) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_redpacket_pop", this.cht);
                }
                this.chu = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_video_guide_max_count", this.chu);
                this.chs = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_concern_tab_tips_switch", this.chs);
                this.chv = jSONObject.optInt("dialog_pull_time", 60) * aq.bTA;
                this.chw = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.chx = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString7 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString7)) {
                    if (this.chy == null) {
                        this.chy = new u();
                    }
                    this.chy.parserJson(optString7);
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("shake_data", optString7);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.chz = false;
                } else if (optInt == 1) {
                    this.chz = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("pb_fold_small_flow_json", this.chz);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.chA = false;
                } else if (optInt2 == 1) {
                    this.chA = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("person_center_show_lite_game", this.chA);
                this.chB = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.ahO().putString("profile_swan_app_key", this.chB);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String amN() {
        return this.cgP;
    }

    public String amO() {
        return this.cgK;
    }

    public String amP() {
        return this.cgL;
    }

    public String amQ() {
        return this.cgM;
    }

    public String amR() {
        return this.cgN;
    }

    public String amS() {
        return this.cgO;
    }

    public String amT() {
        return this.cgY;
    }

    public String amU() {
        return this.cgZ;
    }

    public String amV() {
        return this.cha;
    }

    public String amW() {
        return this.cgQ;
    }

    public String amX() {
        return this.cgR;
    }

    public long amY() {
        return this.cgS;
    }

    public int amZ() {
        return this.cgT;
    }

    public long ana() {
        return this.ajm;
    }

    public int anb() {
        return this.chg;
    }

    public int anc() {
        return this.chh;
    }

    public int and() {
        return this.chi;
    }

    public int ane() {
        return this.chj;
    }

    public long anf() {
        return this.cgV;
    }

    public int ang() {
        return this.cgW;
    }

    public int anh() {
        return this.cgU;
    }

    public String ani() {
        return this.infoIconUrl;
    }

    public String anj() {
        return this.infoTargetUrl;
    }

    public long ank() {
        return this.infoTimeStamp;
    }

    public String anl() {
        return this.chd;
    }

    public boolean anm() {
        return this.chb == 1;
    }

    public int ann() {
        return this.cgX;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String ano() {
        return this.che;
    }

    public String anp() {
        return this.chf;
    }

    public long anq() {
        return this.chk;
    }

    public long anr() {
        return this.chl;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int ans() {
        return this.cho;
    }

    public int ant() {
        return this.chp;
    }

    public s anu() {
        return this.chm;
    }

    public int anv() {
        return this.chq;
    }

    public long anw() {
        return this.chv;
    }

    public long anx() {
        return this.chw;
    }

    public boolean any() {
        return this.chx;
    }

    public u anz() {
        return this.chy;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean anA() {
        return this.chz;
    }

    public boolean anB() {
        return this.chA;
    }

    public String anC() {
        return this.chB;
    }

    public String getMissionEntranceUrl() {
        return this.mMissionEntranceUrl;
    }

    public String getMissionEntranceIcon() {
        return this.mMissionEntranceIcon;
    }
}
