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
    private String aHD;
    private String aHp;
    private String aHw;
    private b activityPrizeData;
    private long bRH;
    private int eDA;
    private String eDC;
    private String eDD;
    private String eDE;
    public int eDG;
    private String eDI;
    private String eDJ;
    private int eDK;
    private int eDL;
    private long eDM;
    private boolean eDN;
    private long eDO;
    private ab eDP;
    private String eDQ;
    private String eDU;
    private String eDW;
    private int eDX;
    private long eDY;
    private long eDZ;
    private String eDo;
    private String eDp;
    private String eDq;
    private String eDr;
    private String eDs;
    private String eDt;
    private String eDu;
    private String eDv;
    private long eDw;
    private int eDx;
    private int eDy;
    private long eDz;
    private ad eEb;
    private boolean eEc;
    private String eEd;
    private String eEe;
    private String eEf;
    private String eEg;
    private String eEh;
    private int eEi;
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
    private int eDB = 0;
    private int eDF = 2;
    private String eDH = "";
    private int eDR = 0;
    private int eDS = 0;
    private int eDT = 0;
    private int eDV = 0;
    private boolean eEa = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eDo = jSONObject.optString("drop_pic");
                this.eDp = jSONObject.optString("drop_pic_md5");
                this.eDq = jSONObject.optString("drop_pic_num");
                this.eDr = jSONObject.optString("drop_bg_color_day");
                this.eDs = jSONObject.optString("drop_bg_color_night");
                this.eDt = jSONObject.optString("apply_vip_live_room_pid");
                this.eDC = jSONObject.optString("max_cache");
                this.eDD = jSONObject.optString("frs_max_cache");
                this.eDE = jSONObject.optString("frs_pn");
                this.eDu = jSONObject.optString("tail_link");
                this.eDv = jSONObject.optString("bubble_link");
                this.eDw = jSONObject.optLong("use_duration");
                this.eDx = jSONObject.optInt("xiaoying_time");
                this.bRH = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.eDJ = jSONObject.optString("url_analyze_text");
                this.eDy = jSONObject.optInt("new_resign", 0);
                this.eDz = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.eDA = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.eDF = jSONObject.optInt("localvideo_open", 2);
                this.eDG = jSONObject.optInt("card_show_statistic", 200);
                this.eDH = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bve().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.eDB = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.eDI = jSONObject.optString("nickname_activity_link");
                this.eDK = jSONObject.optInt("android_tab_show", 55);
                this.eDL = jSONObject.optInt("ribao_switch", 0);
                this.eDM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.eDO = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.eDN = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.eDN);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.eDP = new ab();
                    this.eDP.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.BA(jSONObject.optInt("android_max_stranger"));
                this.eDR = jSONObject.optInt("style_ab_switch", 0);
                this.eDS = jSONObject.optInt("abstract_ab_switch", 0);
                this.eDQ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.eDQ);
                this.eDT = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.eDU = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.eDU)) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_baidu_password_re", this.eDU);
                }
                this.eDW = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.eDW)) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_redpacket_pop", this.eDW);
                }
                this.eDX = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_video_guide_max_count", this.eDX);
                this.eDV = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_concern_tab_tips_switch", this.eDV);
                this.eDY = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.eDZ = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.eEa = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.eEb == null) {
                        this.eEb = new ad();
                    }
                    this.eEb.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.eEc = false;
                } else if (optInt == 1) {
                    this.eEc = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("person_center_show_lite_game", this.eEc);
                this.eEd = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("profile_swan_app_key", this.eEd);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.Bt(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bva().CN(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putLong("plugin_wait_time", optLong);
                }
                this.aHp = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_game_frs_live_tab_video_url", this.aHp);
                this.aHw = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_personal_income_detail_url", this.aHw);
                this.eEe = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_personal_privilege_detail_url", this.eEe);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aHD = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("show_live_forum_url", this.aHD);
                    this.eEf = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("show_live_forum_name", this.eEf);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.eEg = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.eEh = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_my_live_privilege_mark_detail_url", this.eEg);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_my_live_privilege_effect_detail_url", this.eEh);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.eEi = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt("baidu_financial_display", this.eEi);
                }
                String optString5 = jSONObject.optString("live_bar");
                fY(optString5);
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fY(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bjf().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> boa() {
        return this.liveForumMap;
    }

    public String bob() {
        return this.eDt;
    }

    public String boc() {
        return this.eDo;
    }

    public String bod() {
        return this.eDp;
    }

    public String boe() {
        return this.eDq;
    }

    public String bof() {
        return this.eDr;
    }

    public String bog() {
        return this.eDs;
    }

    public String boh() {
        return this.eDC;
    }

    public String boi() {
        return this.eDD;
    }

    public String boj() {
        return this.eDE;
    }

    public String bok() {
        return this.eDu;
    }

    public String bol() {
        return this.eDv;
    }

    public long bom() {
        return this.eDw;
    }

    public int bon() {
        return this.eDx;
    }

    public long boo() {
        return this.bRH;
    }

    public int bop() {
        return this.eDK;
    }

    public int boq() {
        return this.eDL;
    }

    public long bor() {
        return this.eDz;
    }

    public int bos() {
        return this.eDA;
    }

    public int bot() {
        return this.eDy;
    }

    public String bou() {
        return this.infoIconUrl;
    }

    public String bov() {
        return this.infoTargetUrl;
    }

    public long bow() {
        return this.infoTimeStamp;
    }

    public String box() {
        return this.eDH;
    }

    public boolean boy() {
        return this.eDF == 1;
    }

    public int boz() {
        return this.eDB;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String boA() {
        return this.eDI;
    }

    public String boB() {
        return this.eDJ;
    }

    public long boC() {
        return this.eDM;
    }

    public boolean boD() {
        return this.eDN;
    }

    public long boE() {
        return this.eDO;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int boF() {
        return this.eDR;
    }

    public int boG() {
        return this.eDS;
    }

    public ab boH() {
        return this.eDP;
    }

    public int boI() {
        return this.eDT;
    }

    public long boJ() {
        return this.eDY;
    }

    public long boK() {
        return this.eDZ;
    }

    public boolean boL() {
        return this.eEa;
    }

    public ad boM() {
        return this.eEb;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean boN() {
        return this.eEc;
    }

    public String boO() {
        return this.eEd;
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
