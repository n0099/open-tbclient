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
    private String ZM;
    private String ZT;
    private long aYx;
    private String aaa;
    private b activityPrizeData;
    private String dnA;
    public int dnC;
    private String dnE;
    private String dnF;
    private int dnG;
    private int dnH;
    private int dnI;
    private int dnJ;
    private long dnK;
    private long dnL;
    private u dnM;
    private String dnN;
    private String dnR;
    private String dnT;
    private int dnU;
    private long dnV;
    private long dnW;
    private w dnY;
    private boolean dnZ;
    private String dnj;
    private String dnk;
    private String dnl;
    private String dnm;
    private String dnn;
    private String dno;
    private String dnp;
    private String dnq;
    private long dnr;
    private int dnt;
    private int dnu;
    private long dnv;
    private int dnw;
    private String dny;
    private String dnz;
    private boolean doa;
    private String dob;
    private String dod;
    private String doe;
    private String dof;
    private String dog;
    private int doh;
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
    private int dnx = 0;
    private int dnB = 2;
    private String dnD = "";
    private int dnO = 0;
    private int dnP = 0;
    private int dnQ = 0;
    private int dnS = 0;
    private boolean dnX = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dnj = jSONObject.optString("drop_pic");
                this.dnk = jSONObject.optString("drop_pic_md5");
                this.dnl = jSONObject.optString("drop_pic_num");
                this.dnm = jSONObject.optString("drop_bg_color_day");
                this.dnn = jSONObject.optString("drop_bg_color_night");
                this.dno = jSONObject.optString("apply_vip_live_room_pid");
                this.dny = jSONObject.optString("max_cache");
                this.dnz = jSONObject.optString("frs_max_cache");
                this.dnA = jSONObject.optString("frs_pn");
                this.dnp = jSONObject.optString("tail_link");
                this.dnq = jSONObject.optString("bubble_link");
                this.dnr = jSONObject.optLong("use_duration");
                this.dnt = jSONObject.optInt("xiaoying_time");
                this.aYx = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.dnF = jSONObject.optString("url_analyze_text");
                this.dnu = jSONObject.optInt("new_resign", 0);
                this.dnv = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.dnw = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dnB = jSONObject.optInt("localvideo_open", 2);
                this.dnC = jSONObject.optInt("card_show_statistic", 200);
                this.dnD = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aQY().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dnx = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.dnE = jSONObject.optString("nickname_activity_link");
                this.dnG = jSONObject.optInt("android_tab_show", 55);
                this.dnH = jSONObject.optInt("ribao_switch", 0);
                this.dnI = jSONObject.optInt("default_page", 0);
                this.dnJ = jSONObject.optInt("remember_page", 0);
                this.dnK = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.dnL = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.dnM = new u();
                    this.dnM.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wn(jSONObject.optInt("android_max_stranger"));
                this.dnO = jSONObject.optInt("style_ab_switch", 0);
                this.dnP = jSONObject.optInt("abstract_ab_switch", 0);
                this.dnN = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dnN);
                this.dnQ = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dnR = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dnR)) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_baidu_password_re", this.dnR);
                }
                this.dnT = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.dnT)) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_redpacket_pop", this.dnT);
                }
                this.dnU = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_guide_max_count", this.dnU);
                this.dnS = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_concern_tab_tips_switch", this.dnS);
                this.dnV = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.dnW = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.dnX = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.dnY == null) {
                        this.dnY = new w();
                    }
                    this.dnY.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.dnZ = false;
                } else if (optInt == 1) {
                    this.dnZ = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("pb_fold_small_flow_json", this.dnZ);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.doa = false;
                } else if (optInt2 == 1) {
                    this.doa = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("person_center_show_lite_game", this.doa);
                this.dob = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("profile_swan_app_key", this.dob);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                r.ul(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.aQU().vC(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong("plugin_wait_time", optLong);
                }
                this.ZM = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_game_frs_live_tab_video_url", this.ZM);
                this.ZT = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_personal_income_detail_url", this.ZT);
                this.dod = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_personal_privilege_detail_url", this.dod);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.aaa = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("show_live_forum_url", this.aaa);
                    this.doe = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("show_live_forum_name", this.doe);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.dof = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.dog = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_my_live_privilege_mark_detail_url", this.dof);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_my_live_privilege_effect_detail_url", this.dog);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.doh = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt("baidu_financial_display", this.doh);
                }
                String optString12 = jSONObject.optString("live_bar");
                cY(optString12);
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                x xVar = new x();
                xVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(xVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cY(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aFD().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aJO() {
        return this.liveForumMap;
    }

    public String aJP() {
        return this.dno;
    }

    public String aJQ() {
        return this.dnj;
    }

    public String aJR() {
        return this.dnk;
    }

    public String aJS() {
        return this.dnl;
    }

    public String aJT() {
        return this.dnm;
    }

    public String aJU() {
        return this.dnn;
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
        return this.dnp;
    }

    public String aJZ() {
        return this.dnq;
    }

    public long aKa() {
        return this.dnr;
    }

    public int aKb() {
        return this.dnt;
    }

    public long aKc() {
        return this.aYx;
    }

    public int aKd() {
        return this.dnG;
    }

    public int aKe() {
        return this.dnH;
    }

    public int aKf() {
        return this.dnI;
    }

    public int aKg() {
        return this.dnJ;
    }

    public long aKh() {
        return this.dnv;
    }

    public int aKi() {
        return this.dnw;
    }

    public int aKj() {
        return this.dnu;
    }

    public String aKk() {
        return this.infoIconUrl;
    }

    public String aKl() {
        return this.infoTargetUrl;
    }

    public long aKm() {
        return this.infoTimeStamp;
    }

    public String aKn() {
        return this.dnD;
    }

    public boolean aKo() {
        return this.dnB == 1;
    }

    public int aKp() {
        return this.dnx;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aKq() {
        return this.dnE;
    }

    public String aKr() {
        return this.dnF;
    }

    public long aKs() {
        return this.dnK;
    }

    public long aKt() {
        return this.dnL;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aKu() {
        return this.dnO;
    }

    public int aKv() {
        return this.dnP;
    }

    public u aKw() {
        return this.dnM;
    }

    public int aKx() {
        return this.dnQ;
    }

    public long aKy() {
        return this.dnV;
    }

    public long aKz() {
        return this.dnW;
    }

    public boolean aKA() {
        return this.dnX;
    }

    public w aKB() {
        return this.dnY;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aKC() {
        return this.dnZ;
    }

    public boolean aKD() {
        return this.doa;
    }

    public String aKE() {
        return this.dob;
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
