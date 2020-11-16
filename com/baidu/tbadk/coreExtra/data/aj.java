package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private String aKk;
    private String aKr;
    private String aKy;
    private b activityPrizeData;
    private long cqF;
    private String fcP;
    private String fcQ;
    private String fcR;
    private String fcS;
    private String fcT;
    private String fcU;
    private String fcV;
    private String fcW;
    private long fcX;
    private int fcY;
    private int fcZ;
    private long fdA;
    private ad fdC;
    private boolean fdD;
    private String fdE;
    private String fdF;
    private String fdG;
    private String fdH;
    private String fdI;
    private String fdJ;
    private int fdK;
    private long fda;
    private int fdb;
    private String fdd;
    private String fde;
    private String fdf;
    public int fdh;
    private String fdj;
    private String fdk;
    private int fdl;
    private int fdm;
    private long fdn;
    private boolean fdo;
    private long fdp;
    private ab fdq;
    private String fdr;
    private String fdv;
    private String fdx;
    private int fdy;
    private long fdz;
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
    private int fdc = 0;
    private int fdg = 2;
    private String fdi = "";
    private int fds = 0;
    private int fdt = 0;
    private int fdu = 0;
    private int fdw = 0;
    private boolean fdB = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fcP = jSONObject.optString("drop_pic");
                this.fcQ = jSONObject.optString("drop_pic_md5");
                this.fcR = jSONObject.optString("drop_pic_num");
                this.fcS = jSONObject.optString("drop_bg_color_day");
                this.fcT = jSONObject.optString("drop_bg_color_night");
                this.fcU = jSONObject.optString("apply_vip_live_room_pid");
                this.fdd = jSONObject.optString("max_cache");
                this.fde = jSONObject.optString("frs_max_cache");
                this.fdf = jSONObject.optString("frs_pn");
                this.fcV = jSONObject.optString("tail_link");
                this.fcW = jSONObject.optString("bubble_link");
                this.fcX = jSONObject.optLong("use_duration");
                this.fcY = jSONObject.optInt("xiaoying_time");
                this.cqF = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fdk = jSONObject.optString("url_analyze_text");
                this.fcZ = jSONObject.optInt("new_resign", 0);
                this.fda = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.fdb = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fdg = jSONObject.optInt("localvideo_open", 2);
                this.fdh = jSONObject.optInt("card_show_statistic", 200);
                this.fdi = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bBw().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.fdc = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.fdj = jSONObject.optString("nickname_activity_link");
                this.fdl = jSONObject.optInt("android_tab_show", 55);
                this.fdm = jSONObject.optInt("ribao_switch", 0);
                this.fdn = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.fdp = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.fdo = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.fdo);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fdq = new ab();
                    this.fdq.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.Dk(jSONObject.optInt("android_max_stranger"));
                this.fds = jSONObject.optInt("style_ab_switch", 0);
                this.fdt = jSONObject.optInt("abstract_ab_switch", 0);
                this.fdr = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fdr);
                this.fdu = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fdv = jSONObject.optString("shoubai_regex", "");
                if (!au.isEmpty(this.fdv)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_baidu_password_re", this.fdv);
                }
                this.fdx = jSONObject.optString("redpacket_pop", "");
                if (!au.isEmpty(this.fdx)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_redpacket_pop", this.fdx);
                }
                this.fdy = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_video_guide_max_count", this.fdy);
                this.fdw = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_concern_tab_tips_switch", this.fdw);
                this.fdz = jSONObject.optInt("dialog_pull_time", 60) * au.MS_TO_MIN;
                this.fdA = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fdB = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.fdC == null) {
                        this.fdC = new ad();
                    }
                    this.fdC.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.fdD = false;
                } else if (optInt == 1) {
                    this.fdD = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("person_center_show_lite_game", this.fdD);
                this.fdE = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("profile_swan_app_key", this.fdE);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.Cl(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bBs().DF(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putLong("plugin_wait_time", optLong);
                }
                this.aKk = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_game_frs_live_tab_video_url", this.aKk);
                this.aKr = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_personal_income_detail_url", this.aKr);
                this.fdF = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_personal_privilege_detail_url", this.fdF);
                this.fdG = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_personal_exp_detail_url", this.fdG);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aKy = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("show_live_forum_url", this.aKy);
                    this.fdH = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("show_live_forum_name", this.fdH);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.fdI = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fdJ = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_my_live_privilege_mark_detail_url", this.fdI);
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_my_live_privilege_effect_detail_url", this.fdJ);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.fdK = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bpu().putInt("baidu_financial_display", this.fdK);
                }
                String optString5 = jSONObject.optString("live_bar");
                gl(optString5);
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gl(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bpu().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> but() {
        return this.liveForumMap;
    }

    public String buu() {
        return this.fcU;
    }

    public String buv() {
        return this.fcP;
    }

    public String buw() {
        return this.fcQ;
    }

    public String bux() {
        return this.fcR;
    }

    public String buy() {
        return this.fcS;
    }

    public String buz() {
        return this.fcT;
    }

    public String buA() {
        return this.fdd;
    }

    public String buB() {
        return this.fde;
    }

    public String buC() {
        return this.fdf;
    }

    public String buD() {
        return this.fcV;
    }

    public String buE() {
        return this.fcW;
    }

    public long buF() {
        return this.fcX;
    }

    public int buG() {
        return this.fcY;
    }

    public long buH() {
        return this.cqF;
    }

    public int buI() {
        return this.fdl;
    }

    public int buJ() {
        return this.fdm;
    }

    public long buK() {
        return this.fda;
    }

    public int buL() {
        return this.fdb;
    }

    public int buM() {
        return this.fcZ;
    }

    public String buN() {
        return this.infoIconUrl;
    }

    public String buO() {
        return this.infoTargetUrl;
    }

    public long buP() {
        return this.infoTimeStamp;
    }

    public String buQ() {
        return this.fdi;
    }

    public boolean buR() {
        return this.fdg == 1;
    }

    public int buS() {
        return this.fdc;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String buT() {
        return this.fdj;
    }

    public String buU() {
        return this.fdk;
    }

    public long buV() {
        return this.fdn;
    }

    public boolean buW() {
        return this.fdo;
    }

    public long buX() {
        return this.fdp;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int buY() {
        return this.fds;
    }

    public int buZ() {
        return this.fdt;
    }

    public ab bva() {
        return this.fdq;
    }

    public int bvb() {
        return this.fdu;
    }

    public long bvc() {
        return this.fdz;
    }

    public long bvd() {
        return this.fdA;
    }

    public boolean bve() {
        return this.fdB;
    }

    public ad bvf() {
        return this.fdC;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bvg() {
        return this.fdD;
    }

    public String bvh() {
        return this.fdE;
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
