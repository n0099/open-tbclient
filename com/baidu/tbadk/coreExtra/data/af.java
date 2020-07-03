package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class af {
    private b activityPrizeData;
    private String azB;
    private String azI;
    private String azP;
    private long bJG;
    private String ekA;
    private String ekB;
    private String ekC;
    private String ekD;
    private String ekE;
    private long ekF;
    private int ekG;
    private int ekH;
    private long ekI;
    private int ekJ;
    private String ekL;
    private String ekM;
    private String ekN;
    public int ekP;
    private String ekR;
    private String ekS;
    private int ekT;
    private int ekU;
    private long ekV;
    private boolean ekW;
    private long ekX;
    private x ekY;
    private String ekZ;
    private String ekx;
    private String eky;
    private String ekz;
    private String eld;
    private String elf;
    private int elg;
    private long elh;
    private long eli;
    private z elk;
    private boolean ell;
    private String elm;
    private String eln;
    private String elo;
    private String elp;
    private String elq;
    private int elr;
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
    private int ekK = 0;
    private int ekO = 2;
    private String ekQ = "";
    private int ela = 0;
    private int elb = 0;
    private int elc = 0;
    private int ele = 0;
    private boolean elj = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ekx = jSONObject.optString("drop_pic");
                this.eky = jSONObject.optString("drop_pic_md5");
                this.ekz = jSONObject.optString("drop_pic_num");
                this.ekA = jSONObject.optString("drop_bg_color_day");
                this.ekB = jSONObject.optString("drop_bg_color_night");
                this.ekC = jSONObject.optString("apply_vip_live_room_pid");
                this.ekL = jSONObject.optString("max_cache");
                this.ekM = jSONObject.optString("frs_max_cache");
                this.ekN = jSONObject.optString("frs_pn");
                this.ekD = jSONObject.optString("tail_link");
                this.ekE = jSONObject.optString("bubble_link");
                this.ekF = jSONObject.optLong("use_duration");
                this.ekG = jSONObject.optInt("xiaoying_time");
                this.bJG = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.ekS = jSONObject.optString("url_analyze_text");
                this.ekH = jSONObject.optInt("new_resign", 0);
                this.ekI = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.ekJ = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ekO = jSONObject.optInt("localvideo_open", 2);
                this.ekP = jSONObject.optInt("card_show_statistic", 200);
                this.ekQ = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bhB().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.ekK = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.ekR = jSONObject.optString("nickname_activity_link");
                this.ekT = jSONObject.optInt("android_tab_show", 55);
                this.ekU = jSONObject.optInt("ribao_switch", 0);
                this.ekV = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.ekX = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.ekW = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.ekW);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.ekY = new x();
                    this.ekY.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.yl(jSONObject.optInt("android_max_stranger"));
                this.ela = jSONObject.optInt("style_ab_switch", 0);
                this.elb = jSONObject.optInt("abstract_ab_switch", 0);
                this.ekZ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.ekZ);
                this.elc = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.eld = jSONObject.optString("shoubai_regex", "");
                if (!ar.isEmpty(this.eld)) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_baidu_password_re", this.eld);
                }
                this.elf = jSONObject.optString("redpacket_pop", "");
                if (!ar.isEmpty(this.elf)) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_redpacket_pop", this.elf);
                }
                this.elg = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_video_guide_max_count", this.elg);
                this.ele = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_concern_tab_tips_switch", this.ele);
                this.elh = jSONObject.optInt("dialog_pull_time", 60) * ar.MS_TO_MIN;
                this.eli = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.elj = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.elk == null) {
                        this.elk = new z();
                    }
                    this.elk.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.ell = false;
                } else if (optInt == 1) {
                    this.ell = true;
                }
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("person_center_show_lite_game", this.ell);
                this.elm = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("profile_swan_app_key", this.elm);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                u.xB(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bhx().yT(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putLong("plugin_wait_time", optLong);
                }
                this.azB = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_game_frs_live_tab_video_url", this.azB);
                this.azI = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_personal_income_detail_url", this.azI);
                this.eln = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_personal_privilege_detail_url", this.eln);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.azP = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("show_live_forum_url", this.azP);
                    this.elo = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("show_live_forum_name", this.elo);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.elp = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.elq = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_my_live_privilege_mark_detail_url", this.elp);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_my_live_privilege_effect_detail_url", this.elq);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.elr = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt("baidu_financial_display", this.elr);
                }
                String optString5 = jSONObject.optString("live_bar");
                ez(optString5);
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                aa aaVar = new aa();
                aaVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aaVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void ez(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.aVP().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> baz() {
        return this.liveForumMap;
    }

    public String baA() {
        return this.ekC;
    }

    public String baB() {
        return this.ekx;
    }

    public String baC() {
        return this.eky;
    }

    public String baD() {
        return this.ekz;
    }

    public String baE() {
        return this.ekA;
    }

    public String baF() {
        return this.ekB;
    }

    public String baG() {
        return this.ekL;
    }

    public String baH() {
        return this.ekM;
    }

    public String baI() {
        return this.ekN;
    }

    public String baJ() {
        return this.ekD;
    }

    public String baK() {
        return this.ekE;
    }

    public long baL() {
        return this.ekF;
    }

    public int baM() {
        return this.ekG;
    }

    public long baN() {
        return this.bJG;
    }

    public int baO() {
        return this.ekT;
    }

    public int baP() {
        return this.ekU;
    }

    public long baQ() {
        return this.ekI;
    }

    public int baR() {
        return this.ekJ;
    }

    public int baS() {
        return this.ekH;
    }

    public String baT() {
        return this.infoIconUrl;
    }

    public String baU() {
        return this.infoTargetUrl;
    }

    public long baV() {
        return this.infoTimeStamp;
    }

    public String baW() {
        return this.ekQ;
    }

    public boolean baX() {
        return this.ekO == 1;
    }

    public int baY() {
        return this.ekK;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String baZ() {
        return this.ekR;
    }

    public String bba() {
        return this.ekS;
    }

    public long bbb() {
        return this.ekV;
    }

    public boolean bbc() {
        return this.ekW;
    }

    public long bbd() {
        return this.ekX;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bbe() {
        return this.ela;
    }

    public int bbf() {
        return this.elb;
    }

    public x bbg() {
        return this.ekY;
    }

    public int bbh() {
        return this.elc;
    }

    public long bbi() {
        return this.elh;
    }

    public long bbj() {
        return this.eli;
    }

    public boolean bbk() {
        return this.elj;
    }

    public z bbl() {
        return this.elk;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bbm() {
        return this.ell;
    }

    public String bbn() {
        return this.elm;
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
