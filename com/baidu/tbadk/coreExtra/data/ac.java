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
public class ac {
    private b activityPrizeData;
    private String asA;
    private String asl;
    private String ast;
    private long bxk;
    private int dNA;
    private int dNB;
    private long dNC;
    private int dND;
    private String dNF;
    private String dNG;
    private String dNH;
    public int dNJ;
    private String dNL;
    private String dNM;
    private int dNN;
    private int dNO;
    private int dNP;
    private int dNQ;
    private long dNR;
    private long dNS;
    private u dNT;
    private String dNU;
    private String dNY;
    private String dNr;
    private String dNs;
    private String dNt;
    private String dNu;
    private String dNv;
    private String dNw;
    private String dNx;
    private String dNy;
    private long dNz;
    private String dOa;
    private int dOb;
    private long dOc;
    private long dOd;
    private w dOf;
    private boolean dOg;
    private boolean dOh;
    private String dOi;
    private String dOj;
    private String dOk;
    private String dOl;
    private String dOm;
    private int dOn;
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
    private int dNE = 0;
    private int dNI = 2;
    private String dNK = "";
    private int dNV = 0;
    private int dNW = 0;
    private int dNX = 0;
    private int dNZ = 0;
    private boolean dOe = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dNr = jSONObject.optString("drop_pic");
                this.dNs = jSONObject.optString("drop_pic_md5");
                this.dNt = jSONObject.optString("drop_pic_num");
                this.dNu = jSONObject.optString("drop_bg_color_day");
                this.dNv = jSONObject.optString("drop_bg_color_night");
                this.dNw = jSONObject.optString("apply_vip_live_room_pid");
                this.dNF = jSONObject.optString("max_cache");
                this.dNG = jSONObject.optString("frs_max_cache");
                this.dNH = jSONObject.optString("frs_pn");
                this.dNx = jSONObject.optString("tail_link");
                this.dNy = jSONObject.optString("bubble_link");
                this.dNz = jSONObject.optLong("use_duration");
                this.dNA = jSONObject.optInt("xiaoying_time");
                this.bxk = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.dNM = jSONObject.optString("url_analyze_text");
                this.dNB = jSONObject.optInt("new_resign", 0);
                this.dNC = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.dND = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dNI = jSONObject.optInt("localvideo_open", 2);
                this.dNJ = jSONObject.optInt("card_show_statistic", 200);
                this.dNK = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aZm().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dNE = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.dNL = jSONObject.optString("nickname_activity_link");
                this.dNN = jSONObject.optInt("android_tab_show", 55);
                this.dNO = jSONObject.optInt("ribao_switch", 0);
                this.dNP = jSONObject.optInt("default_page", 0);
                this.dNQ = jSONObject.optInt("remember_page", 0);
                this.dNR = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.dNS = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.dNT = new u();
                    this.dNT.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wT(jSONObject.optInt("android_max_stranger"));
                this.dNV = jSONObject.optInt("style_ab_switch", 0);
                this.dNW = jSONObject.optInt("abstract_ab_switch", 0);
                this.dNU = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dNU);
                this.dNX = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dNY = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dNY)) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_baidu_password_re", this.dNY);
                }
                this.dOa = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.dOa)) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_redpacket_pop", this.dOa);
                }
                this.dOb = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_video_guide_max_count", this.dOb);
                this.dNZ = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_concern_tab_tips_switch", this.dNZ);
                this.dOc = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.dOd = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.dOe = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.dOf == null) {
                        this.dOf = new w();
                    }
                    this.dOf.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.dOg = false;
                } else if (optInt == 1) {
                    this.dOg = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("pb_fold_small_flow_json", this.dOg);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.dOh = false;
                } else if (optInt2 == 1) {
                    this.dOh = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("person_center_show_lite_game", this.dOh);
                this.dOi = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("profile_swan_app_key", this.dOi);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                r.vz(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.aZi().wR(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putLong("plugin_wait_time", optLong);
                }
                this.asl = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_game_frs_live_tab_video_url", this.asl);
                this.ast = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_personal_income_detail_url", this.ast);
                this.dOj = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_personal_privilege_detail_url", this.dOj);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.asA = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("show_live_forum_url", this.asA);
                    this.dOk = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("show_live_forum_name", this.dOk);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.dOl = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.dOm = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_my_live_privilege_mark_detail_url", this.dOl);
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_my_live_privilege_effect_detail_url", this.dOm);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.dOn = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt("baidu_financial_display", this.dOn);
                }
                String optString12 = jSONObject.optString("live_bar");
                dP(optString12);
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                x xVar = new x();
                xVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(xVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dP(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aNV().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aSp() {
        return this.liveForumMap;
    }

    public String aSq() {
        return this.dNw;
    }

    public String aSr() {
        return this.dNr;
    }

    public String aSs() {
        return this.dNs;
    }

    public String aSt() {
        return this.dNt;
    }

    public String aSu() {
        return this.dNu;
    }

    public String aSv() {
        return this.dNv;
    }

    public String aSw() {
        return this.dNF;
    }

    public String aSx() {
        return this.dNG;
    }

    public String aSy() {
        return this.dNH;
    }

    public String aSz() {
        return this.dNx;
    }

    public String aSA() {
        return this.dNy;
    }

    public long aSB() {
        return this.dNz;
    }

    public int aSC() {
        return this.dNA;
    }

    public long aSD() {
        return this.bxk;
    }

    public int aSE() {
        return this.dNN;
    }

    public int aSF() {
        return this.dNO;
    }

    public int aSG() {
        return this.dNP;
    }

    public int aSH() {
        return this.dNQ;
    }

    public long aSI() {
        return this.dNC;
    }

    public int aSJ() {
        return this.dND;
    }

    public int aSK() {
        return this.dNB;
    }

    public String aSL() {
        return this.infoIconUrl;
    }

    public String aSM() {
        return this.infoTargetUrl;
    }

    public long aSN() {
        return this.infoTimeStamp;
    }

    public String aSO() {
        return this.dNK;
    }

    public boolean aSP() {
        return this.dNI == 1;
    }

    public int aSQ() {
        return this.dNE;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aSR() {
        return this.dNL;
    }

    public String aSS() {
        return this.dNM;
    }

    public long aST() {
        return this.dNR;
    }

    public long aSU() {
        return this.dNS;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aSV() {
        return this.dNV;
    }

    public int aSW() {
        return this.dNW;
    }

    public u aSX() {
        return this.dNT;
    }

    public int aSY() {
        return this.dNX;
    }

    public long aSZ() {
        return this.dOc;
    }

    public long aTa() {
        return this.dOd;
    }

    public boolean aTb() {
        return this.dOe;
    }

    public w aTc() {
        return this.dOf;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aTd() {
        return this.dOg;
    }

    public boolean aTe() {
        return this.dOh;
    }

    public String aTf() {
        return this.dOi;
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
