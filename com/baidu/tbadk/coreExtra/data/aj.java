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
    private String aNf;
    private String aNm;
    private String aNt;
    private b activityPrizeData;
    private long cxC;
    private int fkA;
    private String fkC;
    private String fkD;
    private String fkE;
    public int fkG;
    private String fkI;
    private String fkJ;
    private int fkK;
    private int fkL;
    private long fkM;
    private boolean fkN;
    private long fkO;
    private ab fkP;
    private String fkQ;
    private String fkU;
    private String fkW;
    private int fkX;
    private long fkY;
    private long fkZ;
    private String fko;
    private String fkp;
    private String fkq;
    private String fkr;
    private String fks;
    private String fkt;
    private String fku;
    private String fkv;
    private long fkw;
    private int fkx;
    private int fky;
    private long fkz;
    private ad flb;
    private boolean flc;
    private String fld;
    private String fle;
    private String flf;
    private String flg;
    private String flh;
    private String fli;
    private int flj;
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
    private int fkB = 0;
    private int fkF = 2;
    private String fkH = "";
    private int fkR = 0;
    private int fkS = 0;
    private int fkT = 0;
    private int fkV = 0;
    private boolean fla = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fko = jSONObject.optString("drop_pic");
                this.fkp = jSONObject.optString("drop_pic_md5");
                this.fkq = jSONObject.optString("drop_pic_num");
                this.fkr = jSONObject.optString("drop_bg_color_day");
                this.fks = jSONObject.optString("drop_bg_color_night");
                this.fkt = jSONObject.optString("apply_vip_live_room_pid");
                this.fkC = jSONObject.optString("max_cache");
                this.fkD = jSONObject.optString("frs_max_cache");
                this.fkE = jSONObject.optString("frs_pn");
                this.fku = jSONObject.optString("tail_link");
                this.fkv = jSONObject.optString("bubble_link");
                this.fkw = jSONObject.optLong("use_duration");
                this.fkx = jSONObject.optInt("xiaoying_time");
                this.cxC = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fkJ = jSONObject.optString("url_analyze_text");
                this.fky = jSONObject.optInt("new_resign", 0);
                this.fkz = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.fkA = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fkF = jSONObject.optInt("localvideo_open", 2);
                this.fkG = jSONObject.optInt("card_show_statistic", 200);
                this.fkH = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bEZ().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.fkB = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.fkI = jSONObject.optString("nickname_activity_link");
                this.fkK = jSONObject.optInt("android_tab_show", 55);
                this.fkL = jSONObject.optInt("ribao_switch", 0);
                this.fkM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.fkO = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.fkN = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.fkN);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fkP = new ab();
                    this.fkP.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.DZ(jSONObject.optInt("android_max_stranger"));
                this.fkR = jSONObject.optInt("style_ab_switch", 0);
                this.fkS = jSONObject.optInt("abstract_ab_switch", 0);
                this.fkQ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fkQ);
                this.fkT = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fkU = jSONObject.optString("shoubai_regex", "");
                if (!au.isEmpty(this.fkU)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_baidu_password_re", this.fkU);
                }
                this.fkW = jSONObject.optString("redpacket_pop", "");
                if (!au.isEmpty(this.fkW)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_redpacket_pop", this.fkW);
                }
                this.fkX = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_video_guide_max_count", this.fkX);
                this.fkV = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_concern_tab_tips_switch", this.fkV);
                this.fkY = jSONObject.optInt("dialog_pull_time", 60) * au.MS_TO_MIN;
                this.fkZ = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fla = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.flb == null) {
                        this.flb = new ad();
                    }
                    this.flb.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.flc = false;
                } else if (optInt == 1) {
                    this.flc = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("person_center_show_lite_game", this.flc);
                this.fld = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("profile_swan_app_key", this.fld);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.CT(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.pageExtra.f.bEV().Eq(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong("plugin_wait_time", optLong);
                }
                this.aNf = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_game_frs_live_tab_video_url", this.aNf);
                this.aNm = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_personal_income_detail_url", this.aNm);
                this.fle = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_personal_privilege_detail_url", this.fle);
                this.flf = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_personal_exp_detail_url", this.flf);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aNt = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("show_live_forum_url", this.aNt);
                    this.flg = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("show_live_forum_name", this.flg);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.flh = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fli = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_my_live_privilege_mark_detail_url", this.flh);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_my_live_privilege_effect_detail_url", this.fli);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.flj = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt("baidu_financial_display", this.flj);
                }
                String optString5 = jSONObject.optString("live_bar");
                gH(optString5);
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void gH(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bsO().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bxT() {
        return this.liveForumMap;
    }

    public String bxU() {
        return this.fkt;
    }

    public String bxV() {
        return this.fko;
    }

    public String bxW() {
        return this.fkp;
    }

    public String bxX() {
        return this.fkq;
    }

    public String bxY() {
        return this.fkr;
    }

    public String bxZ() {
        return this.fks;
    }

    public String bya() {
        return this.fkC;
    }

    public String byb() {
        return this.fkD;
    }

    public String byc() {
        return this.fkE;
    }

    public String byd() {
        return this.fku;
    }

    public String bye() {
        return this.fkv;
    }

    public long byf() {
        return this.fkw;
    }

    public int byg() {
        return this.fkx;
    }

    public long byh() {
        return this.cxC;
    }

    public int byi() {
        return this.fkK;
    }

    public int byj() {
        return this.fkL;
    }

    public long byk() {
        return this.fkz;
    }

    public int byl() {
        return this.fkA;
    }

    public int bym() {
        return this.fky;
    }

    public String byn() {
        return this.infoIconUrl;
    }

    public String byo() {
        return this.infoTargetUrl;
    }

    public long byp() {
        return this.infoTimeStamp;
    }

    public String byq() {
        return this.fkH;
    }

    public boolean byr() {
        return this.fkF == 1;
    }

    public int bys() {
        return this.fkB;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String byt() {
        return this.fkI;
    }

    public String byu() {
        return this.fkJ;
    }

    public long byv() {
        return this.fkM;
    }

    public boolean byw() {
        return this.fkN;
    }

    public long byx() {
        return this.fkO;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int byy() {
        return this.fkR;
    }

    public int byz() {
        return this.fkS;
    }

    public ab byA() {
        return this.fkP;
    }

    public int byB() {
        return this.fkT;
    }

    public long byC() {
        return this.fkY;
    }

    public long byD() {
        return this.fkZ;
    }

    public boolean byE() {
        return this.fla;
    }

    public ad byF() {
        return this.flb;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean byG() {
        return this.flc;
    }

    public String byH() {
        return this.fld;
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
