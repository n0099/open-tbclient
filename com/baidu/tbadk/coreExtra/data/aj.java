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
    private String aLV;
    private String aMc;
    private String aMj;
    private b activityPrizeData;
    private long csq;
    private String fdH;
    private String fdI;
    private String fdJ;
    private String fdK;
    private String fdL;
    private String fdM;
    private String fdN;
    private String fdO;
    private long fdP;
    private int fdQ;
    private int fdR;
    private long fdS;
    private int fdT;
    private String fdV;
    private String fdW;
    private String fdX;
    public int fdZ;
    private String feA;
    private String feB;
    private int feC;
    private String feb;
    private String fec;
    private int fed;
    private int fee;
    private long fef;
    private boolean feg;
    private long feh;
    private ab fei;
    private String fej;
    private String fen;
    private String fep;
    private int feq;
    private long fer;
    private long fes;
    private ad feu;
    private boolean fev;
    private String few;
    private String fex;
    private String fey;
    private String fez;
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
    private int fdU = 0;
    private int fdY = 2;
    private String fea = "";
    private int fek = 0;
    private int fel = 0;
    private int fem = 0;
    private int feo = 0;
    private boolean fet = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fdH = jSONObject.optString("drop_pic");
                this.fdI = jSONObject.optString("drop_pic_md5");
                this.fdJ = jSONObject.optString("drop_pic_num");
                this.fdK = jSONObject.optString("drop_bg_color_day");
                this.fdL = jSONObject.optString("drop_bg_color_night");
                this.fdM = jSONObject.optString("apply_vip_live_room_pid");
                this.fdV = jSONObject.optString("max_cache");
                this.fdW = jSONObject.optString("frs_max_cache");
                this.fdX = jSONObject.optString("frs_pn");
                this.fdN = jSONObject.optString("tail_link");
                this.fdO = jSONObject.optString("bubble_link");
                this.fdP = jSONObject.optLong("use_duration");
                this.fdQ = jSONObject.optInt("xiaoying_time");
                this.csq = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fec = jSONObject.optString("url_analyze_text");
                this.fdR = jSONObject.optInt("new_resign", 0);
                this.fdS = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.fdT = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fdY = jSONObject.optInt("localvideo_open", 2);
                this.fdZ = jSONObject.optInt("card_show_statistic", 200);
                this.fea = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bCg().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.fdU = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.feb = jSONObject.optString("nickname_activity_link");
                this.fed = jSONObject.optInt("android_tab_show", 55);
                this.fee = jSONObject.optInt("ribao_switch", 0);
                this.fef = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.feh = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.feg = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.feg);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fei = new ab();
                    this.fei.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.CM(jSONObject.optInt("android_max_stranger"));
                this.fek = jSONObject.optInt("style_ab_switch", 0);
                this.fel = jSONObject.optInt("abstract_ab_switch", 0);
                this.fej = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fej);
                this.fem = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fen = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.fen)) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_baidu_password_re", this.fen);
                }
                this.fep = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.fep)) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_redpacket_pop", this.fep);
                }
                this.feq = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_video_guide_max_count", this.feq);
                this.feo = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_concern_tab_tips_switch", this.feo);
                this.fer = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.fes = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fet = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.feu == null) {
                        this.feu = new ad();
                    }
                    this.feu.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.fev = false;
                } else if (optInt == 1) {
                    this.fev = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("person_center_show_lite_game", this.fev);
                this.few = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("profile_swan_app_key", this.few);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.CM(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bCc().Eg(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putLong("plugin_wait_time", optLong);
                }
                this.aLV = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_game_frs_live_tab_video_url", this.aLV);
                this.aMc = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_personal_income_detail_url", this.aMc);
                this.fex = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_personal_privilege_detail_url", this.fex);
                this.fey = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_personal_exp_detail_url", this.fey);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aMj = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("show_live_forum_url", this.aMj);
                    this.fez = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("show_live_forum_name", this.fez);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.feA = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.feB = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_my_live_privilege_mark_detail_url", this.feA);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_my_live_privilege_effect_detail_url", this.feB);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.feC = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt("baidu_financial_display", this.feC);
                }
                String optString5 = jSONObject.optString("live_bar");
                gr(optString5);
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gr(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bqh().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bvd() {
        return this.liveForumMap;
    }

    public String bve() {
        return this.fdM;
    }

    public String bvf() {
        return this.fdH;
    }

    public String bvg() {
        return this.fdI;
    }

    public String bvh() {
        return this.fdJ;
    }

    public String bvi() {
        return this.fdK;
    }

    public String bvj() {
        return this.fdL;
    }

    public String bvk() {
        return this.fdV;
    }

    public String bvl() {
        return this.fdW;
    }

    public String bvm() {
        return this.fdX;
    }

    public String bvn() {
        return this.fdN;
    }

    public String bvo() {
        return this.fdO;
    }

    public long bvp() {
        return this.fdP;
    }

    public int bvq() {
        return this.fdQ;
    }

    public long bvr() {
        return this.csq;
    }

    public int bvs() {
        return this.fed;
    }

    public int bvt() {
        return this.fee;
    }

    public long bvu() {
        return this.fdS;
    }

    public int bvv() {
        return this.fdT;
    }

    public int bvw() {
        return this.fdR;
    }

    public String bvx() {
        return this.infoIconUrl;
    }

    public String bvy() {
        return this.infoTargetUrl;
    }

    public long bvz() {
        return this.infoTimeStamp;
    }

    public String bvA() {
        return this.fea;
    }

    public boolean bvB() {
        return this.fdY == 1;
    }

    public int bvC() {
        return this.fdU;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bvD() {
        return this.feb;
    }

    public String bvE() {
        return this.fec;
    }

    public long bvF() {
        return this.fef;
    }

    public boolean bvG() {
        return this.feg;
    }

    public long bvH() {
        return this.feh;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bvI() {
        return this.fek;
    }

    public int bvJ() {
        return this.fel;
    }

    public ab bvK() {
        return this.fei;
    }

    public int bvL() {
        return this.fem;
    }

    public long bvM() {
        return this.fer;
    }

    public long bvN() {
        return this.fes;
    }

    public boolean bvO() {
        return this.fet;
    }

    public ad bvP() {
        return this.feu;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bvQ() {
        return this.fev;
    }

    public String bvR() {
        return this.few;
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
