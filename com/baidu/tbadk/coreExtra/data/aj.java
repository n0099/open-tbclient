package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private String aNJ;
    private String aNQ;
    private String aNX;
    private b activityPrizeData;
    private String ftZ;
    private ab fuA;
    private String fuB;
    private String fuF;
    private String fuH;
    private int fuI;
    private long fuJ;
    private long fuK;
    private ad fuM;
    private boolean fuN;
    private String fuO;
    private String fuP;
    private String fuQ;
    private String fuR;
    private String fuS;
    private String fuT;
    private int fuU;
    private String fua;
    private String fub;
    private String fuc;
    private String fud;
    private String fue;
    private String fuf;
    private String fug;
    private long fuh;
    private int fui;
    private int fuj;
    private long fuk;
    private int ful;
    private String fun;
    private String fuo;
    private String fup;
    public int fur;
    private String fut;
    private String fuu;
    private int fuv;
    private int fuw;
    private long fux;
    private boolean fuy;
    private long fuz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceObjSource;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String mWalletSignLink;
    private String uegVoiceWarning;
    private int fum = 0;
    private int fuq = 2;
    private String fus = "";
    private int fuC = 0;
    private int fuD = 0;
    private int fuE = 0;
    private int fuG = 0;
    private boolean fuL = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ftZ = jSONObject.optString("drop_pic");
                this.fua = jSONObject.optString("drop_pic_md5");
                this.fub = jSONObject.optString("drop_pic_num");
                this.fuc = jSONObject.optString("drop_bg_color_day");
                this.fud = jSONObject.optString("drop_bg_color_night");
                this.fue = jSONObject.optString("apply_vip_live_room_pid");
                this.fun = jSONObject.optString("max_cache");
                this.fuo = jSONObject.optString("frs_max_cache");
                this.fup = jSONObject.optString("frs_pn");
                this.fuf = jSONObject.optString("tail_link");
                this.fug = jSONObject.optString("bubble_link");
                this.fuh = jSONObject.optLong("use_duration");
                this.fui = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fuu = jSONObject.optString("url_analyze_text");
                this.fuj = jSONObject.optInt("new_resign", 0);
                this.fuk = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.ful = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fuq = jSONObject.optInt("localvideo_open", 2);
                this.fur = jSONObject.optInt("card_show_statistic", 200);
                this.fus = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bHs().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.fum = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.fut = jSONObject.optString("nickname_activity_link");
                this.fuv = jSONObject.optInt("android_tab_show", 55);
                this.fuw = jSONObject.optInt("ribao_switch", 0);
                this.fux = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.fuz = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.fuy = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.fuy);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fuA = new ab();
                    this.fuA.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.Ej(jSONObject.optInt("android_max_stranger"));
                this.fuC = jSONObject.optInt("style_ab_switch", 0);
                this.fuD = jSONObject.optInt("abstract_ab_switch", 0);
                this.fuB = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fuB);
                this.fuE = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fuF = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.fuF)) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_baidu_password_re", this.fuF);
                }
                this.fuH = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.fuH)) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_redpacket_pop", this.fuH);
                }
                this.fuI = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_video_guide_max_count", this.fuI);
                this.fuG = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_concern_tab_tips_switch", this.fuG);
                this.fuJ = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.fuK = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fuL = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.fuM == null) {
                        this.fuM = new ad();
                    }
                    this.fuM.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.fuN = false;
                } else if (optInt == 1) {
                    this.fuN = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("person_center_show_lite_game", this.fuN);
                this.fuO = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("profile_swan_app_key", this.fuO);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.CR(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.pageExtra.f.bHo().En(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putLong("plugin_wait_time", optLong);
                }
                this.aNJ = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_game_frs_live_tab_video_url", this.aNJ);
                this.aNQ = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_personal_income_detail_url", this.aNQ);
                this.fuP = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_personal_privilege_detail_url", this.fuP);
                this.fuQ = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_personal_exp_detail_url", this.fuQ);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aNX = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("show_live_forum_url", this.aNX);
                    this.fuR = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("show_live_forum_name", this.fuR);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.fuS = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fuT = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_my_live_privilege_mark_detail_url", this.fuS);
                    com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_my_live_privilege_effect_detail_url", this.fuT);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.fuU = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bvq().putInt("baidu_financial_display", this.fuU);
                }
                String optString5 = jSONObject.optString("live_bar");
                gq(optString5);
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                new e().dv(jSONObject);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gq(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bvq().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bAn() {
        return this.liveForumMap;
    }

    public String bAo() {
        return this.fue;
    }

    public String bAp() {
        return this.ftZ;
    }

    public String bAq() {
        return this.fua;
    }

    public String bAr() {
        return this.fub;
    }

    public String bAs() {
        return this.fuc;
    }

    public String bAt() {
        return this.fud;
    }

    public String bAu() {
        return this.fun;
    }

    public String bAv() {
        return this.fuo;
    }

    public String bAw() {
        return this.fup;
    }

    public String bAx() {
        return this.fuf;
    }

    public String bAy() {
        return this.fug;
    }

    public long bAz() {
        return this.fuh;
    }

    public int bAA() {
        return this.fui;
    }

    public long bAB() {
        return this.lastUpdateTime;
    }

    public int bAC() {
        return this.fuv;
    }

    public int bAD() {
        return this.fuw;
    }

    public long bAE() {
        return this.fuk;
    }

    public int bAF() {
        return this.ful;
    }

    public int bAG() {
        return this.fuj;
    }

    public String bAH() {
        return this.infoIconUrl;
    }

    public String bAI() {
        return this.infoTargetUrl;
    }

    public long bAJ() {
        return this.infoTimeStamp;
    }

    public String bAK() {
        return this.fus;
    }

    public boolean bAL() {
        return this.fuq == 1;
    }

    public int bAM() {
        return this.fum;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bAN() {
        return this.fut;
    }

    public String bAO() {
        return this.fuu;
    }

    public long bAP() {
        return this.fux;
    }

    public boolean bAQ() {
        return this.fuy;
    }

    public long bAR() {
        return this.fuz;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bAS() {
        return this.fuC;
    }

    public int bAT() {
        return this.fuD;
    }

    public ab bAU() {
        return this.fuA;
    }

    public int bAV() {
        return this.fuE;
    }

    public long bAW() {
        return this.fuJ;
    }

    public long bAX() {
        return this.fuK;
    }

    public boolean bAY() {
        return this.fuL;
    }

    public ad bAZ() {
        return this.fuM;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bBa() {
        return this.fuN;
    }

    public String bBb() {
        return this.fuO;
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
