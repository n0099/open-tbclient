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
    private long aYw;
    private String aaa;
    private b activityPrizeData;
    private String dmW;
    private String dmX;
    private String dmY;
    private String dmZ;
    private String dnA;
    private String dnE;
    private String dnG;
    private int dnH;
    private long dnI;
    private long dnJ;
    private w dnL;
    private boolean dnM;
    private boolean dnN;
    private String dnO;
    private String dnP;
    private String dnQ;
    private String dnR;
    private String dnS;
    private int dnT;
    private String dna;
    private String dnb;
    private String dnc;
    private String dnd;
    private long dne;
    private int dnf;
    private int dng;
    private long dnh;
    private int dni;
    private String dnk;
    private String dnl;
    private String dnm;
    public int dno;
    private String dnq;
    private String dnr;
    private int dnt;
    private int dnu;
    private int dnv;
    private int dnw;
    private long dnx;
    private long dny;
    private u dnz;
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
    private int dnj = 0;
    private int dnn = 2;
    private String dnp = "";
    private int dnB = 0;
    private int dnC = 0;
    private int dnD = 0;
    private int dnF = 0;
    private boolean dnK = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dmW = jSONObject.optString("drop_pic");
                this.dmX = jSONObject.optString("drop_pic_md5");
                this.dmY = jSONObject.optString("drop_pic_num");
                this.dmZ = jSONObject.optString("drop_bg_color_day");
                this.dna = jSONObject.optString("drop_bg_color_night");
                this.dnb = jSONObject.optString("apply_vip_live_room_pid");
                this.dnk = jSONObject.optString("max_cache");
                this.dnl = jSONObject.optString("frs_max_cache");
                this.dnm = jSONObject.optString("frs_pn");
                this.dnc = jSONObject.optString("tail_link");
                this.dnd = jSONObject.optString("bubble_link");
                this.dne = jSONObject.optLong("use_duration");
                this.dnf = jSONObject.optInt("xiaoying_time");
                this.aYw = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.dnr = jSONObject.optString("url_analyze_text");
                this.dng = jSONObject.optInt("new_resign", 0);
                this.dnh = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.dni = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dnn = jSONObject.optInt("localvideo_open", 2);
                this.dno = jSONObject.optInt("card_show_statistic", 200);
                this.dnp = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aQX().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dnj = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.dnq = jSONObject.optString("nickname_activity_link");
                this.dnt = jSONObject.optInt("android_tab_show", 55);
                this.dnu = jSONObject.optInt("ribao_switch", 0);
                this.dnv = jSONObject.optInt("default_page", 0);
                this.dnw = jSONObject.optInt("remember_page", 0);
                this.dnx = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.dny = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.dnz = new u();
                    this.dnz.parse(optJSONObject2);
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
                this.dnB = jSONObject.optInt("style_ab_switch", 0);
                this.dnC = jSONObject.optInt("abstract_ab_switch", 0);
                this.dnA = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dnA);
                this.dnD = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.dnE = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.dnE)) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_baidu_password_re", this.dnE);
                }
                this.dnG = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.dnG)) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_redpacket_pop", this.dnG);
                }
                this.dnH = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_guide_max_count", this.dnH);
                this.dnF = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_concern_tab_tips_switch", this.dnF);
                this.dnI = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.dnJ = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.dnK = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.dnL == null) {
                        this.dnL = new w();
                    }
                    this.dnL.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.dnM = false;
                } else if (optInt == 1) {
                    this.dnM = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("pb_fold_small_flow_json", this.dnM);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.dnN = false;
                } else if (optInt2 == 1) {
                    this.dnN = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("person_center_show_lite_game", this.dnN);
                this.dnO = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("profile_swan_app_key", this.dnO);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                r.uk(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.aQT().vB(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong("plugin_wait_time", optLong);
                }
                this.ZM = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_game_frs_live_tab_video_url", this.ZM);
                this.ZT = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_personal_income_detail_url", this.ZT);
                this.dnP = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_personal_privilege_detail_url", this.dnP);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.aaa = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("show_live_forum_url", this.aaa);
                    this.dnQ = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("show_live_forum_name", this.dnQ);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.dnR = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.dnS = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_my_live_privilege_mark_detail_url", this.dnR);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("ala_my_live_privilege_effect_detail_url", this.dnS);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.dnT = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt("baidu_financial_display", this.dnT);
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

    public HashMap<Long, String> aJN() {
        return this.liveForumMap;
    }

    public String aJO() {
        return this.dnb;
    }

    public String aJP() {
        return this.dmW;
    }

    public String aJQ() {
        return this.dmX;
    }

    public String aJR() {
        return this.dmY;
    }

    public String aJS() {
        return this.dmZ;
    }

    public String aJT() {
        return this.dna;
    }

    public String aJU() {
        return this.dnk;
    }

    public String aJV() {
        return this.dnl;
    }

    public String aJW() {
        return this.dnm;
    }

    public String aJX() {
        return this.dnc;
    }

    public String aJY() {
        return this.dnd;
    }

    public long aJZ() {
        return this.dne;
    }

    public int aKa() {
        return this.dnf;
    }

    public long aKb() {
        return this.aYw;
    }

    public int aKc() {
        return this.dnt;
    }

    public int aKd() {
        return this.dnu;
    }

    public int aKe() {
        return this.dnv;
    }

    public int aKf() {
        return this.dnw;
    }

    public long aKg() {
        return this.dnh;
    }

    public int aKh() {
        return this.dni;
    }

    public int aKi() {
        return this.dng;
    }

    public String aKj() {
        return this.infoIconUrl;
    }

    public String aKk() {
        return this.infoTargetUrl;
    }

    public long aKl() {
        return this.infoTimeStamp;
    }

    public String aKm() {
        return this.dnp;
    }

    public boolean aKn() {
        return this.dnn == 1;
    }

    public int aKo() {
        return this.dnj;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aKp() {
        return this.dnq;
    }

    public String aKq() {
        return this.dnr;
    }

    public long aKr() {
        return this.dnx;
    }

    public long aKs() {
        return this.dny;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aKt() {
        return this.dnB;
    }

    public int aKu() {
        return this.dnC;
    }

    public u aKv() {
        return this.dnz;
    }

    public int aKw() {
        return this.dnD;
    }

    public long aKx() {
        return this.dnI;
    }

    public long aKy() {
        return this.dnJ;
    }

    public boolean aKz() {
        return this.dnK;
    }

    public w aKA() {
        return this.dnL;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aKB() {
        return this.dnM;
    }

    public boolean aKC() {
        return this.dnN;
    }

    public String aKD() {
        return this.dnO;
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
