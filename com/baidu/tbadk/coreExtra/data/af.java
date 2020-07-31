package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private String aAO;
    private String aAV;
    private String aBc;
    private b activityPrizeData;
    private long bKf;
    private String eqL;
    private String eqM;
    private String eqN;
    private String eqO;
    private String eqP;
    private String eqQ;
    private String eqR;
    private String eqS;
    private long eqT;
    private int eqU;
    private int eqV;
    private long eqW;
    private int eqX;
    private String eqZ;
    private boolean erA;
    private String erB;
    private String erC;
    private String erD;
    private String erE;
    private String erF;
    private int erG;
    private String era;
    private String erb;
    public int erd;
    private String erf;
    private String erg;
    private int erh;
    private int eri;
    private long erj;
    private boolean erk;
    private long erl;
    private x erm;
    private String ern;
    private String ers;
    private String eru;
    private int erv;
    private long erw;
    private long erx;
    private z erz;
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
    private int eqY = 0;
    private int erc = 2;
    private String ere = "";
    private int ero = 0;
    private int erp = 0;
    private int erq = 0;
    private int ert = 0;
    private boolean ery = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eqL = jSONObject.optString("drop_pic");
                this.eqM = jSONObject.optString("drop_pic_md5");
                this.eqN = jSONObject.optString("drop_pic_num");
                this.eqO = jSONObject.optString("drop_bg_color_day");
                this.eqP = jSONObject.optString("drop_bg_color_night");
                this.eqQ = jSONObject.optString("apply_vip_live_room_pid");
                this.eqZ = jSONObject.optString("max_cache");
                this.era = jSONObject.optString("frs_max_cache");
                this.erb = jSONObject.optString("frs_pn");
                this.eqR = jSONObject.optString("tail_link");
                this.eqS = jSONObject.optString("bubble_link");
                this.eqT = jSONObject.optLong("use_duration");
                this.eqU = jSONObject.optInt("xiaoying_time");
                this.bKf = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.erg = jSONObject.optString("url_analyze_text");
                this.eqV = jSONObject.optInt("new_resign", 0);
                this.eqW = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.eqX = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.erc = jSONObject.optInt("localvideo_open", 2);
                this.erd = jSONObject.optInt("card_show_statistic", 200);
                this.ere = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.blm().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.eqY = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.erf = jSONObject.optString("nickname_activity_link");
                this.erh = jSONObject.optInt("android_tab_show", 55);
                this.eri = jSONObject.optInt("ribao_switch", 0);
                this.erj = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.erl = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.erk = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.erk);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.erm = new x();
                    this.erm.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.yG(jSONObject.optInt("android_max_stranger"));
                this.ero = jSONObject.optInt("style_ab_switch", 0);
                this.erp = jSONObject.optInt("abstract_ab_switch", 0);
                this.ern = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.ern);
                this.erq = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.ers = jSONObject.optString("shoubai_regex", "");
                if (!as.isEmpty(this.ers)) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_baidu_password_re", this.ers);
                }
                this.eru = jSONObject.optString("redpacket_pop", "");
                if (!as.isEmpty(this.eru)) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_redpacket_pop", this.eru);
                }
                this.erv = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_video_guide_max_count", this.erv);
                this.ert = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_concern_tab_tips_switch", this.ert);
                this.erw = jSONObject.optInt("dialog_pull_time", 60) * as.MS_TO_MIN;
                this.erx = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.ery = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.erz == null) {
                        this.erz = new z();
                    }
                    this.erz.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.erA = false;
                } else if (optInt == 1) {
                    this.erA = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("person_center_show_lite_game", this.erA);
                this.erB = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("profile_swan_app_key", this.erB);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                u.yG(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bli().Aa(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong("plugin_wait_time", optLong);
                }
                this.aAO = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_game_frs_live_tab_video_url", this.aAO);
                this.aAV = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_personal_income_detail_url", this.aAV);
                this.erC = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_personal_privilege_detail_url", this.erC);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aBc = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("show_live_forum_url", this.aBc);
                    this.erD = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("show_live_forum_name", this.erD);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.erE = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.erF = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_my_live_privilege_mark_detail_url", this.erE);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_my_live_privilege_effect_detail_url", this.erF);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.erG = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt("baidu_financial_display", this.erG);
                }
                String optString5 = jSONObject.optString("live_bar");
                ey(optString5);
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                aa aaVar = new aa();
                aaVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aaVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void ey(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aZP().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bew() {
        return this.liveForumMap;
    }

    public String bex() {
        return this.eqQ;
    }

    public String bey() {
        return this.eqL;
    }

    public String bez() {
        return this.eqM;
    }

    public String beA() {
        return this.eqN;
    }

    public String beB() {
        return this.eqO;
    }

    public String beC() {
        return this.eqP;
    }

    public String beD() {
        return this.eqZ;
    }

    public String beE() {
        return this.era;
    }

    public String beF() {
        return this.erb;
    }

    public String beG() {
        return this.eqR;
    }

    public String beH() {
        return this.eqS;
    }

    public long beI() {
        return this.eqT;
    }

    public int beJ() {
        return this.eqU;
    }

    public long beK() {
        return this.bKf;
    }

    public int beL() {
        return this.erh;
    }

    public int beM() {
        return this.eri;
    }

    public long beN() {
        return this.eqW;
    }

    public int beO() {
        return this.eqX;
    }

    public int beP() {
        return this.eqV;
    }

    public String beQ() {
        return this.infoIconUrl;
    }

    public String beR() {
        return this.infoTargetUrl;
    }

    public long beS() {
        return this.infoTimeStamp;
    }

    public String beT() {
        return this.ere;
    }

    public boolean beU() {
        return this.erc == 1;
    }

    public int beV() {
        return this.eqY;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String beW() {
        return this.erf;
    }

    public String beX() {
        return this.erg;
    }

    public long beY() {
        return this.erj;
    }

    public boolean beZ() {
        return this.erk;
    }

    public long bfa() {
        return this.erl;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bfb() {
        return this.ero;
    }

    public int bfc() {
        return this.erp;
    }

    public x bfd() {
        return this.erm;
    }

    public int bfe() {
        return this.erq;
    }

    public long bff() {
        return this.erw;
    }

    public long bfg() {
        return this.erx;
    }

    public boolean bfh() {
        return this.ery;
    }

    public z bfi() {
        return this.erz;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bfj() {
        return this.erA;
    }

    public String bfk() {
        return this.erB;
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
