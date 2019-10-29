package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String RC;
    private String Ro;
    private String Rv;
    private long aDg;
    private b activityPrizeData;
    private String cvH;
    private String cvI;
    private String cvJ;
    private String cvK;
    private String cvL;
    private String cvM;
    private String cvN;
    private String cvO;
    private long cvP;
    private int cvQ;
    private int cvR;
    private long cvS;
    private int cvT;
    private String cvV;
    private String cvW;
    private String cvX;
    public int cvZ;
    private String cwA;
    private String cwB;
    private int cwC;
    private String cwb;
    private String cwc;
    private int cwd;
    private int cwe;
    private int cwf;
    private int cwg;
    private long cwh;
    private long cwi;
    private t cwj;
    private String cwk;
    private String cwo;
    private String cwq;
    private int cwr;
    private long cws;
    private long cwt;
    private v cwv;
    private boolean cww;
    private boolean cwx;
    private String cwy;
    private String cwz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int cvU = 0;
    private int cvY = 2;
    private String cwa = "";
    private int cwl = 0;
    private int cwm = 0;
    private int cwn = 0;
    private int cwp = 0;
    private boolean cwu = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cvH = jSONObject.optString("drop_pic");
                this.cvI = jSONObject.optString("drop_pic_md5");
                this.cvJ = jSONObject.optString("drop_pic_num");
                this.cvK = jSONObject.optString("drop_bg_color_day");
                this.cvL = jSONObject.optString("drop_bg_color_night");
                this.cvM = jSONObject.optString("apply_vip_live_room_pid");
                this.cvV = jSONObject.optString("max_cache");
                this.cvW = jSONObject.optString("frs_max_cache");
                this.cvX = jSONObject.optString("frs_pn");
                this.cvN = jSONObject.optString("tail_link");
                this.cvO = jSONObject.optString("bubble_link");
                this.cvP = jSONObject.optLong("use_duration");
                this.cvQ = jSONObject.optInt("xiaoying_time");
                this.aDg = jSONObject.optLong("last_update_time", 0L);
                this.cwc = jSONObject.optString("url_analyze_text");
                this.cvR = jSONObject.optInt("new_resign", 0);
                this.cvS = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.cvT = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.cvY = jSONObject.optInt("localvideo_open", 2);
                this.cvZ = jSONObject.optInt("card_show_statistic", 200);
                this.cwa = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.awz().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.cvU = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.cwb = jSONObject.optString("nickname_activity_link");
                this.cwd = jSONObject.optInt("android_tab_show", 23);
                this.cwe = jSONObject.optInt("ribao_switch", 0);
                this.cwf = jSONObject.optInt("default_page", 0);
                this.cwg = jSONObject.optInt("remember_page", 0);
                this.cwh = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.cwi = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cwj = new t();
                    this.cwj.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putString("key_game_video", optString6);
                    }
                }
                com.baidu.tieba.im.db.n.ub(jSONObject.optInt("android_max_stranger"));
                this.cwl = jSONObject.optInt("style_ab_switch", 0);
                this.cwm = jSONObject.optInt("abstract_ab_switch", 0);
                this.cwk = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.alR().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.cwk);
                this.cwn = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.cwo = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.cwo)) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("key_baidu_password_re", this.cwo);
                }
                this.cwq = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.cwq)) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("key_redpacket_pop", this.cwq);
                }
                this.cwr = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_video_guide_max_count", this.cwr);
                this.cwp = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_concern_tab_tips_switch", this.cwp);
                this.cws = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.cwt = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.cwu = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString7 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString7)) {
                    if (this.cwv == null) {
                        this.cwv = new v();
                    }
                    this.cwv.parserJson(optString7);
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("shake_data", optString7);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.cww = false;
                } else if (optInt == 1) {
                    this.cww = true;
                }
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("pb_fold_small_flow_json", this.cww);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.cwx = false;
                } else if (optInt2 == 1) {
                    this.cwx = true;
                }
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("person_center_show_lite_game", this.cwx);
                this.cwy = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("profile_swan_app_key", this.cwy);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.Ro = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("ala_game_frs_live_tab_video_url", this.Ro);
                this.Rv = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("ala_personal_income_detail_url", this.Rv);
                String optString8 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString8)) {
                    JSONObject jSONObject2 = new JSONObject(optString8);
                    this.RC = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("show_live_forum_url", this.RC);
                    this.cwz = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("show_live_forum_name", this.cwz);
                }
                String optString9 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject3 = new JSONObject(optString9);
                    this.cwA = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.cwB = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("ala_my_live_privilege_mark_detail_url", this.cwA);
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("ala_my_live_privilege_effect_detail_url", this.cwB);
                }
                String optString10 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString10)) {
                    this.cwC = new JSONObject(optString10).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt("baidu_financial_display", this.cwC);
                }
                String optString11 = jSONObject.optString("live_bar");
                bW(optString11);
                com.baidu.tbadk.core.sharedPref.b.alR().putString("ala_live_bar_map_str", optString11);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.alR().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                q.oM(jSONObject.optString("js_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void bW(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.alR().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> apC() {
        return this.liveForumMap;
    }

    public String apD() {
        return this.cvM;
    }

    public String apE() {
        return this.cvH;
    }

    public String apF() {
        return this.cvI;
    }

    public String apG() {
        return this.cvJ;
    }

    public String apH() {
        return this.cvK;
    }

    public String apI() {
        return this.cvL;
    }

    public String apJ() {
        return this.cvV;
    }

    public String apK() {
        return this.cvW;
    }

    public String apL() {
        return this.cvX;
    }

    public String apM() {
        return this.cvN;
    }

    public String apN() {
        return this.cvO;
    }

    public long apO() {
        return this.cvP;
    }

    public int apP() {
        return this.cvQ;
    }

    public long apQ() {
        return this.aDg;
    }

    public int apR() {
        return this.cwd;
    }

    public int apS() {
        return this.cwe;
    }

    public int apT() {
        return this.cwf;
    }

    public int apU() {
        return this.cwg;
    }

    public long apV() {
        return this.cvS;
    }

    public int apW() {
        return this.cvT;
    }

    public int apX() {
        return this.cvR;
    }

    public String apY() {
        return this.infoIconUrl;
    }

    public String apZ() {
        return this.infoTargetUrl;
    }

    public long aqa() {
        return this.infoTimeStamp;
    }

    public String aqb() {
        return this.cwa;
    }

    public boolean aqc() {
        return this.cvY == 1;
    }

    public int aqd() {
        return this.cvU;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aqe() {
        return this.cwb;
    }

    public String aqf() {
        return this.cwc;
    }

    public long aqg() {
        return this.cwh;
    }

    public long aqh() {
        return this.cwi;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aqi() {
        return this.cwl;
    }

    public int aqj() {
        return this.cwm;
    }

    public t aqk() {
        return this.cwj;
    }

    public int aql() {
        return this.cwn;
    }

    public long aqm() {
        return this.cws;
    }

    public long aqn() {
        return this.cwt;
    }

    public boolean aqo() {
        return this.cwu;
    }

    public v aqp() {
        return this.cwv;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aqq() {
        return this.cww;
    }

    public boolean aqr() {
        return this.cwx;
    }

    public String aqs() {
        return this.cwy;
    }

    public String getSampleId() {
        return this.mSampleId;
    }
}
