package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String aPB;
    private String aPC;
    private int aPD;
    private int aPE;
    private int aPF;
    private int aPG;
    private long aPH;
    private s aPI;
    private String aPJ;
    private String aPN;
    private String aPP;
    private int aPQ;
    private long aPR;
    private long aPS;
    private u aPU;
    private String aPh;
    private String aPi;
    private String aPj;
    private String aPk;
    private String aPl;
    private String aPm;
    private String aPn;
    private String aPo;
    private long aPp;
    private int aPq;
    private int aPr;
    private long aPs;
    private int aPt;
    private String aPv;
    private String aPw;
    private String aPx;
    public int aPz;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aPu = 0;
    private int aPy = 2;
    private String aPA = "";
    private int aPK = 0;
    private int aPL = 0;
    private int aPM = 0;
    private int aPO = 0;
    private boolean aPT = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPh = jSONObject.optString("drop_pic");
                this.aPi = jSONObject.optString("drop_pic_md5");
                this.aPj = jSONObject.optString("drop_pic_num");
                this.aPk = jSONObject.optString("drop_bg_color_day");
                this.aPl = jSONObject.optString("drop_bg_color_night");
                this.aPm = jSONObject.optString("apply_vip_live_room_pid");
                this.aPv = jSONObject.optString("max_cache");
                this.aPw = jSONObject.optString("frs_max_cache");
                this.aPx = jSONObject.optString("frs_pn");
                this.aPn = jSONObject.optString("tail_link");
                this.aPo = jSONObject.optString("bubble_link");
                this.aPp = jSONObject.optLong("use_duration");
                this.aPq = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aPC = jSONObject.optString("url_analyze_text");
                this.aPr = jSONObject.optInt("new_resign", 0);
                this.aPs = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aPt = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aPy = jSONObject.optInt("localvideo_open", 2);
                this.aPz = jSONObject.optInt("card_show_statistic", 200);
                this.aPA = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Pk().gi(jSONObject.optInt("statlog_path_max", 3));
                this.aPu = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aPB = jSONObject.optString("nickname_activity_link");
                this.aPD = jSONObject.optInt("android_tab_show", 7);
                this.aPE = jSONObject.optInt("ribao_switch", 0);
                this.aPF = jSONObject.optInt("default_page", 0);
                this.aPG = jSONObject.optInt("remember_page", 0);
                this.aPH = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aPI = new s();
                    this.aPI.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString(ImageViewerConfig.FROM_CONCERN, "");
                    if (!StringUtils.isNull(optString)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_concern", optString);
                    }
                    String optString2 = optJSONObject3.optString("index", "");
                    if (!StringUtils.isNull(optString2)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_rec", optString2);
                    }
                    String optString3 = optJSONObject3.optString("video", "");
                    if (!StringUtils.isNull(optString3)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video", optString3);
                    }
                    String optString4 = optJSONObject3.optString("daily", "");
                    if (!StringUtils.isNull(optString4)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_daily", optString4);
                    }
                }
                com.baidu.tieba.im.db.n.qc(jSONObject.optInt("android_max_stranger"));
                this.aPK = jSONObject.optInt("style_ab_switch", 0);
                this.aPL = jSONObject.optInt("abstract_ab_switch", 0);
                this.aPJ = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aPJ);
                this.aPM = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aPN = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aPN)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aPN);
                }
                this.aPP = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aPP)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aPP);
                }
                this.aPQ = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aPQ);
                this.aPO = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aPO);
                this.aPR = jSONObject.optInt("dialog_pull_time", 60) * ao.aCQ;
                this.aPS = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aPT = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString5 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString5)) {
                    if (this.aPU == null) {
                        this.aPU = new u();
                    }
                    this.aPU.parserJson(optString5);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Ht() {
        return this.aPm;
    }

    public String Hu() {
        return this.aPh;
    }

    public String Hv() {
        return this.aPi;
    }

    public String Hw() {
        return this.aPj;
    }

    public String Hx() {
        return this.aPk;
    }

    public String Hy() {
        return this.aPl;
    }

    public String Hz() {
        return this.aPv;
    }

    public String HA() {
        return this.aPw;
    }

    public String HB() {
        return this.aPx;
    }

    public String HC() {
        return this.aPn;
    }

    public String HD() {
        return this.aPo;
    }

    public long HE() {
        return this.aPp;
    }

    public int HF() {
        return this.aPq;
    }

    public long HG() {
        return this.lastUpdateTime;
    }

    public int HH() {
        return this.aPD;
    }

    public int HI() {
        return this.aPE;
    }

    public int HJ() {
        return this.aPF;
    }

    public int HK() {
        return this.aPG;
    }

    public long HL() {
        return this.aPs;
    }

    public int HM() {
        return this.aPt;
    }

    public int HN() {
        return this.aPr;
    }

    public String HO() {
        return this.infoIconUrl;
    }

    public String HP() {
        return this.infoTargetUrl;
    }

    public long HQ() {
        return this.infoTimeStamp;
    }

    public String HR() {
        return this.aPA;
    }

    public boolean HS() {
        return this.aPy == 1;
    }

    public int HT() {
        return this.aPu;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String HU() {
        return this.aPB;
    }

    public String HV() {
        return this.aPC;
    }

    public long HW() {
        return this.aPH;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int HX() {
        return this.aPK;
    }

    public int HY() {
        return this.aPL;
    }

    public s HZ() {
        return this.aPI;
    }

    public int Ia() {
        return this.aPM;
    }

    public long Ib() {
        return this.aPR;
    }

    public long Ic() {
        return this.aPS;
    }

    public boolean Id() {
        return this.aPT;
    }

    public u Ie() {
        return this.aPU;
    }
}
