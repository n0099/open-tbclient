package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
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
public class ab {
    private String XV;
    private String Yc;
    private String Yj;
    private long aTW;
    private b activityPrizeData;
    private String diR;
    private String diS;
    private String diT;
    private String diU;
    private String diV;
    private String diW;
    private String diX;
    private String diY;
    private long diZ;
    private String djA;
    private int djB;
    private long djC;
    private long djD;
    private v djF;
    private boolean djG;
    private boolean djH;
    private String djI;
    private String djJ;
    private String djK;
    private String djL;
    private String djM;
    private int djN;
    private int dja;
    private int djb;
    private long djc;
    private int djd;
    private String djf;
    private String djg;
    private String djh;
    public int djj;
    private String djl;
    private String djm;
    private int djn;
    private int djo;
    private int djp;
    private int djq;
    private long djr;
    private long djs;
    private t djt;
    private String dju;
    private String djy;
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
    private int dje = 0;
    private int dji = 2;
    private String djk = "";
    private int djv = 0;
    private int djw = 0;
    private int djx = 0;
    private int djz = 0;
    private boolean djE = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.diR = jSONObject.optString("drop_pic");
                this.diS = jSONObject.optString("drop_pic_md5");
                this.diT = jSONObject.optString("drop_pic_num");
                this.diU = jSONObject.optString("drop_bg_color_day");
                this.diV = jSONObject.optString("drop_bg_color_night");
                this.diW = jSONObject.optString("apply_vip_live_room_pid");
                this.djf = jSONObject.optString("max_cache");
                this.djg = jSONObject.optString("frs_max_cache");
                this.djh = jSONObject.optString("frs_pn");
                this.diX = jSONObject.optString("tail_link");
                this.diY = jSONObject.optString("bubble_link");
                this.diZ = jSONObject.optLong("use_duration");
                this.dja = jSONObject.optInt("xiaoying_time");
                this.aTW = jSONObject.optLong("last_update_time", 0L);
                this.djm = jSONObject.optString("url_analyze_text");
                this.djb = jSONObject.optInt("new_resign", 0);
                this.djc = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.djd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.dji = jSONObject.optInt("localvideo_open", 2);
                this.djj = jSONObject.optInt("card_show_statistic", 200);
                this.djk = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.aOF().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.dje = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.djl = jSONObject.optString("nickname_activity_link");
                this.djn = jSONObject.optInt("android_tab_show", 23);
                this.djo = jSONObject.optInt("ribao_switch", 0);
                this.djp = jSONObject.optInt("default_page", 0);
                this.djq = jSONObject.optInt("remember_page", 0);
                this.djr = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.djs = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.djt = new t();
                    this.djt.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_game_video", optString6);
                    }
                    String optString7 = optJSONObject3.optString("video_tab", "");
                    if (!StringUtils.isNull(optString7)) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_video_tab", optString7);
                    }
                }
                com.baidu.tieba.im.db.n.wh(jSONObject.optInt("android_max_stranger"));
                this.djv = jSONObject.optInt("style_ab_switch", 0);
                this.djw = jSONObject.optInt("abstract_ab_switch", 0);
                this.dju = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.dju);
                this.djx = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.djy = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.djy)) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_baidu_password_re", this.djy);
                }
                this.djA = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.djA)) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_redpacket_pop", this.djA);
                }
                this.djB = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_video_guide_max_count", this.djB);
                this.djz = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_concern_tab_tips_switch", this.djz);
                this.djC = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.djD = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.djE = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString8 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString8)) {
                    if (this.djF == null) {
                        this.djF = new v();
                    }
                    this.djF.parserJson(optString8);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("shake_data", optString8);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_video_click_test", jSONObject.optInt("video_click_test", 0));
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.djG = false;
                } else if (optInt == 1) {
                    this.djG = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("pb_fold_small_flow_json", this.djG);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.djH = false;
                } else if (optInt2 == 1) {
                    this.djH = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("person_center_show_lite_game", this.djH);
                this.djI = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("profile_swan_app_key", this.djI);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                q.tT(jSONObject.optString("js_whitelist"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong("plugin_wait_time", optLong);
                }
                this.XV = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_game_frs_live_tab_video_url", this.XV);
                this.Yc = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_personal_income_detail_url", this.Yc);
                this.djJ = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_personal_privilege_detail_url", this.djJ);
                String optString9 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject2 = new JSONObject(optString9);
                    this.Yj = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("show_live_forum_url", this.Yj);
                    this.djK = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("show_live_forum_name", this.djK);
                }
                String optString10 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString10)) {
                    JSONObject jSONObject3 = new JSONObject(optString10);
                    this.djL = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.djM = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_my_live_privilege_mark_detail_url", this.djL);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_my_live_privilege_effect_detail_url", this.djM);
                }
                String optString11 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString11)) {
                    this.djN = new JSONObject(optString11).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aDr().putInt("baidu_financial_display", this.djN);
                }
                String optString12 = jSONObject.optString("live_bar");
                cP(optString12);
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("ala_live_bar_map_str", optString12);
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("key_show_newyear_skin_time", jSONObject.optString("chunjie_icon_style"));
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                w wVar = new w();
                wVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(wVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cP(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aDr().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> aHs() {
        return this.liveForumMap;
    }

    public String aHt() {
        return this.diW;
    }

    public String aHu() {
        return this.diR;
    }

    public String aHv() {
        return this.diS;
    }

    public String aHw() {
        return this.diT;
    }

    public String aHx() {
        return this.diU;
    }

    public String aHy() {
        return this.diV;
    }

    public String aHz() {
        return this.djf;
    }

    public String aHA() {
        return this.djg;
    }

    public String aHB() {
        return this.djh;
    }

    public String aHC() {
        return this.diX;
    }

    public String aHD() {
        return this.diY;
    }

    public long aHE() {
        return this.diZ;
    }

    public int aHF() {
        return this.dja;
    }

    public long aHG() {
        return this.aTW;
    }

    public int aHH() {
        return this.djn;
    }

    public int aHI() {
        return this.djo;
    }

    public int aHJ() {
        return this.djp;
    }

    public int aHK() {
        return this.djq;
    }

    public long aHL() {
        return this.djc;
    }

    public int aHM() {
        return this.djd;
    }

    public int aHN() {
        return this.djb;
    }

    public String aHO() {
        return this.infoIconUrl;
    }

    public String aHP() {
        return this.infoTargetUrl;
    }

    public long aHQ() {
        return this.infoTimeStamp;
    }

    public String aHR() {
        return this.djk;
    }

    public boolean aHS() {
        return this.dji == 1;
    }

    public int aHT() {
        return this.dje;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aHU() {
        return this.djl;
    }

    public String aHV() {
        return this.djm;
    }

    public long aHW() {
        return this.djr;
    }

    public long aHX() {
        return this.djs;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aHY() {
        return this.djv;
    }

    public int aHZ() {
        return this.djw;
    }

    public t aIa() {
        return this.djt;
    }

    public int aIb() {
        return this.djx;
    }

    public long aIc() {
        return this.djC;
    }

    public long aId() {
        return this.djD;
    }

    public boolean aIe() {
        return this.djE;
    }

    public v aIf() {
        return this.djF;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aIg() {
        return this.djG;
    }

    public boolean aIh() {
        return this.djH;
    }

    public String aIi() {
        return this.djI;
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
