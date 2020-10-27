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
    private String aKV;
    private String aLc;
    private String aLj;
    private b activityPrizeData;
    private long cmt;
    private String eXR;
    private String eXS;
    private String eXT;
    private String eXU;
    private String eXV;
    private String eXW;
    private String eXX;
    private String eXY;
    private long eXZ;
    private int eYA;
    private long eYB;
    private long eYC;
    private ad eYE;
    private boolean eYF;
    private String eYG;
    private String eYH;
    private String eYI;
    private String eYJ;
    private String eYK;
    private int eYL;
    private int eYa;
    private int eYb;
    private long eYc;
    private int eYd;
    private String eYf;
    private String eYg;
    private String eYh;
    public int eYj;
    private String eYl;
    private String eYm;
    private int eYn;
    private int eYo;
    private long eYp;
    private boolean eYq;
    private long eYr;
    private ab eYs;
    private String eYt;
    private String eYx;
    private String eYz;
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
    private int eYe = 0;
    private int eYi = 2;
    private String eYk = "";
    private int eYu = 0;
    private int eYv = 0;
    private int eYw = 0;
    private int eYy = 0;
    private boolean eYD = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eXR = jSONObject.optString("drop_pic");
                this.eXS = jSONObject.optString("drop_pic_md5");
                this.eXT = jSONObject.optString("drop_pic_num");
                this.eXU = jSONObject.optString("drop_bg_color_day");
                this.eXV = jSONObject.optString("drop_bg_color_night");
                this.eXW = jSONObject.optString("apply_vip_live_room_pid");
                this.eYf = jSONObject.optString("max_cache");
                this.eYg = jSONObject.optString("frs_max_cache");
                this.eYh = jSONObject.optString("frs_pn");
                this.eXX = jSONObject.optString("tail_link");
                this.eXY = jSONObject.optString("bubble_link");
                this.eXZ = jSONObject.optLong("use_duration");
                this.eYa = jSONObject.optInt("xiaoying_time");
                this.cmt = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.eYm = jSONObject.optString("url_analyze_text");
                this.eYb = jSONObject.optInt("new_resign", 0);
                this.eYc = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.eYd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.eYi = jSONObject.optInt("localvideo_open", 2);
                this.eYj = jSONObject.optInt("card_show_statistic", 200);
                this.eYk = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bzH().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.eYe = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.eYl = jSONObject.optString("nickname_activity_link");
                this.eYn = jSONObject.optInt("android_tab_show", 55);
                this.eYo = jSONObject.optInt("ribao_switch", 0);
                this.eYp = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.eYr = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.eYq = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.eYq);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.eYs = new ab();
                    this.eYs.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.Cz(jSONObject.optInt("android_max_stranger"));
                this.eYu = jSONObject.optInt("style_ab_switch", 0);
                this.eYv = jSONObject.optInt("abstract_ab_switch", 0);
                this.eYt = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.eYt);
                this.eYw = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.eYx = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.eYx)) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_baidu_password_re", this.eYx);
                }
                this.eYz = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.eYz)) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_redpacket_pop", this.eYz);
                }
                this.eYA = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_video_guide_max_count", this.eYA);
                this.eYy = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_concern_tab_tips_switch", this.eYy);
                this.eYB = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.eYC = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.eYD = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.eYE == null) {
                        this.eYE = new ad();
                    }
                    this.eYE.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.eYF = false;
                } else if (optInt == 1) {
                    this.eYF = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("person_center_show_lite_game", this.eYF);
                this.eYG = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("profile_swan_app_key", this.eYG);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.Cy(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.bzD().DS(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putLong("plugin_wait_time", optLong);
                }
                this.aKV = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_game_frs_live_tab_video_url", this.aKV);
                this.aLc = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_personal_income_detail_url", this.aLc);
                this.eYH = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_personal_privilege_detail_url", this.eYH);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aLj = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("show_live_forum_url", this.aLj);
                    this.eYI = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("show_live_forum_name", this.eYI);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.eYJ = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.eYK = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_my_live_privilege_mark_detail_url", this.eYJ);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_my_live_privilege_effect_detail_url", this.eYK);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.eYL = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt("baidu_financial_display", this.eYL);
                }
                String optString5 = jSONObject.optString("live_bar");
                gn(optString5);
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gn(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bnH().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bsD() {
        return this.liveForumMap;
    }

    public String bsE() {
        return this.eXW;
    }

    public String bsF() {
        return this.eXR;
    }

    public String bsG() {
        return this.eXS;
    }

    public String bsH() {
        return this.eXT;
    }

    public String bsI() {
        return this.eXU;
    }

    public String bsJ() {
        return this.eXV;
    }

    public String bsK() {
        return this.eYf;
    }

    public String bsL() {
        return this.eYg;
    }

    public String bsM() {
        return this.eYh;
    }

    public String bsN() {
        return this.eXX;
    }

    public String bsO() {
        return this.eXY;
    }

    public long bsP() {
        return this.eXZ;
    }

    public int bsQ() {
        return this.eYa;
    }

    public long bsR() {
        return this.cmt;
    }

    public int bsS() {
        return this.eYn;
    }

    public int bsT() {
        return this.eYo;
    }

    public long bsU() {
        return this.eYc;
    }

    public int bsV() {
        return this.eYd;
    }

    public int bsW() {
        return this.eYb;
    }

    public String bsX() {
        return this.infoIconUrl;
    }

    public String bsY() {
        return this.infoTargetUrl;
    }

    public long bsZ() {
        return this.infoTimeStamp;
    }

    public String bta() {
        return this.eYk;
    }

    public boolean btb() {
        return this.eYi == 1;
    }

    public int btc() {
        return this.eYe;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String btd() {
        return this.eYl;
    }

    public String bte() {
        return this.eYm;
    }

    public long btf() {
        return this.eYp;
    }

    public boolean btg() {
        return this.eYq;
    }

    public long bth() {
        return this.eYr;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bti() {
        return this.eYu;
    }

    public int btj() {
        return this.eYv;
    }

    public ab btk() {
        return this.eYs;
    }

    public int btl() {
        return this.eYw;
    }

    public long btm() {
        return this.eYB;
    }

    public long btn() {
        return this.eYC;
    }

    public boolean bto() {
        return this.eYD;
    }

    public ad btp() {
        return this.eYE;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean btq() {
        return this.eYF;
    }

    public String btr() {
        return this.eYG;
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
