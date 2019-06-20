package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String cfF;
    private String cfG;
    private String cfH;
    private String cfI;
    private String cfJ;
    private String cfK;
    private String cfL;
    private String cfM;
    private long cfN;
    private int cfO;
    private int cfP;
    private long cfQ;
    private int cfR;
    private String cfT;
    private String cfU;
    private String cfV;
    public int cfX;
    private String cfZ;
    private String cga;
    private int cgb;
    private int cgc;
    private int cgd;
    private int cge;
    private long cgf;
    private long cgg;
    private s cgh;
    private String cgi;
    private String cgm;
    private String cgo;
    private int cgp;
    private long cgq;
    private long cgr;
    private u cgt;
    private boolean cgu;
    private boolean cgv;
    private String cgw;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int cfS = 0;
    private int cfW = 2;
    private String cfY = "";
    private int cgj = 0;
    private int cgk = 0;
    private int cgl = 0;
    private int cgn = 0;
    private boolean cgs = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cfF = jSONObject.optString("drop_pic");
                this.cfG = jSONObject.optString("drop_pic_md5");
                this.cfH = jSONObject.optString("drop_pic_num");
                this.cfI = jSONObject.optString("drop_bg_color_day");
                this.cfJ = jSONObject.optString("drop_bg_color_night");
                this.cfK = jSONObject.optString("apply_vip_live_room_pid");
                this.cfT = jSONObject.optString("max_cache");
                this.cfU = jSONObject.optString("frs_max_cache");
                this.cfV = jSONObject.optString("frs_pn");
                this.cfL = jSONObject.optString("tail_link");
                this.cfM = jSONObject.optString("bubble_link");
                this.cfN = jSONObject.optLong("use_duration");
                this.cfO = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.cga = jSONObject.optString("url_analyze_text");
                this.cfP = jSONObject.optInt("new_resign", 0);
                this.cfQ = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.cfR = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.cfW = jSONObject.optInt("localvideo_open", 2);
                this.cfX = jSONObject.optInt("card_show_statistic", 200);
                this.cfY = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.o.e.atQ().kJ(jSONObject.optInt("statlog_path_max", 3));
                this.cfS = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.cfZ = jSONObject.optString("nickname_activity_link");
                this.cgb = jSONObject.optInt("android_tab_show", 23);
                this.cgc = jSONObject.optInt("ribao_switch", 0);
                this.cgd = jSONObject.optInt("default_page", 0);
                this.cge = jSONObject.optInt("remember_page", 0);
                this.cgf = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.cgg = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.cgh = new s();
                    this.cgh.parse(optJSONObject2);
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
                this.cgj = jSONObject.optInt("style_ab_switch", 0);
                this.cgk = jSONObject.optInt("abstract_ab_switch", 0);
                this.cgi = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.agM().putString("key_video_splash_config", this.cgi);
                this.cgl = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.cgm = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.cgm)) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("key_baidu_password_re", this.cgm);
                }
                this.cgo = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.cgo)) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("key_redpacket_pop", this.cgo);
                }
                this.cgp = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_guide_max_count", this.cgp);
                this.cgn = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_concern_tab_tips_switch", this.cgn);
                this.cgq = jSONObject.optInt("dialog_pull_time", 60) * ap.bSz;
                this.cgr = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.cgs = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.cgt == null) {
                        this.cgt = new u();
                    }
                    this.cgt.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.cgu = false;
                } else if (optInt == 1) {
                    this.cgu = true;
                }
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("pb_fold_small_flow_json", this.cgu);
                int optInt2 = jSONObject.optInt("audit_package_switch", 1);
                if (optInt2 == 0) {
                    this.cgv = false;
                } else if (optInt2 == 1) {
                    this.cgv = true;
                }
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("person_center_show_lite_game", this.cgv);
                this.cgw = jSONObject.optString("profile_swan_app_key");
                com.baidu.tbadk.core.sharedPref.b.agM().putString("profile_swan_app_key", this.cgw);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String alI() {
        return this.cfK;
    }

    public String alJ() {
        return this.cfF;
    }

    public String alK() {
        return this.cfG;
    }

    public String alL() {
        return this.cfH;
    }

    public String alM() {
        return this.cfI;
    }

    public String alN() {
        return this.cfJ;
    }

    public String alO() {
        return this.cfT;
    }

    public String alP() {
        return this.cfU;
    }

    public String alQ() {
        return this.cfV;
    }

    public String alR() {
        return this.cfL;
    }

    public String alS() {
        return this.cfM;
    }

    public long alT() {
        return this.cfN;
    }

    public int alU() {
        return this.cfO;
    }

    public long alV() {
        return this.lastUpdateTime;
    }

    public int alW() {
        return this.cgb;
    }

    public int alX() {
        return this.cgc;
    }

    public int alY() {
        return this.cgd;
    }

    public int alZ() {
        return this.cge;
    }

    public long ama() {
        return this.cfQ;
    }

    public int amb() {
        return this.cfR;
    }

    public int amc() {
        return this.cfP;
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
        return this.cfY;
    }

    public boolean amh() {
        return this.cfW == 1;
    }

    public int ami() {
        return this.cfS;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String amj() {
        return this.cfZ;
    }

    public String amk() {
        return this.cga;
    }

    public long aml() {
        return this.cgf;
    }

    public long amm() {
        return this.cgg;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int amn() {
        return this.cgj;
    }

    public int amo() {
        return this.cgk;
    }

    public s amp() {
        return this.cgh;
    }

    public int amq() {
        return this.cgl;
    }

    public long amr() {
        return this.cgq;
    }

    public long ams() {
        return this.cgr;
    }

    public boolean amt() {
        return this.cgs;
    }

    public u amu() {
        return this.cgt;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean amv() {
        return this.cgu;
    }

    public boolean amw() {
        return this.cgv;
    }

    public String amx() {
        return this.cgw;
    }
}
