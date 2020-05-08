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
    private String asG;
    private String ass;
    private String asz;
    private long bxp;
    private String dNA;
    private String dNB;
    private String dNC;
    private long dND;
    private int dNE;
    private int dNF;
    private long dNG;
    private int dNH;
    private String dNJ;
    private String dNK;
    private String dNL;
    public int dNN;
    private String dNP;
    private String dNQ;
    private int dNR;
    private int dNS;
    private int dNT;
    private int dNU;
    private long dNV;
    private boolean dNW;
    private long dNX;
    private u dNY;
    private String dNZ;
    private String dNv;
    private String dNw;
    private String dNx;
    private String dNy;
    private String dNz;
    private String dOd;
    private String dOf;
    private int dOg;
    private long dOh;
    private long dOi;
    private w dOk;
    private boolean dOl;
    private boolean dOm;
    private String dOn;
    private String dOo;
    private String dOp;
    private String dOq;
    private String dOr;
    private int dOs;
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
    private int dNI = 0;
    private int dNM = 2;
    private String dNO = "";
    private int dOa = 0;
    private int dOb = 0;
    private int dOc = 0;
    private int dOe = 0;
    private boolean dOj = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dNv = jSONObject.optString("drop_pic");
                this.dNw = jSONObject.optString("drop_pic_md5");
                this.dNx = jSONObject.optString("drop_pic_num");
                this.dNy = jSONObject.optString("drop_bg_color_day");
                this.dNz = jSONObject.optString("drop_bg_color_night");
                this.dNA = jSONObject.optString("apply_vip_live_room_pid");
                this.dNJ = jSONObject.optString("max_cache");
                this.dNK = jSONObject.optString("frs_max_cache");
                this.dNL = jSONObject.optString("frs_pn");
                this.dNB = jSONObject.optString("tail_link");
                this.dNC = jSONObject.optString("bubble_link");
                this.dND = jSONObject.optLong("use_duration");
                this.dNE = jSONObject.optInt("xiaoying_time");
                this.bxp = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.dNQ = jSONObject.optString("url_analyze_text");
                this.dNF = jSONObject.optInt("new_resign", 0);
                this.dNG = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.dNH = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dNM = jSONObject.optInt("localvideo_open", 2);
                this.dNN = jSONObject.optInt("card_show_statistic", 200);
                this.dNO = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aZk().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dNI = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.dNP = jSONObject.optString("nickname_activity_link");
                this.dNR = jSONObject.optInt("android_tab_show", 55);
                this.dNS = jSONObject.optInt("ribao_switch", 0);
                this.dNT = jSONObject.optInt("default_page", 0);
                this.dNU = jSONObject.optInt("remember_page", 0);
                this.dNV = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.dNX = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.dNW = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.dNW);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.dNY = new u();
                    this.dNY.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wT(jSONObject.optInt("android_max_stranger"));
                this.dOa = jSONObject.optInt("style_ab_switch", 0);
                this.dOb = jSONObject.optInt("abstract_ab_switch", 0);
                this.dNZ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dNZ);
                this.dOc = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dOd = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dOd)) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_baidu_password_re", this.dOd);
                }
                this.dOf = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.dOf)) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_redpacket_pop", this.dOf);
                }
                this.dOg = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_video_guide_max_count", this.dOg);
                this.dOe = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_concern_tab_tips_switch", this.dOe);
                this.dOh = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.dOi = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.dOj = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.dOk == null) {
                        this.dOk = new w();
                    }
                    this.dOk.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.dOl = false;
                } else if (optInt == 1) {
                    this.dOl = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("pb_fold_small_flow_json", this.dOl);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.dOm = false;
                } else if (optInt2 == 1) {
                    this.dOm = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("person_center_show_lite_game", this.dOm);
                this.dOn = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("profile_swan_app_key", this.dOn);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                r.vC(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.aZg().wU(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putLong("plugin_wait_time", optLong);
                }
                this.ass = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_game_frs_live_tab_video_url", this.ass);
                this.asz = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_personal_income_detail_url", this.asz);
                this.dOo = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_personal_privilege_detail_url", this.dOo);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.asG = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("show_live_forum_url", this.asG);
                    this.dOp = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("show_live_forum_name", this.dOp);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.dOq = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.dOr = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_my_live_privilege_mark_detail_url", this.dOq);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_my_live_privilege_effect_detail_url", this.dOr);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.dOs = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt("baidu_financial_display", this.dOs);
                }
                String optString12 = jSONObject.optString("live_bar");
                dP(optString12);
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
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
            str = com.baidu.tbadk.core.sharedPref.b.aNT().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aSm() {
        return this.liveForumMap;
    }

    public String aSn() {
        return this.dNA;
    }

    public String aSo() {
        return this.dNv;
    }

    public String aSp() {
        return this.dNw;
    }

    public String aSq() {
        return this.dNx;
    }

    public String aSr() {
        return this.dNy;
    }

    public String aSs() {
        return this.dNz;
    }

    public String aSt() {
        return this.dNJ;
    }

    public String aSu() {
        return this.dNK;
    }

    public String aSv() {
        return this.dNL;
    }

    public String aSw() {
        return this.dNB;
    }

    public String aSx() {
        return this.dNC;
    }

    public long aSy() {
        return this.dND;
    }

    public int aSz() {
        return this.dNE;
    }

    public long aSA() {
        return this.bxp;
    }

    public int aSB() {
        return this.dNR;
    }

    public int aSC() {
        return this.dNS;
    }

    public int aSD() {
        return this.dNT;
    }

    public int aSE() {
        return this.dNU;
    }

    public long aSF() {
        return this.dNG;
    }

    public int aSG() {
        return this.dNH;
    }

    public int aSH() {
        return this.dNF;
    }

    public String aSI() {
        return this.infoIconUrl;
    }

    public String aSJ() {
        return this.infoTargetUrl;
    }

    public long aSK() {
        return this.infoTimeStamp;
    }

    public String aSL() {
        return this.dNO;
    }

    public boolean aSM() {
        return this.dNM == 1;
    }

    public int aSN() {
        return this.dNI;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aSO() {
        return this.dNP;
    }

    public String aSP() {
        return this.dNQ;
    }

    public long aSQ() {
        return this.dNV;
    }

    public boolean aSR() {
        return this.dNW;
    }

    public long aSS() {
        return this.dNX;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aST() {
        return this.dOa;
    }

    public int aSU() {
        return this.dOb;
    }

    public u aSV() {
        return this.dNY;
    }

    public int aSW() {
        return this.dOc;
    }

    public long aSX() {
        return this.dOh;
    }

    public long aSY() {
        return this.dOi;
    }

    public boolean aSZ() {
        return this.dOj;
    }

    public w aTa() {
        return this.dOk;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aTb() {
        return this.dOl;
    }

    public boolean aTc() {
        return this.dOm;
    }

    public String aTd() {
        return this.dOn;
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
