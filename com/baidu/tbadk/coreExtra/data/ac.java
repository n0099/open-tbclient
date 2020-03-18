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
    private String ZW;
    private long aYK;
    private String aae;
    private String aal;
    private b activityPrizeData;
    private String dnA;
    private String dnB;
    private String dnC;
    private String dnD;
    private String dnE;
    private long dnF;
    private int dnG;
    private int dnH;
    private long dnI;
    private int dnJ;
    private String dnL;
    private String dnM;
    private String dnN;
    public int dnP;
    private String dnR;
    private String dnS;
    private int dnT;
    private int dnU;
    private int dnV;
    private int dnW;
    private long dnX;
    private long dnY;
    private u dnZ;
    private String dnx;
    private String dny;
    private String dnz;
    private String doa;
    private String dof;
    private String doh;
    private int doi;
    private long doj;
    private long dok;
    private w dom;
    private boolean don;
    private boolean doo;
    private String dop;
    private String doq;
    private String dor;
    private String dos;
    private String dou;
    private int dov;
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
    private int dnK = 0;
    private int dnO = 2;
    private String dnQ = "";
    private int dob = 0;
    private int dod = 0;
    private int doe = 0;
    private int dog = 0;
    private boolean dol = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dnx = jSONObject.optString("drop_pic");
                this.dny = jSONObject.optString("drop_pic_md5");
                this.dnz = jSONObject.optString("drop_pic_num");
                this.dnA = jSONObject.optString("drop_bg_color_day");
                this.dnB = jSONObject.optString("drop_bg_color_night");
                this.dnC = jSONObject.optString("apply_vip_live_room_pid");
                this.dnL = jSONObject.optString("max_cache");
                this.dnM = jSONObject.optString("frs_max_cache");
                this.dnN = jSONObject.optString("frs_pn");
                this.dnD = jSONObject.optString("tail_link");
                this.dnE = jSONObject.optString("bubble_link");
                this.dnF = jSONObject.optLong("use_duration");
                this.dnG = jSONObject.optInt("xiaoying_time");
                this.aYK = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.dnS = jSONObject.optString("url_analyze_text");
                this.dnH = jSONObject.optInt("new_resign", 0);
                this.dnI = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.dnJ = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dnO = jSONObject.optInt("localvideo_open", 2);
                this.dnP = jSONObject.optInt("card_show_statistic", 200);
                this.dnQ = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aRc().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dnK = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.dnR = jSONObject.optString("nickname_activity_link");
                this.dnT = jSONObject.optInt("android_tab_show", 55);
                this.dnU = jSONObject.optInt("ribao_switch", 0);
                this.dnV = jSONObject.optInt("default_page", 0);
                this.dnW = jSONObject.optInt("remember_page", 0);
                this.dnX = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.dnY = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.dnZ = new u();
                    this.dnZ.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wv(jSONObject.optInt("android_max_stranger"));
                this.dob = jSONObject.optInt("style_ab_switch", 0);
                this.dod = jSONObject.optInt("abstract_ab_switch", 0);
                this.doa = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.doa);
                this.doe = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dof = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dof)) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_baidu_password_re", this.dof);
                }
                this.doh = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.doh)) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_redpacket_pop", this.doh);
                }
                this.doi = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_video_guide_max_count", this.doi);
                this.dog = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_concern_tab_tips_switch", this.dog);
                this.doj = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.dok = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.dol = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.dom == null) {
                        this.dom = new w();
                    }
                    this.dom.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.don = false;
                } else if (optInt == 1) {
                    this.don = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("pb_fold_small_flow_json", this.don);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.doo = false;
                } else if (optInt2 == 1) {
                    this.doo = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("person_center_show_lite_game", this.doo);
                this.dop = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("profile_swan_app_key", this.dop);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                r.uk(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.aQY().vB(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putLong("plugin_wait_time", optLong);
                }
                this.ZW = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_game_frs_live_tab_video_url", this.ZW);
                this.aae = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_personal_income_detail_url", this.aae);
                this.doq = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_personal_privilege_detail_url", this.doq);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.aal = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("show_live_forum_url", this.aal);
                    this.dor = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("show_live_forum_name", this.dor);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.dos = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.dou = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_my_live_privilege_mark_detail_url", this.dos);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_my_live_privilege_effect_detail_url", this.dou);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.dov = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt("baidu_financial_display", this.dov);
                }
                String optString12 = jSONObject.optString("live_bar");
                cX(optString12);
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                x xVar = new x();
                xVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(xVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cX(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aFH().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aJS() {
        return this.liveForumMap;
    }

    public String aJT() {
        return this.dnC;
    }

    public String aJU() {
        return this.dnx;
    }

    public String aJV() {
        return this.dny;
    }

    public String aJW() {
        return this.dnz;
    }

    public String aJX() {
        return this.dnA;
    }

    public String aJY() {
        return this.dnB;
    }

    public String aJZ() {
        return this.dnL;
    }

    public String aKa() {
        return this.dnM;
    }

    public String aKb() {
        return this.dnN;
    }

    public String aKc() {
        return this.dnD;
    }

    public String aKd() {
        return this.dnE;
    }

    public long aKe() {
        return this.dnF;
    }

    public int aKf() {
        return this.dnG;
    }

    public long aKg() {
        return this.aYK;
    }

    public int aKh() {
        return this.dnT;
    }

    public int aKi() {
        return this.dnU;
    }

    public int aKj() {
        return this.dnV;
    }

    public int aKk() {
        return this.dnW;
    }

    public long aKl() {
        return this.dnI;
    }

    public int aKm() {
        return this.dnJ;
    }

    public int aKn() {
        return this.dnH;
    }

    public String aKo() {
        return this.infoIconUrl;
    }

    public String aKp() {
        return this.infoTargetUrl;
    }

    public long aKq() {
        return this.infoTimeStamp;
    }

    public String aKr() {
        return this.dnQ;
    }

    public boolean aKs() {
        return this.dnO == 1;
    }

    public int aKt() {
        return this.dnK;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aKu() {
        return this.dnR;
    }

    public String aKv() {
        return this.dnS;
    }

    public long aKw() {
        return this.dnX;
    }

    public long aKx() {
        return this.dnY;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aKy() {
        return this.dob;
    }

    public int aKz() {
        return this.dod;
    }

    public u aKA() {
        return this.dnZ;
    }

    public int aKB() {
        return this.doe;
    }

    public long aKC() {
        return this.doj;
    }

    public long aKD() {
        return this.dok;
    }

    public boolean aKE() {
        return this.dol;
    }

    public w aKF() {
        return this.dom;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aKG() {
        return this.don;
    }

    public boolean aKH() {
        return this.doo;
    }

    public String aKI() {
        return this.dop;
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
