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
public class ai {
    private String aGa;
    private String aGh;
    private String aGo;
    private b activityPrizeData;
    private long bPH;
    public int eBB;
    private String eBD;
    private String eBE;
    private int eBF;
    private int eBG;
    private long eBH;
    private boolean eBI;
    private long eBJ;
    private aa eBK;
    private String eBL;
    private String eBP;
    private String eBR;
    private int eBS;
    private long eBT;
    private long eBU;
    private ac eBW;
    private boolean eBX;
    private String eBY;
    private String eBZ;
    private String eBj;
    private String eBk;
    private String eBl;
    private String eBm;
    private String eBn;
    private String eBo;
    private String eBp;
    private String eBq;
    private long eBr;
    private int eBs;
    private int eBt;
    private long eBu;
    private int eBv;
    private String eBx;
    private String eBy;
    private String eBz;
    private String eCa;
    private String eCb;
    private String eCc;
    private int eCd;
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
    private int eBw = 0;
    private int eBA = 2;
    private String eBC = "";
    private int eBM = 0;
    private int eBN = 0;
    private int eBO = 0;
    private int eBQ = 0;
    private boolean eBV = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBj = jSONObject.optString("drop_pic");
                this.eBk = jSONObject.optString("drop_pic_md5");
                this.eBl = jSONObject.optString("drop_pic_num");
                this.eBm = jSONObject.optString("drop_bg_color_day");
                this.eBn = jSONObject.optString("drop_bg_color_night");
                this.eBo = jSONObject.optString("apply_vip_live_room_pid");
                this.eBx = jSONObject.optString("max_cache");
                this.eBy = jSONObject.optString("frs_max_cache");
                this.eBz = jSONObject.optString("frs_pn");
                this.eBp = jSONObject.optString("tail_link");
                this.eBq = jSONObject.optString("bubble_link");
                this.eBr = jSONObject.optLong("use_duration");
                this.eBs = jSONObject.optInt("xiaoying_time");
                this.bPH = jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
                this.eBE = jSONObject.optString("url_analyze_text");
                this.eBt = jSONObject.optInt("new_resign", 0);
                this.eBu = jSONObject.optLong("personalized_cache_seconds", 1800L);
                this.eBv = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.eBA = jSONObject.optInt("localvideo_open", 2);
                this.eBB = jSONObject.optInt("card_show_statistic", 200);
                this.eBC = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.m.e.bua().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.eBw = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.eBD = jSONObject.optString("nickname_activity_link");
                this.eBF = jSONObject.optInt("android_tab_show", 55);
                this.eBG = jSONObject.optInt("ribao_switch", 0);
                this.eBH = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.eBJ = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                this.eBI = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.eBI);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.eBK = new aa();
                    this.eBK.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.AZ(jSONObject.optInt("android_max_stranger"));
                this.eBM = jSONObject.optInt("style_ab_switch", 0);
                this.eBN = jSONObject.optInt("abstract_ab_switch", 0);
                this.eBL = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.bik().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.eBL);
                this.eBO = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.eBP = jSONObject.optString("shoubai_regex", "");
                if (!at.isEmpty(this.eBP)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("key_baidu_password_re", this.eBP);
                }
                this.eBR = jSONObject.optString("redpacket_pop", "");
                if (!at.isEmpty(this.eBR)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("key_redpacket_pop", this.eBR);
                }
                this.eBS = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_video_guide_max_count", this.eBS);
                this.eBQ = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_concern_tab_tips_switch", this.eBQ);
                this.eBT = jSONObject.optInt("dialog_pull_time", 60) * at.MS_TO_MIN;
                this.eBU = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.eBV = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString)) {
                    if (this.eBW == null) {
                        this.eBW = new ac();
                    }
                    this.eBW.parserJson(optString);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("shake_data", optString);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("audit_package_switch", 1);
                if (optInt == 0) {
                    this.eBX = false;
                } else if (optInt == 1) {
                    this.eBX = true;
                }
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("person_center_show_lite_game", this.eBX);
                this.eBY = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("profile_swan_app_key", this.eBY);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mMissionEntranceObjSource = jSONObject.optString("obj_source");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("index_activity_abtest_obj_source", this.mMissionEntranceObjSource);
                this.mWalletSignLink = jSONObject.optString("duxiaoman_sign_link");
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                x.AX(jSONObject.optString("js_whitelist"));
                com.baidu.tbadk.l.e.btW().Cr(jSONObject.optString("stat_keys_list"));
                long optLong = jSONObject.optLong("android_plugin_wait_time", 0L);
                if (optLong > 0) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong("plugin_wait_time", optLong);
                }
                this.aGa = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_game_frs_live_tab_video_url", this.aGa);
                this.aGh = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_personal_income_detail_url", this.aGh);
                this.eBZ = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_personal_privilege_detail_url", this.eBZ);
                String optString2 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString2)) {
                    JSONObject jSONObject2 = new JSONObject(optString2);
                    this.aGo = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("show_live_forum_url", this.aGo);
                    this.eCa = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("show_live_forum_name", this.eCa);
                }
                String optString3 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString3)) {
                    JSONObject jSONObject3 = new JSONObject(optString3);
                    this.eCb = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.eCc = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_my_live_privilege_mark_detail_url", this.eCb);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_my_live_privilege_effect_detail_url", this.eCc);
                }
                String optString4 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString4)) {
                    this.eCd = new JSONObject(optString4).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("baidu_financial_display", this.eCd);
                }
                String optString5 = jSONObject.optString("live_bar");
                fT(optString5);
                com.baidu.tbadk.core.sharedPref.b.bik().putString("ala_live_bar_map_str", optString5);
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_home_refresh_button_test", jSONObject.optInt("homepage_refresh_test"));
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("chushou_game_tab", jSONObject.optInt("chushou_game_tab_new"));
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
                ad adVar = new ad();
                adVar.parseJson(jSONObject.optJSONObject("share_panel_conf"));
                TbSingleton.getInstance().setSharePanelConfData(adVar);
                String optString6 = jSONObject.optString("BackMechanism_sid1");
                String optString7 = jSONObject.optString("BackMechanism_sid2");
                com.baidu.tbadk.core.sharedPref.b.bik().putString("key_pb_back_sid1", optString6);
                com.baidu.tbadk.core.sharedPref.b.bik().putString("key_pb_back_sid2", optString7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void fT(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.bik().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> bng() {
        return this.liveForumMap;
    }

    public String bnh() {
        return this.eBo;
    }

    public String bni() {
        return this.eBj;
    }

    public String bnj() {
        return this.eBk;
    }

    public String bnk() {
        return this.eBl;
    }

    public String bnl() {
        return this.eBm;
    }

    public String bnm() {
        return this.eBn;
    }

    public String bnn() {
        return this.eBx;
    }

    public String bno() {
        return this.eBy;
    }

    public String bnp() {
        return this.eBz;
    }

    public String bnq() {
        return this.eBp;
    }

    public String bnr() {
        return this.eBq;
    }

    public long bns() {
        return this.eBr;
    }

    public int bnt() {
        return this.eBs;
    }

    public long bnu() {
        return this.bPH;
    }

    public int bnv() {
        return this.eBF;
    }

    public int bnw() {
        return this.eBG;
    }

    public long bnx() {
        return this.eBu;
    }

    public int bny() {
        return this.eBv;
    }

    public int bnz() {
        return this.eBt;
    }

    public String bnA() {
        return this.infoIconUrl;
    }

    public String bnB() {
        return this.infoTargetUrl;
    }

    public long bnC() {
        return this.infoTimeStamp;
    }

    public String bnD() {
        return this.eBC;
    }

    public boolean bnE() {
        return this.eBA == 1;
    }

    public int bnF() {
        return this.eBw;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String bnG() {
        return this.eBD;
    }

    public String bnH() {
        return this.eBE;
    }

    public long bnI() {
        return this.eBH;
    }

    public boolean bnJ() {
        return this.eBI;
    }

    public long bnK() {
        return this.eBJ;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int bnL() {
        return this.eBM;
    }

    public int bnM() {
        return this.eBN;
    }

    public aa bnN() {
        return this.eBK;
    }

    public int bnO() {
        return this.eBO;
    }

    public long bnP() {
        return this.eBT;
    }

    public long bnQ() {
        return this.eBU;
    }

    public boolean bnR() {
        return this.eBV;
    }

    public ac bnS() {
        return this.eBW;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean bnT() {
        return this.eBX;
    }

    public String bnU() {
        return this.eBY;
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
