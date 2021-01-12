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
    private String aIW;
    private String aJd;
    private String aJk;
    private b activityPrizeData;
    private int fpA;
    private String fpC;
    private String fpD;
    private String fpE;
    public int fpG;
    private String fpI;
    private String fpJ;
    private int fpK;
    private int fpL;
    private long fpM;
    private boolean fpN;
    private long fpO;
    private ab fpP;
    private String fpQ;
    private String fpU;
    private String fpW;
    private int fpX;
    private long fpY;
    private long fpZ;
    private String fpn;
    private String fpo;
    private String fpp;
    private String fpq;
    private String fpr;
    private String fpt;
    private String fpu;
    private String fpv;
    private long fpw;
    private int fpx;
    private int fpy;
    private long fpz;
    private ad fqb;
    private boolean fqc;
    private String fqd;
    private String fqe;
    private String fqf;
    private String fqg;
    private String fqh;
    private String fqi;
    private int fqj;
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
    private int fpB = 0;
    private int fpF = 2;
    private String fpH = "";
    private int fpR = 0;
    private int fpS = 0;
    private int fpT = 0;
    private int fpV = 0;
    private boolean fqa = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fpn = jSONObject.optString("drop_pic");
                this.fpo = jSONObject.optString("drop_pic_md5");
                this.fpp = jSONObject.optString("drop_pic_num");
                this.fpq = jSONObject.optString("drop_bg_color_day");
                this.fpr = jSONObject.optString("drop_bg_color_night");
                this.fpt = jSONObject.optString("apply_vip_live_room_pid");
                this.fpC = jSONObject.optString("max_cache");
                this.fpD = jSONObject.optString("frs_max_cache");
                this.fpE = jSONObject.optString("frs_pn");
                this.fpu = jSONObject.optString("tail_link");
                this.fpv = jSONObject.optString("bubble_link");
                this.fpw = jSONObject.optLong("use_duration");
                this.fpx = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fpJ = jSONObject.optString("url_analyze_text");
                this.fpy = jSONObject.optInt("new_resign", 0);
                this.fpz = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.fpA = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.fpF = jSONObject.optInt("localvideo_open", 2);
                this.fpG = jSONObject.optInt("card_show_statistic", 200);
                this.fpH = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bDA().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.fpB = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.fpI = jSONObject.optString("nickname_activity_link");
                this.fpK = jSONObject.optInt("android_tab_show", 55);
                this.fpL = jSONObject.optInt("ribao_switch", 0);
                this.fpM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.fpO = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.fpN = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.fpN);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fpP = new ab();
                    this.fpP.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.CD(jSONObject.optInt("android_max_stranger"));
                this.fpR = jSONObject.optInt("style_ab_switch", 0);
                this.fpS = jSONObject.optInt("abstract_ab_switch", 0);
                this.fpQ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fpQ);
                this.fpT = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fpU = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.fpU)) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("key_baidu_password_re", this.fpU);
                }
                this.fpW = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.fpW)) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("key_redpacket_pop", this.fpW);
                }
                this.fpX = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_video_guide_max_count", this.fpX);
                this.fpV = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_concern_tab_tips_switch", this.fpV);
                this.fpY = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.fpZ = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fqa = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.fqb == null) {
                        this.fqb = new ad();
                    }
                    this.fqb.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.fqc = false;
                } else if (optInt == 1) {
                    this.fqc = true;
                }
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("person_center_show_lite_game", this.fqc);
                this.fqd = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("profile_swan_app_key", this.fqd);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.BF(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.pageExtra.f.bDw().Db(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putLong("plugin_wait_time", optLong);
                }
                this.aIW = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_game_frs_live_tab_video_url", this.aIW);
                this.aJd = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_personal_income_detail_url", this.aJd);
                this.fqe = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_personal_privilege_detail_url", this.fqe);
                this.fqf = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_personal_exp_detail_url", this.fqf);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aJk = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("show_live_forum_url", this.aJk);
                    this.fqg = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("show_live_forum_name", this.fqg);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.fqh = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fqi = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_my_live_privilege_mark_detail_url", this.fqh);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_my_live_privilege_effect_detail_url", this.fqi);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.fqj = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt("baidu_financial_display", this.fqj);
                }
                String optString5 = jSONObject.optString("live_bar");
                ff(optString5);
                com.baidu.tbadk.core.sharedPref.b.brx().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                new e().dv(jSONObject);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.brx().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.brx().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void ff(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.brx().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bwu() {
        return this.liveForumMap;
    }

    public String bwv() {
        return this.fpt;
    }

    public String bww() {
        return this.fpn;
    }

    public String bwx() {
        return this.fpo;
    }

    public String bwy() {
        return this.fpp;
    }

    public String bwz() {
        return this.fpq;
    }

    public String bwA() {
        return this.fpr;
    }

    public String bwB() {
        return this.fpC;
    }

    public String bwC() {
        return this.fpD;
    }

    public String bwD() {
        return this.fpE;
    }

    public String bwE() {
        return this.fpu;
    }

    public String bwF() {
        return this.fpv;
    }

    public long bwG() {
        return this.fpw;
    }

    public int bwH() {
        return this.fpx;
    }

    public long bwI() {
        return this.lastUpdateTime;
    }

    public int bwJ() {
        return this.fpK;
    }

    public int bwK() {
        return this.fpL;
    }

    public long bwL() {
        return this.fpz;
    }

    public int bwM() {
        return this.fpA;
    }

    public int bwN() {
        return this.fpy;
    }

    public String bwO() {
        return this.infoIconUrl;
    }

    public String bwP() {
        return this.infoTargetUrl;
    }

    public long bwQ() {
        return this.infoTimeStamp;
    }

    public String bwR() {
        return this.fpH;
    }

    public boolean bwS() {
        return this.fpF == 1;
    }

    public int bwT() {
        return this.fpB;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bwU() {
        return this.fpI;
    }

    public String bwV() {
        return this.fpJ;
    }

    public long bwW() {
        return this.fpM;
    }

    public boolean bwX() {
        return this.fpN;
    }

    public long bwY() {
        return this.fpO;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bwZ() {
        return this.fpR;
    }

    public int bxa() {
        return this.fpS;
    }

    public ab bxb() {
        return this.fpP;
    }

    public int bxc() {
        return this.fpT;
    }

    public long bxd() {
        return this.fpY;
    }

    public long bxe() {
        return this.fpZ;
    }

    public boolean bxf() {
        return this.fqa;
    }

    public ad bxg() {
        return this.fqb;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bxh() {
        return this.fqc;
    }

    public String bxi() {
        return this.fqd;
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
