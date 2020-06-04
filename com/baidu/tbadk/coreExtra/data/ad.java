package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private b activityPrizeData;
    private String axG;
    private String axs;
    private String axz;
    private long bES;
    private String ebM;
    private String ebN;
    private String ebO;
    private String ebP;
    private String ebQ;
    private String ebR;
    private String ebS;
    private String ebT;
    private long ebU;
    private int ebV;
    private int ebW;
    private long ebX;
    private int ebY;
    private x ecB;
    private boolean ecC;
    private boolean ecD;
    private String ecE;
    private String ecF;
    private String ecG;
    private String ecH;
    private String ecI;
    private int ecJ;
    private String eca;
    private String ecb;
    private String ecc;
    public int ece;
    private String ecg;
    private String ech;
    private int eci;
    private int ecj;
    private int eck;
    private int ecl;
    private long ecm;
    private boolean ecn;
    private long eco;
    private v ecp;
    private String ecq;
    private String ecu;
    private String ecw;
    private int ecx;
    private long ecy;
    private long ecz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceObjSource;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String mWalletSignLink;
    private String uegVoiceWarning;
    private int ebZ = 0;
    private int ecd = 2;
    private String ecf = "";
    private int ecr = 0;
    private int ecs = 0;
    private int ect = 0;
    private int ecv = 0;
    private boolean ecA = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ebM = jSONObject.optString("drop_pic");
                this.ebN = jSONObject.optString("drop_pic_md5");
                this.ebO = jSONObject.optString("drop_pic_num");
                this.ebP = jSONObject.optString("drop_bg_color_day");
                this.ebQ = jSONObject.optString("drop_bg_color_night");
                this.ebR = jSONObject.optString("apply_vip_live_room_pid");
                this.eca = jSONObject.optString("max_cache");
                this.ecb = jSONObject.optString("frs_max_cache");
                this.ecc = jSONObject.optString("frs_pn");
                this.ebS = jSONObject.optString("tail_link");
                this.ebT = jSONObject.optString("bubble_link");
                this.ebU = jSONObject.optLong("use_duration");
                this.ebV = jSONObject.optInt("xiaoying_time");
                this.bES = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.ech = jSONObject.optString("url_analyze_text");
                this.ebW = jSONObject.optInt("new_resign", 0);
                this.ebX = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.ebY = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ecd = jSONObject.optInt("localvideo_open", 2);
                this.ece = jSONObject.optInt("card_show_statistic", 200);
                this.ecf = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bfv().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.ebZ = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.ecg = jSONObject.optString("nickname_activity_link");
                this.eci = jSONObject.optInt("android_tab_show", 55);
                this.ecj = jSONObject.optInt("ribao_switch", 0);
                this.eck = jSONObject.optInt("default_page", 0);
                this.ecl = jSONObject.optInt("remember_page", 0);
                this.ecm = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.eco = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.ecn = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.ecn);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.ecp = new v();
                    this.ecp.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.xB(jSONObject.optInt("android_max_stranger"));
                this.ecr = jSONObject.optInt("style_ab_switch", 0);
                this.ecs = jSONObject.optInt("abstract_ab_switch", 0);
                this.ecq = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.ecq);
                this.ect = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.ecu = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.ecu)) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_baidu_password_re", this.ecu);
                }
                this.ecw = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.ecw)) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_redpacket_pop", this.ecw);
                }
                this.ecx = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_video_guide_max_count", this.ecx);
                this.ecv = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_concern_tab_tips_switch", this.ecv);
                this.ecy = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.ecz = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.ecA = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.ecB == null) {
                        this.ecB = new x();
                    }
                    this.ecB.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.ecC = false;
                } else if (optInt == 1) {
                    this.ecC = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("pb_fold_small_flow_json", this.ecC);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.ecD = false;
                } else if (optInt2 == 1) {
                    this.ecD = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("person_center_show_lite_game", this.ecD);
                this.ecE = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("profile_swan_app_key", this.ecE);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                s.xi(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bfr().yA(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong("plugin_wait_time", optLong);
                }
                this.axs = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_game_frs_live_tab_video_url", this.axs);
                this.axz = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_personal_income_detail_url", this.axz);
                this.ecF = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_personal_privilege_detail_url", this.ecF);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.axG = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("show_live_forum_url", this.axG);
                    this.ecG = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("show_live_forum_name", this.ecG);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.ecH = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.ecI = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_my_live_privilege_mark_detail_url", this.ecH);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_my_live_privilege_effect_detail_url", this.ecI);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.ecJ = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt("baidu_financial_display", this.ecJ);
                }
                String optString12 = jSONObject.optString("live_bar");
                eu(optString12);
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                y yVar = new y();
                yVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(yVar);
                String optString13 = jSONObject.optString("BackMechanism_sid1");
                String optString14 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_pb_back_sid1", optString13);
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_pb_back_sid2", optString14);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void eu(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aTX().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aYu() {
        return this.liveForumMap;
    }

    public String aYv() {
        return this.ebR;
    }

    public String aYw() {
        return this.ebM;
    }

    public String aYx() {
        return this.ebN;
    }

    public String aYy() {
        return this.ebO;
    }

    public String aYz() {
        return this.ebP;
    }

    public String aYA() {
        return this.ebQ;
    }

    public String aYB() {
        return this.eca;
    }

    public String aYC() {
        return this.ecb;
    }

    public String aYD() {
        return this.ecc;
    }

    public String aYE() {
        return this.ebS;
    }

    public String aYF() {
        return this.ebT;
    }

    public long aYG() {
        return this.ebU;
    }

    public int aYH() {
        return this.ebV;
    }

    public long aYI() {
        return this.bES;
    }

    public int aYJ() {
        return this.eci;
    }

    public int aYK() {
        return this.ecj;
    }

    public int aYL() {
        return this.eck;
    }

    public int aYM() {
        return this.ecl;
    }

    public long aYN() {
        return this.ebX;
    }

    public int aYO() {
        return this.ebY;
    }

    public int aYP() {
        return this.ebW;
    }

    public String aYQ() {
        return this.infoIconUrl;
    }

    public String aYR() {
        return this.infoTargetUrl;
    }

    public long aYS() {
        return this.infoTimeStamp;
    }

    public String aYT() {
        return this.ecf;
    }

    public boolean aYU() {
        return this.ecd == 1;
    }

    public int aYV() {
        return this.ebZ;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aYW() {
        return this.ecg;
    }

    public String aYX() {
        return this.ech;
    }

    public long aYY() {
        return this.ecm;
    }

    public boolean aYZ() {
        return this.ecn;
    }

    public long aZa() {
        return this.eco;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aZb() {
        return this.ecr;
    }

    public int aZc() {
        return this.ecs;
    }

    public v aZd() {
        return this.ecp;
    }

    public int aZe() {
        return this.ect;
    }

    public long aZf() {
        return this.ecy;
    }

    public long aZg() {
        return this.ecz;
    }

    public boolean aZh() {
        return this.ecA;
    }

    public x aZi() {
        return this.ecB;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aZj() {
        return this.ecC;
    }

    public boolean aZk() {
        return this.ecD;
    }

    public String aZl() {
        return this.ecE;
    }

    public String getMissionEntranceUrl() {
        return this.mMissionEntranceUrl;
    }

    public String getMissionEntranceIcon() {
        return this.mMissionEntranceIcon;
    }

    public String getMissionEntranceObjSource() {
        return this.mMissionEntranceObjSource;
    }

    public String getWalletSignLink() {
        return this.mWalletSignLink;
    }

    public String getSampleId() {
        return this.mSampleId;
    }
}
