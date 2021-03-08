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
    private String aNg;
    private String aNn;
    private String aNu;
    private b activityPrizeData;
    private String ftB;
    private String ftC;
    private int ftD;
    private int ftE;
    private long ftF;
    private boolean ftG;
    private long ftH;
    private ab ftI;
    private String ftJ;
    private String ftN;
    private String ftP;
    private int ftQ;
    private long ftR;
    private long ftS;
    private ad ftU;
    private boolean ftV;
    private String ftW;
    private String ftX;
    private String ftY;
    private String ftZ;
    private String ftg;
    private String fth;
    private String fti;
    private String ftj;
    private String ftk;
    private String ftl;
    private String ftm;
    private String ftn;
    private long fto;
    private int ftq;
    private int ftr;
    private long fts;
    private int ftt;
    private String ftv;
    private String ftw;
    private String ftx;
    public int ftz;
    private String fua;
    private String fub;
    private int fuc;
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
    private int ftu = 0;
    private int fty = 2;
    private String ftA = "";
    private int ftK = 0;
    private int ftL = 0;
    private int ftM = 0;
    private int ftO = 0;
    private boolean ftT = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ftg = jSONObject.optString("drop_pic");
                this.fth = jSONObject.optString("drop_pic_md5");
                this.fti = jSONObject.optString("drop_pic_num");
                this.ftj = jSONObject.optString("drop_bg_color_day");
                this.ftk = jSONObject.optString("drop_bg_color_night");
                this.ftl = jSONObject.optString("apply_vip_live_room_pid");
                this.ftv = jSONObject.optString("max_cache");
                this.ftw = jSONObject.optString("frs_max_cache");
                this.ftx = jSONObject.optString("frs_pn");
                this.ftm = jSONObject.optString("tail_link");
                this.ftn = jSONObject.optString("bubble_link");
                this.fto = jSONObject.optLong("use_duration");
                this.ftq = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.ftC = jSONObject.optString("url_analyze_text");
                this.ftr = jSONObject.optInt("new_resign", 0);
                this.fts = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.ftt = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fty = jSONObject.optInt("localvideo_open", 2);
                this.ftz = jSONObject.optInt("card_show_statistic", 200);
                this.ftA = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bDW().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.ftu = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.ftB = jSONObject.optString("nickname_activity_link");
                this.ftD = jSONObject.optInt("android_tab_show", 55);
                this.ftE = jSONObject.optInt("ribao_switch", 0);
                this.ftF = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.ftH = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.ftG = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.ftG);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.ftI = new ab();
                    this.ftI.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.CX(jSONObject.optInt("android_max_stranger"));
                this.ftK = jSONObject.optInt("style_ab_switch", 0);
                this.ftL = jSONObject.optInt("abstract_ab_switch", 0);
                this.ftJ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.brR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.ftJ);
                this.ftM = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.ftN = jSONObject.optString("shoubai_regex", "");
                if (!au.isEmpty(this.ftN)) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("key_baidu_password_re", this.ftN);
                }
                this.ftP = jSONObject.optString("redpacket_pop", "");
                if (!au.isEmpty(this.ftP)) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("key_redpacket_pop", this.ftP);
                }
                this.ftQ = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_video_guide_max_count", this.ftQ);
                this.ftO = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_concern_tab_tips_switch", this.ftO);
                this.ftR = jSONObject.optInt("dialog_pull_time", 60) * au.MS_TO_MIN;
                this.ftS = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.ftT = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.ftU == null) {
                        this.ftU = new ad();
                    }
                    this.ftU.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.ftV = false;
                } else if (optInt == 1) {
                    this.ftV = true;
                }
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("person_center_show_lite_game", this.ftV);
                this.ftW = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("profile_swan_app_key", this.ftW);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.Cd(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.pageExtra.f.bDR().Dx(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putLong("plugin_wait_time", optLong);
                }
                this.aNg = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_game_frs_live_tab_video_url", this.aNg);
                this.aNn = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_personal_income_detail_url", this.aNn);
                this.ftX = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_personal_privilege_detail_url", this.ftX);
                this.ftY = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_personal_exp_detail_url", this.ftY);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aNu = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("show_live_forum_url", this.aNu);
                    this.ftZ = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("show_live_forum_name", this.ftZ);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.fua = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fub = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_my_live_privilege_mark_detail_url", this.fua);
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_my_live_privilege_effect_detail_url", this.fub);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.fuc = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt("baidu_financial_display", this.fuc);
                }
                String optString5 = jSONObject.optString("live_bar");
                fG(optString5);
                com.baidu.tbadk.core.sharedPref.b.brR().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                new e().dx(jSONObject);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.brR().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.brR().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fG(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.brR().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bwP() {
        return this.liveForumMap;
    }

    public String bwQ() {
        return this.ftl;
    }

    public String bwR() {
        return this.ftg;
    }

    public String bwS() {
        return this.fth;
    }

    public String bwT() {
        return this.fti;
    }

    public String bwU() {
        return this.ftj;
    }

    public String bwV() {
        return this.ftk;
    }

    public String bwW() {
        return this.ftv;
    }

    public String bwX() {
        return this.ftw;
    }

    public String bwY() {
        return this.ftx;
    }

    public String bwZ() {
        return this.ftm;
    }

    public String bxa() {
        return this.ftn;
    }

    public long bxb() {
        return this.fto;
    }

    public int bxc() {
        return this.ftq;
    }

    public long bxd() {
        return this.lastUpdateTime;
    }

    public int bxe() {
        return this.ftD;
    }

    public int bxf() {
        return this.ftE;
    }

    public long bxg() {
        return this.fts;
    }

    public int bxh() {
        return this.ftt;
    }

    public int bxi() {
        return this.ftr;
    }

    public String bxj() {
        return this.infoIconUrl;
    }

    public String bxk() {
        return this.infoTargetUrl;
    }

    public long bxl() {
        return this.infoTimeStamp;
    }

    public String bxm() {
        return this.ftA;
    }

    public boolean bxn() {
        return this.fty == 1;
    }

    public int bxo() {
        return this.ftu;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bxp() {
        return this.ftB;
    }

    public String bxq() {
        return this.ftC;
    }

    public long bxr() {
        return this.ftF;
    }

    public boolean bxs() {
        return this.ftG;
    }

    public long bxt() {
        return this.ftH;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bxu() {
        return this.ftK;
    }

    public int bxv() {
        return this.ftL;
    }

    public ab bxw() {
        return this.ftI;
    }

    public int bxx() {
        return this.ftM;
    }

    public long bxy() {
        return this.ftR;
    }

    public long bxz() {
        return this.ftS;
    }

    public boolean bxA() {
        return this.ftT;
    }

    public ad bxB() {
        return this.ftU;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bxC() {
        return this.ftV;
    }

    public String bxD() {
        return this.ftW;
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
