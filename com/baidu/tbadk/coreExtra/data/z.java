package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String cfE;
    private String cfF;
    private String cfG;
    private String cfH;
    private String cfI;
    private String cfJ;
    private String cfK;
    private String cfL;
    private long cfM;
    private int cfN;
    private int cfO;
    private long cfP;
    private int cfQ;
    private String cfS;
    private String cfT;
    private String cfU;
    public int cfW;
    private String cfY;
    private String cfZ;
    private int cga;
    private int cgb;
    private int cgc;
    private int cgd;
    private long cge;
    private long cgf;
    private s cgg;
    private String cgh;
    private String cgl;
    private String cgn;
    private int cgo;
    private long cgp;
    private long cgq;
    private u cgs;
    private boolean cgt;
    private boolean cgu;
    private String cgv;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int cfR = 0;
    private int cfV = 2;
    private String cfX = "";
    private int cgi = 0;
    private int cgj = 0;
    private int cgk = 0;
    private int cgm = 0;
    private boolean cgr = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cfE = jSONObject.optString("drop_pic");
                this.cfF = jSONObject.optString("drop_pic_md5");
                this.cfG = jSONObject.optString("drop_pic_num");
                this.cfH = jSONObject.optString("drop_bg_color_day");
                this.cfI = jSONObject.optString("drop_bg_color_night");
                this.cfJ = jSONObject.optString("apply_vip_live_room_pid");
                this.cfS = jSONObject.optString("max_cache");
                this.cfT = jSONObject.optString("frs_max_cache");
                this.cfU = jSONObject.optString("frs_pn");
                this.cfK = jSONObject.optString("tail_link");
                this.cfL = jSONObject.optString("bubble_link");
                this.cfM = jSONObject.optLong("use_duration");
                this.cfN = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.cfZ = jSONObject.optString("url_analyze_text");
                this.cfO = jSONObject.optInt("new_resign", 0);
                this.cfP = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.cfQ = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.cfV = jSONObject.optInt("localvideo_open", 2);
                this.cfW = jSONObject.optInt("card_show_statistic", 200);
                this.cfX = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.atQ().kJ(jSONObject.optInt("statlog_path_max", 3));
                this.cfR = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.cfY = jSONObject.optString("nickname_activity_link");
                this.cga = jSONObject.optInt("android_tab_show", 23);
                this.cgb = jSONObject.optInt("ribao_switch", 0);
                this.cgc = jSONObject.optInt("default_page", 0);
                this.cgd = jSONObject.optInt("remember_page", 0);
                this.cge = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.cgf = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cgg = new s();
                    this.cgg.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("key_daily", optString4);
                    }
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putString("key_live", optString5);
                    }
                }
                com.baidu.tieba.im.db.n.uP(jSONObject.optInt("android_max_stranger"));
                this.cgi = jSONObject.optInt("style_ab_switch", 0);
                this.cgj = jSONObject.optInt("abstract_ab_switch", 0);
                this.cgh = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_config", this.cgh);
                this.cgk = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.cgl = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.cgl)) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("key_baidu_password_re", this.cgl);
                }
                this.cgn = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.cgn)) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("key_redpacket_pop", this.cgn);
                }
                this.cgo = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_guide_max_count", this.cgo);
                this.cgm = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_concern_tab_tips_switch", this.cgm);
                this.cgp = jSONObject.optInt("dialog_pull_time", 60) * ap.bSy;
                this.cgq = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.cgr = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.cgs == null) {
                        this.cgs = new u();
                    }
                    this.cgs.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.cgt = false;
                } else if (optInt == 1) {
                    this.cgt = true;
                }
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("pb_fold_small_flow_json", this.cgt);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.cgu = false;
                } else if (optInt2 == 1) {
                    this.cgu = true;
                }
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("person_center_show_lite_game", this.cgu);
                this.cgv = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.agM().putString("profile_swan_app_key", this.cgv);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String alI() {
        return this.cfJ;
    }

    public String alJ() {
        return this.cfE;
    }

    public String alK() {
        return this.cfF;
    }

    public String alL() {
        return this.cfG;
    }

    public String alM() {
        return this.cfH;
    }

    public String alN() {
        return this.cfI;
    }

    public String alO() {
        return this.cfS;
    }

    public String alP() {
        return this.cfT;
    }

    public String alQ() {
        return this.cfU;
    }

    public String alR() {
        return this.cfK;
    }

    public String alS() {
        return this.cfL;
    }

    public long alT() {
        return this.cfM;
    }

    public int alU() {
        return this.cfN;
    }

    public long alV() {
        return this.lastUpdateTime;
    }

    public int alW() {
        return this.cga;
    }

    public int alX() {
        return this.cgb;
    }

    public int alY() {
        return this.cgc;
    }

    public int alZ() {
        return this.cgd;
    }

    public long ama() {
        return this.cfP;
    }

    public int amb() {
        return this.cfQ;
    }

    public int amc() {
        return this.cfO;
    }

    public String amd() {
        return this.infoIconUrl;
    }

    public String ame() {
        return this.infoTargetUrl;
    }

    public long amf() {
        return this.infoTimeStamp;
    }

    public String amg() {
        return this.cfX;
    }

    public boolean amh() {
        return this.cfV == 1;
    }

    public int ami() {
        return this.cfR;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String amj() {
        return this.cfY;
    }

    public String amk() {
        return this.cfZ;
    }

    public long aml() {
        return this.cge;
    }

    public long amm() {
        return this.cgf;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int amn() {
        return this.cgi;
    }

    public int amo() {
        return this.cgj;
    }

    public s amp() {
        return this.cgg;
    }

    public int amq() {
        return this.cgk;
    }

    public long amr() {
        return this.cgp;
    }

    public long ams() {
        return this.cgq;
    }

    public boolean amt() {
        return this.cgr;
    }

    public u amu() {
        return this.cgs;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean amv() {
        return this.cgt;
    }

    public boolean amw() {
        return this.cgu;
    }

    public String amx() {
        return this.cgv;
    }
}
