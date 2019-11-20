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
    private String QN;
    private String QV;
    private String Rc;
    private long aCO;
    private b activityPrizeData;
    private String cuQ;
    private String cuR;
    private String cuS;
    private String cuT;
    private String cuU;
    private String cuV;
    private String cuW;
    private String cuX;
    private long cuY;
    private int cuZ;
    private int cvA;
    private long cvB;
    private long cvC;
    private v cvE;
    private boolean cvF;
    private boolean cvG;
    private String cvH;
    private String cvI;
    private String cvJ;
    private String cvK;
    private int cvL;
    private int cva;
    private long cvb;
    private int cvc;
    private String cve;
    private String cvf;
    private String cvg;
    public int cvi;
    private String cvk;
    private String cvl;
    private int cvm;
    private int cvn;
    private int cvo;
    private int cvp;
    private long cvq;
    private long cvr;
    private t cvs;
    private String cvt;
    private String cvx;
    private String cvz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private int mHomePageStyleAbTest;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mSampleId;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int cvd = 0;
    private int cvh = 2;
    private String cvj = "";
    private int cvu = 0;
    private int cvv = 0;
    private int cvw = 0;
    private int cvy = 0;
    private boolean cvD = false;
    private HashMap<Long, String> liveForumMap = new HashMap<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cuQ = jSONObject.optString("drop_pic");
                this.cuR = jSONObject.optString("drop_pic_md5");
                this.cuS = jSONObject.optString("drop_pic_num");
                this.cuT = jSONObject.optString("drop_bg_color_day");
                this.cuU = jSONObject.optString("drop_bg_color_night");
                this.cuV = jSONObject.optString("apply_vip_live_room_pid");
                this.cve = jSONObject.optString("max_cache");
                this.cvf = jSONObject.optString("frs_max_cache");
                this.cvg = jSONObject.optString("frs_pn");
                this.cuW = jSONObject.optString("tail_link");
                this.cuX = jSONObject.optString("bubble_link");
                this.cuY = jSONObject.optLong("use_duration");
                this.cuZ = jSONObject.optInt("xiaoying_time");
                this.aCO = jSONObject.optLong("last_update_time", 0L);
                this.cvl = jSONObject.optString("url_analyze_text");
                this.cva = jSONObject.optInt("new_resign", 0);
                this.cvb = jSONObject.optLong("personalized_cache_seconds", 3600L);
                this.cvc = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.cvh = jSONObject.optInt("localvideo_open", 2);
                this.cvi = jSONObject.optInt("card_show_statistic", 200);
                this.cvj = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.awx().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
                this.cvd = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.cvk = jSONObject.optString("nickname_activity_link");
                this.cvm = jSONObject.optInt("android_tab_show", 23);
                this.cvn = jSONObject.optInt("ribao_switch", 0);
                this.cvo = jSONObject.optInt("default_page", 0);
                this.cvp = jSONObject.optInt("remember_page", 0);
                this.cvq = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.cvr = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.ACTIVITY_PRIZE_DATA + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cvs = new t();
                    this.cvs.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_live", optString5);
                    }
                    String optString6 = optJSONObject3.optString(ImageViewerConfig.FROM_GAME_VIDEO, "");
                    if (!StringUtils.isNull(optString6)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putString("key_game_video", optString6);
                    }
                }
                com.baidu.tieba.im.db.n.ua(jSONObject.optInt("android_max_stranger"));
                this.cvu = jSONObject.optInt("style_ab_switch", 0);
                this.cvv = jSONObject.optInt("abstract_ab_switch", 0);
                this.cvt = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.alP().putString(SharedPrefConfig.KEY_VIDEO_SPLASH_CONFIG, this.cvt);
                this.cvw = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.cvx = jSONObject.optString("shoubai_regex", "");
                if (!aq.isEmpty(this.cvx)) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("key_baidu_password_re", this.cvx);
                }
                this.cvz = jSONObject.optString("redpacket_pop", "");
                if (!aq.isEmpty(this.cvz)) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("key_redpacket_pop", this.cvz);
                }
                this.cvA = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_video_guide_max_count", this.cvA);
                this.cvy = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_concern_tab_tips_switch", this.cvy);
                this.cvB = jSONObject.optInt("dialog_pull_time", 60) * aq.MS_TO_MIN;
                this.cvC = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.cvD = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString7 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString7)) {
                    if (this.cvE == null) {
                        this.cvE = new v();
                    }
                    this.cvE.parserJson(optString7);
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("shake_data", optString7);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.cvF = false;
                } else if (optInt == 1) {
                    this.cvF = true;
                }
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("pb_fold_small_flow_json", this.cvF);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.cvG = false;
                } else if (optInt2 == 1) {
                    this.cvG = true;
                }
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("person_center_show_lite_game", this.cvG);
                this.cvH = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("profile_swan_app_key", this.cvH);
                this.mMissionEntranceUrl = jSONObject.optString("android_mission_system_entrance_url");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("index_activity_abtest_url", this.mMissionEntranceUrl);
                this.mMissionEntranceIcon = jSONObject.optString("android_mission_system_entrance_icon");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("index_activity_abtest_icon_url", this.mMissionEntranceIcon);
                this.mHomePageStyleAbTest = jSONObject.optInt("home_page_style_ab_test", 0);
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("index_activity_abtest_switch_json", this.mHomePageStyleAbTest);
                this.QN = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("ala_game_frs_live_tab_video_url", this.QN);
                this.QV = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("ala_personal_income_detail_url", this.QV);
                String optString8 = jSONObject.optString("showlive_forum");
                if (!StringUtils.isNull(optString8)) {
                    JSONObject jSONObject2 = new JSONObject(optString8);
                    this.Rc = jSONObject2.optString("go_url", "http://tieba.baidu.com/f?kw=百度直播");
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("show_live_forum_url", this.Rc);
                    this.cvI = jSONObject2.optString("forum_name", "百度直播");
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("show_live_forum_name", this.cvI);
                }
                String optString9 = jSONObject.optString("user_live_mark_page");
                if (!StringUtils.isNull(optString9)) {
                    JSONObject jSONObject3 = new JSONObject(optString9);
                    this.cvJ = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.cvK = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("ala_my_live_privilege_mark_detail_url", this.cvJ);
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("ala_my_live_privilege_effect_detail_url", this.cvK);
                }
                String optString10 = jSONObject.optString("credit_conf");
                if (!StringUtils.isNull(optString10)) {
                    this.cvL = new JSONObject(optString10).optInt("ucenter_display");
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt("baidu_financial_display", this.cvL);
                }
                String optString11 = jSONObject.optString("live_bar");
                bW(optString11);
                com.baidu.tbadk.core.sharedPref.b.alP().putString("ala_live_bar_map_str", optString11);
                this.mSampleId = jSONObject.optString("sample_id");
                com.baidu.tbadk.core.sharedPref.b.alP().putString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), this.mSampleId);
                q.oM(jSONObject.optString("js_whitelist"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void bW(String str) {
        if (StringUtils.isNull(str)) {
            str = com.baidu.tbadk.core.sharedPref.b.alP().getString("ala_live_bar_map_str", "");
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

    public HashMap<Long, String> apA() {
        return this.liveForumMap;
    }

    public String apB() {
        return this.cuV;
    }

    public String apC() {
        return this.cuQ;
    }

    public String apD() {
        return this.cuR;
    }

    public String apE() {
        return this.cuS;
    }

    public String apF() {
        return this.cuT;
    }

    public String apG() {
        return this.cuU;
    }

    public String apH() {
        return this.cve;
    }

    public String apI() {
        return this.cvf;
    }

    public String apJ() {
        return this.cvg;
    }

    public String apK() {
        return this.cuW;
    }

    public String apL() {
        return this.cuX;
    }

    public long apM() {
        return this.cuY;
    }

    public int apN() {
        return this.cuZ;
    }

    public long apO() {
        return this.aCO;
    }

    public int apP() {
        return this.cvm;
    }

    public int apQ() {
        return this.cvn;
    }

    public int apR() {
        return this.cvo;
    }

    public int apS() {
        return this.cvp;
    }

    public long apT() {
        return this.cvb;
    }

    public int apU() {
        return this.cvc;
    }

    public int apV() {
        return this.cva;
    }

    public String apW() {
        return this.infoIconUrl;
    }

    public String apX() {
        return this.infoTargetUrl;
    }

    public long apY() {
        return this.infoTimeStamp;
    }

    public String apZ() {
        return this.cvj;
    }

    public boolean aqa() {
        return this.cvh == 1;
    }

    public int aqb() {
        return this.cvd;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String aqc() {
        return this.cvk;
    }

    public String aqd() {
        return this.cvl;
    }

    public long aqe() {
        return this.cvq;
    }

    public long aqf() {
        return this.cvr;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aqg() {
        return this.cvu;
    }

    public int aqh() {
        return this.cvv;
    }

    public t aqi() {
        return this.cvs;
    }

    public int aqj() {
        return this.cvw;
    }

    public long aqk() {
        return this.cvB;
    }

    public long aql() {
        return this.cvC;
    }

    public boolean aqm() {
        return this.cvD;
    }

    public v aqn() {
        return this.cvE;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean aqo() {
        return this.cvF;
    }

    public boolean aqp() {
        return this.cvG;
    }

    public String aqq() {
        return this.cvH;
    }

    public String getSampleId() {
        return this.mSampleId;
    }
}
