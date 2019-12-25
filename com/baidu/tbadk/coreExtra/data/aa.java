package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String XC;
    private String XJ;
    private String XQ;
    private long aTe;
    private b activityPrizeData;
    private String diB;
    private String diC;
    private String diD;
    private String diE;
    private String diF;
    private String diG;
    private String diH;
    private String diI;
    private long diJ;
    private int diK;
    private int diL;
    private long diM;
    private int diN;
    private String diP;
    private String diQ;
    private String diR;
    public int diT;
    private String diV;
    private String diW;
    private int diX;
    private int diY;
    private int diZ;
    private int dja;
    private long djb;
    private long djc;
    private t djd;
    private String dje;
    private String dji;
    private String djk;
    private int djl;
    private long djm;
    private long djn;
    private v djp;
    private boolean djq;
    private boolean djr;
    private String djs;
    private String djt;
    private String dju;
    private String djv;
    private String djw;
    private int djx;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String mWalletSignLink;
    private String uegVoiceWarning;
    private int diO = 0;
    private int diS = 2;
    private String diU = "";
    private int djf = 0;
    private int djg = 0;
    private int djh = 0;
    private int djj = 0;
    private boolean djo = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.diB = jSONObject.optString("drop_pic");
                this.diC = jSONObject.optString("drop_pic_md5");
                this.diD = jSONObject.optString("drop_pic_num");
                this.diE = jSONObject.optString("drop_bg_color_day");
                this.diF = jSONObject.optString("drop_bg_color_night");
                this.diG = jSONObject.optString("apply_vip_live_room_pid");
                this.diP = jSONObject.optString("max_cache");
                this.diQ = jSONObject.optString("frs_max_cache");
                this.diR = jSONObject.optString("frs_pn");
                this.diH = jSONObject.optString("tail_link");
                this.diI = jSONObject.optString("bubble_link");
                this.diJ = jSONObject.optLong("use_duration");
                this.diK = jSONObject.optInt("xiaoying_time");
                this.aTe = jSONObject.optLong("last_update_time", 0L);
                this.diW = jSONObject.optString("url_analyze_text");
                this.diL = jSONObject.optInt("new_resign", 0);
                this.diM = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.diN = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.diS = jSONObject.optInt("localvideo_open", 2);
                this.diT = jSONObject.optInt("card_show_statistic", 200);
                this.diU = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aOm().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.diO = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.diV = jSONObject.optString("nickname_activity_link");
                this.diX = jSONObject.optInt("android_tab_show", 23);
                this.diY = jSONObject.optInt("ribao_switch", 0);
                this.diZ = jSONObject.optInt("default_page", 0);
                this.dja = jSONObject.optInt("remember_page", 0);
                this.djb = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.djc = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.djd = new t();
                    this.djd.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wc(jSONObject.optInt("android_max_stranger"));
                this.djf = jSONObject.optInt("style_ab_switch", 0);
                this.djg = jSONObject.optInt("abstract_ab_switch", 0);
                this.dje = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dje);
                this.djh = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dji = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dji)) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_baidu_password_re", this.dji);
                }
                this.djk = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.djk)) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_redpacket_pop", this.djk);
                }
                this.djl = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_video_guide_max_count", this.djl);
                this.djj = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_concern_tab_tips_switch", this.djj);
                this.djm = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.djn = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.djo = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.djp == null) {
                        this.djp = new v();
                    }
                    this.djp.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.djq = false;
                } else if (optInt == 1) {
                    this.djq = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("pb_fold_small_flow_json", this.djq);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.djr = false;
                } else if (optInt2 == 1) {
                    this.djr = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("person_center_show_lite_game", this.djr);
                this.djs = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("profile_swan_app_key", this.djs);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                q.tP(jSONObject.optString("js_whitelist"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putLong("plugin_wait_time", optLong);
                }
                this.XC = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_game_frs_live_tab_video_url", this.XC);
                this.XJ = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_personal_income_detail_url", this.XJ);
                this.djt = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_personal_privilege_detail_url", this.djt);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.XQ = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("show_live_forum_url", this.XQ);
                    this.dju = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("show_live_forum_name", this.dju);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.djv = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.djw = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_my_live_privilege_mark_detail_url", this.djv);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_my_live_privilege_effect_detail_url", this.djw);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.djx = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt("baidu_financial_display", this.djx);
                }
                String optString12 = jSONObject.optString("live_bar");
                cN(optString12);
                com.baidu.tbadk.core.sharedPref.b.aCY().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cN(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aCY().getString("ala_live_bar_map_str", "");
            if (StringUtils.isNull(str)) {
                return;
            }
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("id", 0L);
                    this.liveForumMap.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                }
            }
        }
    }

    public HashMap<Long, String> aGY() {
        return this.liveForumMap;
    }

    public String aGZ() {
        return this.diG;
    }

    public String aHa() {
        return this.diB;
    }

    public String aHb() {
        return this.diC;
    }

    public String aHc() {
        return this.diD;
    }

    public String aHd() {
        return this.diE;
    }

    public String aHe() {
        return this.diF;
    }

    public String aHf() {
        return this.diP;
    }

    public String aHg() {
        return this.diQ;
    }

    public String aHh() {
        return this.diR;
    }

    public String aHi() {
        return this.diH;
    }

    public String aHj() {
        return this.diI;
    }

    public long aHk() {
        return this.diJ;
    }

    public int aHl() {
        return this.diK;
    }

    public long aHm() {
        return this.aTe;
    }

    public int aHn() {
        return this.diX;
    }

    public int aHo() {
        return this.diY;
    }

    public int aHp() {
        return this.diZ;
    }

    public int aHq() {
        return this.dja;
    }

    public long aHr() {
        return this.diM;
    }

    public int aHs() {
        return this.diN;
    }

    public int aHt() {
        return this.diL;
    }

    public String aHu() {
        return this.infoIconUrl;
    }

    public String aHv() {
        return this.infoTargetUrl;
    }

    public long aHw() {
        return this.infoTimeStamp;
    }

    public String aHx() {
        return this.diU;
    }

    public boolean aHy() {
        return this.diS == 1;
    }

    public int aHz() {
        return this.diO;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aHA() {
        return this.diV;
    }

    public String aHB() {
        return this.diW;
    }

    public long aHC() {
        return this.djb;
    }

    public long aHD() {
        return this.djc;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aHE() {
        return this.djf;
    }

    public int aHF() {
        return this.djg;
    }

    public t aHG() {
        return this.djd;
    }

    public int aHH() {
        return this.djh;
    }

    public long aHI() {
        return this.djm;
    }

    public long aHJ() {
        return this.djn;
    }

    public boolean aHK() {
        return this.djo;
    }

    public v aHL() {
        return this.djp;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aHM() {
        return this.djq;
    }

    public boolean aHN() {
        return this.djr;
    }

    public String aHO() {
        return this.djs;
    }

    public String getMissionEntranceUrl() {
        return this.mMissionEntranceUrl;
    }

    public String getMissionEntranceIcon() {
        return this.mMissionEntranceIcon;
    }

    public String getWalletSignLink() {
        return this.mWalletSignLink;
    }

    public String getSampleId() {
        return this.mSampleId;
    }
}
