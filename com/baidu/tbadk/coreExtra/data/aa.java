package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private b activityPrizeData;
    private long ajK;
    private String chM;
    private String chN;
    private String chO;
    private String chP;
    private String chQ;
    private String chR;
    private String chS;
    private String chT;
    private long chU;
    private int chV;
    private int chW;
    private long chX;
    private int chY;
    private v ciB;
    private boolean ciC;
    private boolean ciD;
    private String ciE;
    private String cia;
    private String cib;
    private String cic;
    public int cif;
    private String cih;
    private String cii;
    private int cij;
    private int cik;
    private int cil;
    private int cim;
    private long cin;
    private long cio;
    private t cip;
    private String ciq;
    private String ciu;
    private String ciw;
    private int cix;
    private long ciy;
    private long ciz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int chZ = 0;
    private int cie = 2;
    private String cig = "";
    private int cir = 0;
    private int cis = 0;
    private int cit = 0;
    private int civ = 0;
    private boolean ciA = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.chM = jSONObject.optString("drop_pic");
                this.chN = jSONObject.optString("drop_pic_md5");
                this.chO = jSONObject.optString("drop_pic_num");
                this.chP = jSONObject.optString("drop_bg_color_day");
                this.chQ = jSONObject.optString("drop_bg_color_night");
                this.chR = jSONObject.optString("apply_vip_live_room_pid");
                this.cia = jSONObject.optString("max_cache");
                this.cib = jSONObject.optString("frs_max_cache");
                this.cic = jSONObject.optString("frs_pn");
                this.chS = jSONObject.optString("tail_link");
                this.chT = jSONObject.optString("bubble_link");
                this.chU = jSONObject.optLong("use_duration");
                this.chV = jSONObject.optInt("xiaoying_time");
                this.ajK = jSONObject.optLong("last_update_time", 0L);
                this.cii = jSONObject.optString("url_analyze_text");
                this.chW = jSONObject.optInt("new_resign", 0);
                this.chX = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.chY = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.cie = jSONObject.optInt("localvideo_open", 2);
                this.cif = jSONObject.optInt("card_show_statistic", 200);
                this.cig = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.avn().kT(jSONObject.optInt("statlog_path_max", 3));
                this.chZ = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.cih = jSONObject.optString("nickname_activity_link");
                this.cij = jSONObject.optInt("android_tab_show", 23);
                this.cik = jSONObject.optInt("ribao_switch", 0);
                this.cil = jSONObject.optInt("default_page", 0);
                this.cim = jSONObject.optInt("remember_page", 0);
                this.cin = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.cio = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cip = new t();
                    this.cip.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_game_video", optString6);
                    }
                }
                com.baidu.tieba.im.db.n.vw(jSONObject.optInt("android_max_stranger"));
                this.cir = jSONObject.optInt("style_ab_switch", 0);
                this.cis = jSONObject.optInt("abstract_ab_switch", 0);
                this.ciq = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_video_splash_config", this.ciq);
                this.cit = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.ciu = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.ciu)) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_baidu_password_re", this.ciu);
                }
                this.ciw = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.ciw)) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_redpacket_pop", this.ciw);
                }
                this.cix = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_video_guide_max_count", this.cix);
                this.civ = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_concern_tab_tips_switch", this.civ);
                this.ciy = jSONObject.optInt("dialog_pull_time", 60) * aq.bUj;
                this.ciz = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.ciA = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString7 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString7)) {
                    if (this.ciB == null) {
                        this.ciB = new v();
                    }
                    this.ciB.parserJson(optString7);
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("shake_data", optString7);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.ciC = false;
                } else if (optInt == 1) {
                    this.ciC = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("pb_fold_small_flow_json", this.ciC);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.ciD = false;
                } else if (optInt2 == 1) {
                    this.ciD = true;
                }
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("person_center_show_lite_game", this.ciD);
                this.ciE = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("profile_swan_app_key", this.ciE);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                q.po(jSONObject.optString("js_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String anb() {
        return this.chR;
    }

    public String anc() {
        return this.chM;
    }

    public String and() {
        return this.chN;
    }

    public String ane() {
        return this.chO;
    }

    public String anf() {
        return this.chP;
    }

    public String ang() {
        return this.chQ;
    }

    public String anh() {
        return this.cia;
    }

    public String ani() {
        return this.cib;
    }

    public String anj() {
        return this.cic;
    }

    public String ank() {
        return this.chS;
    }

    public String anl() {
        return this.chT;
    }

    public long anm() {
        return this.chU;
    }

    public int ann() {
        return this.chV;
    }

    public long ano() {
        return this.ajK;
    }

    public int anp() {
        return this.cij;
    }

    public int anq() {
        return this.cik;
    }

    public int anr() {
        return this.cil;
    }

    public int ans() {
        return this.cim;
    }

    public long ant() {
        return this.chX;
    }

    public int anu() {
        return this.chY;
    }

    public int anv() {
        return this.chW;
    }

    public String anw() {
        return this.infoIconUrl;
    }

    public String anx() {
        return this.infoTargetUrl;
    }

    public long any() {
        return this.infoTimeStamp;
    }

    public String anz() {
        return this.cig;
    }

    public boolean anA() {
        return this.cie == 1;
    }

    public int anB() {
        return this.chZ;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String anC() {
        return this.cih;
    }

    public String anD() {
        return this.cii;
    }

    public long anE() {
        return this.cin;
    }

    public long anF() {
        return this.cio;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int anG() {
        return this.cir;
    }

    public int anH() {
        return this.cis;
    }

    public t anI() {
        return this.cip;
    }

    public int anJ() {
        return this.cit;
    }

    public long anK() {
        return this.ciy;
    }

    public long anL() {
        return this.ciz;
    }

    public boolean anM() {
        return this.ciA;
    }

    public v anN() {
        return this.ciB;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean anO() {
        return this.ciC;
    }

    public boolean anP() {
        return this.ciD;
    }

    public String anQ() {
        return this.ciE;
    }

    public String getSampleId() {
        return this.mSampleId;
    }
}
