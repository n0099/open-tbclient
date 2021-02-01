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
    private String aLG;
    private String aLN;
    private String aLU;
    private b activityPrizeData;
    private String frH;
    private String frI;
    private String frJ;
    private String frK;
    private String frL;
    private String frM;
    private String frN;
    private String frO;
    private long frP;
    private int frQ;
    private int frR;
    private long frS;
    private int frT;
    private String frV;
    private String frW;
    private String frX;
    public int frZ;
    private String fsA;
    private String fsB;
    private int fsC;
    private String fsb;
    private String fsc;
    private int fsd;
    private int fse;
    private long fsf;
    private boolean fsg;
    private long fsh;
    private ab fsi;
    private String fsj;
    private String fsn;
    private String fsp;
    private int fsq;
    private long fsr;
    private long fss;
    private ad fsu;
    private boolean fsv;
    private String fsw;
    private String fsx;
    private String fsy;
    private String fsz;
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
    private int frU = 0;
    private int frY = 2;
    private String fsa = "";
    private int fsk = 0;
    private int fsl = 0;
    private int fsm = 0;
    private int fso = 0;
    private boolean fst = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.frH = jSONObject.optString("drop_pic");
                this.frI = jSONObject.optString("drop_pic_md5");
                this.frJ = jSONObject.optString("drop_pic_num");
                this.frK = jSONObject.optString("drop_bg_color_day");
                this.frL = jSONObject.optString("drop_bg_color_night");
                this.frM = jSONObject.optString("apply_vip_live_room_pid");
                this.frV = jSONObject.optString("max_cache");
                this.frW = jSONObject.optString("frs_max_cache");
                this.frX = jSONObject.optString("frs_pn");
                this.frN = jSONObject.optString("tail_link");
                this.frO = jSONObject.optString("bubble_link");
                this.frP = jSONObject.optLong("use_duration");
                this.frQ = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.fsc = jSONObject.optString("url_analyze_text");
                this.frR = jSONObject.optInt("new_resign", 0);
                this.frS = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.frT = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.frY = jSONObject.optInt("localvideo_open", 2);
                this.frZ = jSONObject.optInt("card_show_statistic", 200);
                this.fsa = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bDS().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.frU = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.fsb = jSONObject.optString("nickname_activity_link");
                this.fsd = jSONObject.optInt("android_tab_show", 55);
                this.fse = jSONObject.optInt("ribao_switch", 0);
                this.fsf = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.fsh = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.fsg = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.fsg);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.fsi = new ab();
                    this.fsi.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.CU(jSONObject.optInt("android_max_stranger"));
                this.fsk = jSONObject.optInt("style_ab_switch", 0);
                this.fsl = jSONObject.optInt("abstract_ab_switch", 0);
                this.fsj = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.fsj);
                this.fsm = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.fsn = jSONObject.optString("shoubai_regex", "");
                if (!au.isEmpty(this.fsn)) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_baidu_password_re", this.fsn);
                }
                this.fsp = jSONObject.optString("redpacket_pop", "");
                if (!au.isEmpty(this.fsp)) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_redpacket_pop", this.fsp);
                }
                this.fsq = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_video_guide_max_count", this.fsq);
                this.fso = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_concern_tab_tips_switch", this.fso);
                this.fsr = jSONObject.optInt("dialog_pull_time", 60) * au.MS_TO_MIN;
                this.fss = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.fst = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.fsu == null) {
                        this.fsu = new ad();
                    }
                    this.fsu.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.fsv = false;
                } else if (optInt == 1) {
                    this.fsv = true;
                }
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("person_center_show_lite_game", this.fsv);
                this.fsw = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("profile_swan_app_key", this.fsw);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                y.BW(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.pageExtra.f.bDO().Ds(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong("plugin_wait_time", optLong);
                }
                this.aLG = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_game_frs_live_tab_video_url", this.aLG);
                this.aLN = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_personal_income_detail_url", this.aLN);
                this.fsx = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_personal_privilege_detail_url", this.fsx);
                this.fsy = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_personal_exp_detail_url", this.fsy);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aLU = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("show_live_forum_url", this.aLU);
                    this.fsz = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("show_live_forum_name", this.fsz);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.fsA = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.fsB = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_my_live_privilege_mark_detail_url", this.fsA);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_my_live_privilege_effect_detail_url", this.fsB);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.fsC = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("baidu_financial_display", this.fsC);
                }
                String optString5 = jSONObject.optString("live_bar");
                fA(optString5);
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                new e().dv(jSONObject);
                ae aeVar = new ae();
                aeVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(aeVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fA(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.brQ().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bwM() {
        return this.liveForumMap;
    }

    public String bwN() {
        return this.frM;
    }

    public String bwO() {
        return this.frH;
    }

    public String bwP() {
        return this.frI;
    }

    public String bwQ() {
        return this.frJ;
    }

    public String bwR() {
        return this.frK;
    }

    public String bwS() {
        return this.frL;
    }

    public String bwT() {
        return this.frV;
    }

    public String bwU() {
        return this.frW;
    }

    public String bwV() {
        return this.frX;
    }

    public String bwW() {
        return this.frN;
    }

    public String bwX() {
        return this.frO;
    }

    public long bwY() {
        return this.frP;
    }

    public int bwZ() {
        return this.frQ;
    }

    public long bxa() {
        return this.lastUpdateTime;
    }

    public int bxb() {
        return this.fsd;
    }

    public int bxc() {
        return this.fse;
    }

    public long bxd() {
        return this.frS;
    }

    public int bxe() {
        return this.frT;
    }

    public int bxf() {
        return this.frR;
    }

    public String bxg() {
        return this.infoIconUrl;
    }

    public String bxh() {
        return this.infoTargetUrl;
    }

    public long bxi() {
        return this.infoTimeStamp;
    }

    public String bxj() {
        return this.fsa;
    }

    public boolean bxk() {
        return this.frY == 1;
    }

    public int bxl() {
        return this.frU;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bxm() {
        return this.fsb;
    }

    public String bxn() {
        return this.fsc;
    }

    public long bxo() {
        return this.fsf;
    }

    public boolean bxp() {
        return this.fsg;
    }

    public long bxq() {
        return this.fsh;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bxr() {
        return this.fsk;
    }

    public int bxs() {
        return this.fsl;
    }

    public ab bxt() {
        return this.fsi;
    }

    public int bxu() {
        return this.fsm;
    }

    public long bxv() {
        return this.fsr;
    }

    public long bxw() {
        return this.fss;
    }

    public boolean bxx() {
        return this.fst;
    }

    public ad bxy() {
        return this.fsu;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bxz() {
        return this.fsv;
    }

    public String bxA() {
        return this.fsw;
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
