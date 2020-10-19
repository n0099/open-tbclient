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
    private String aKA;
    private String aKH;
    private String aKt;
    private b activityPrizeData;
    private long cdV;
    private String ePA;
    private String ePB;
    private String ePC;
    private long ePD;
    private int ePE;
    private int ePF;
    private long ePG;
    private int ePH;
    private String ePJ;
    private String ePK;
    private String ePL;
    public int ePN;
    private String ePP;
    private String ePQ;
    private int ePR;
    private int ePS;
    private long ePT;
    private boolean ePU;
    private long ePV;
    private ab ePW;
    private String ePX;
    private String ePv;
    private String ePw;
    private String ePx;
    private String ePy;
    private String ePz;
    private String eQb;
    private String eQd;
    private int eQe;
    private long eQf;
    private long eQg;
    private ad eQi;
    private boolean eQj;
    private String eQk;
    private String eQl;
    private String eQm;
    private String eQn;
    private String eQo;
    private int eQp;
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
    private int ePI = 0;
    private int ePM = 2;
    private String ePO = "";
    private int ePY = 0;
    private int ePZ = 0;
    private int eQa = 0;
    private int eQc = 0;
    private boolean eQh = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ePv = jSONObject.optString("drop_pic");
                this.ePw = jSONObject.optString("drop_pic_md5");
                this.ePx = jSONObject.optString("drop_pic_num");
                this.ePy = jSONObject.optString("drop_bg_color_day");
                this.ePz = jSONObject.optString("drop_bg_color_night");
                this.ePA = jSONObject.optString("apply_vip_live_room_pid");
                this.ePJ = jSONObject.optString("max_cache");
                this.ePK = jSONObject.optString("frs_max_cache");
                this.ePL = jSONObject.optString("frs_pn");
                this.ePB = jSONObject.optString("tail_link");
                this.ePC = jSONObject.optString("bubble_link");
                this.ePD = jSONObject.optLong("use_duration");
                this.ePE = jSONObject.optInt("xiaoying_time");
                this.cdV = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.ePQ = jSONObject.optString("url_analyze_text");
                this.ePF = jSONObject.optInt("new_resign", 0);
                this.ePG = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.ePH = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ePM = jSONObject.optInt("localvideo_open", 2);
                this.ePN = jSONObject.optInt("card_show_statistic", 200);
                this.ePO = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bxO().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.ePI = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.ePP = jSONObject.optString("nickname_activity_link");
                this.ePR = jSONObject.optInt("android_tab_show", 55);
                this.ePS = jSONObject.optInt("ribao_switch", 0);
                this.ePT = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.ePV = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.ePU = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.ePU);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.ePW = new ab();
                    this.ePW.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.Cg(jSONObject.optInt("android_max_stranger"));
                this.ePY = jSONObject.optInt("style_ab_switch", 0);
                this.ePZ = jSONObject.optInt("abstract_ab_switch", 0);
                this.ePX = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.blO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.ePX);
                this.eQa = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.eQb = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.eQb)) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("key_baidu_password_re", this.eQb);
                }
                this.eQd = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.eQd)) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("key_redpacket_pop", this.eQd);
                }
                this.eQe = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_video_guide_max_count", this.eQe);
                this.eQc = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_concern_tab_tips_switch", this.eQc);
                this.eQf = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.eQg = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.eQh = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.eQi == null) {
                        this.eQi = new ad();
                    }
                    this.eQi.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.eQj = false;
                } else if (optInt == 1) {
                    this.eQj = true;
                }
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("person_center_show_lite_game", this.eQj);
                this.eQk = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("profile_swan_app_key", this.eQk);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.Cf(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bxK().Dz(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putLong("plugin_wait_time", optLong);
                }
                this.aKt = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_game_frs_live_tab_video_url", this.aKt);
                this.aKA = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_personal_income_detail_url", this.aKA);
                this.eQl = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_personal_privilege_detail_url", this.eQl);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aKH = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("show_live_forum_url", this.aKH);
                    this.eQm = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("show_live_forum_name", this.eQm);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.eQn = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.eQo = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_my_live_privilege_mark_detail_url", this.eQn);
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_my_live_privilege_effect_detail_url", this.eQo);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.eQp = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.blO().putInt("baidu_financial_display", this.eQp);
                }
                String optString5 = jSONObject.optString("live_bar");
                gm(optString5);
                com.baidu.tbadk.core.sharedPref.b.blO().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.blO().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.blO().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gm(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.blO().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bqK() {
        return this.liveForumMap;
    }

    public String bqL() {
        return this.ePA;
    }

    public String bqM() {
        return this.ePv;
    }

    public String bqN() {
        return this.ePw;
    }

    public String bqO() {
        return this.ePx;
    }

    public String bqP() {
        return this.ePy;
    }

    public String bqQ() {
        return this.ePz;
    }

    public String bqR() {
        return this.ePJ;
    }

    public String bqS() {
        return this.ePK;
    }

    public String bqT() {
        return this.ePL;
    }

    public String bqU() {
        return this.ePB;
    }

    public String bqV() {
        return this.ePC;
    }

    public long bqW() {
        return this.ePD;
    }

    public int bqX() {
        return this.ePE;
    }

    public long bqY() {
        return this.cdV;
    }

    public int bqZ() {
        return this.ePR;
    }

    public int bra() {
        return this.ePS;
    }

    public long brb() {
        return this.ePG;
    }

    public int brc() {
        return this.ePH;
    }

    public int brd() {
        return this.ePF;
    }

    public String bre() {
        return this.infoIconUrl;
    }

    public String brf() {
        return this.infoTargetUrl;
    }

    public long brg() {
        return this.infoTimeStamp;
    }

    public String brh() {
        return this.ePO;
    }

    public boolean bri() {
        return this.ePM == 1;
    }

    public int brj() {
        return this.ePI;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String brk() {
        return this.ePP;
    }

    public String brl() {
        return this.ePQ;
    }

    public long brm() {
        return this.ePT;
    }

    public boolean brn() {
        return this.ePU;
    }

    public long bro() {
        return this.ePV;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int brp() {
        return this.ePY;
    }

    public int brq() {
        return this.ePZ;
    }

    public ab brr() {
        return this.ePW;
    }

    public int brs() {
        return this.eQa;
    }

    public long brt() {
        return this.eQf;
    }

    public long bru() {
        return this.eQg;
    }

    public boolean brv() {
        return this.eQh;
    }

    public ad brw() {
        return this.eQi;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean brx() {
        return this.eQj;
    }

    public String bry() {
        return this.eQk;
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
