package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String aPA;
    private String aPB;
    private int aPC;
    private int aPD;
    private int aPE;
    private int aPF;
    private long aPG;
    private s aPH;
    private String aPI;
    private String aPM;
    private String aPO;
    private int aPP;
    private long aPQ;
    private long aPR;
    private u aPT;
    private String aPg;
    private String aPh;
    private String aPi;
    private String aPj;
    private String aPk;
    private String aPl;
    private String aPm;
    private String aPn;
    private long aPo;
    private int aPp;
    private int aPq;
    private long aPr;
    private int aPs;
    private String aPu;
    private String aPv;
    private String aPw;
    public int aPy;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aPt = 0;
    private int aPx = 2;
    private String aPz = "";
    private int aPJ = 0;
    private int aPK = 0;
    private int aPL = 0;
    private int aPN = 0;
    private boolean aPS = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPg = jSONObject.optString("drop_pic");
                this.aPh = jSONObject.optString("drop_pic_md5");
                this.aPi = jSONObject.optString("drop_pic_num");
                this.aPj = jSONObject.optString("drop_bg_color_day");
                this.aPk = jSONObject.optString("drop_bg_color_night");
                this.aPl = jSONObject.optString("apply_vip_live_room_pid");
                this.aPu = jSONObject.optString("max_cache");
                this.aPv = jSONObject.optString("frs_max_cache");
                this.aPw = jSONObject.optString("frs_pn");
                this.aPm = jSONObject.optString("tail_link");
                this.aPn = jSONObject.optString("bubble_link");
                this.aPo = jSONObject.optLong("use_duration");
                this.aPp = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aPB = jSONObject.optString("url_analyze_text");
                this.aPq = jSONObject.optInt("new_resign", 0);
                this.aPr = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aPs = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aPx = jSONObject.optInt("localvideo_open", 2);
                this.aPy = jSONObject.optInt("card_show_statistic", 200);
                this.aPz = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Pk().gi(jSONObject.optInt("statlog_path_max", 3));
                this.aPt = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aPA = jSONObject.optString("nickname_activity_link");
                this.aPC = jSONObject.optInt("android_tab_show", 7);
                this.aPD = jSONObject.optInt("ribao_switch", 0);
                this.aPE = jSONObject.optInt("default_page", 0);
                this.aPF = jSONObject.optInt("remember_page", 0);
                this.aPG = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aPH = new s();
                    this.aPH.parse(optJSONObject2);
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
                this.aPJ = jSONObject.optInt("style_ab_switch", 0);
                this.aPK = jSONObject.optInt("abstract_ab_switch", 0);
                this.aPI = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aPI);
                this.aPL = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aPM = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aPM)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aPM);
                }
                this.aPO = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aPO)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aPO);
                }
                this.aPP = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aPP);
                this.aPN = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aPN);
                this.aPQ = jSONObject.optInt("dialog_pull_time", 60) * ao.aCP;
                this.aPR = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aPS = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString5 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString5)) {
                    if (this.aPT == null) {
                        this.aPT = new u();
                    }
                    this.aPT.parserJson(optString5);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Ht() {
        return this.aPl;
    }

    public String Hu() {
        return this.aPg;
    }

    public String Hv() {
        return this.aPh;
    }

    public String Hw() {
        return this.aPi;
    }

    public String Hx() {
        return this.aPj;
    }

    public String Hy() {
        return this.aPk;
    }

    public String Hz() {
        return this.aPu;
    }

    public String HA() {
        return this.aPv;
    }

    public String HB() {
        return this.aPw;
    }

    public String HC() {
        return this.aPm;
    }

    public String HD() {
        return this.aPn;
    }

    public long HE() {
        return this.aPo;
    }

    public int HF() {
        return this.aPp;
    }

    public long HG() {
        return this.lastUpdateTime;
    }

    public int HH() {
        return this.aPC;
    }

    public int HI() {
        return this.aPD;
    }

    public int HJ() {
        return this.aPE;
    }

    public int HK() {
        return this.aPF;
    }

    public long HL() {
        return this.aPr;
    }

    public int HM() {
        return this.aPs;
    }

    public int HN() {
        return this.aPq;
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
        return this.aPz;
    }

    public boolean HS() {
        return this.aPx == 1;
    }

    public int HT() {
        return this.aPt;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String HU() {
        return this.aPA;
    }

    public String HV() {
        return this.aPB;
    }

    public long HW() {
        return this.aPG;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int HX() {
        return this.aPJ;
    }

    public int HY() {
        return this.aPK;
    }

    public s HZ() {
        return this.aPH;
    }

    public int Ia() {
        return this.aPL;
    }

    public long Ib() {
        return this.aPQ;
    }

    public long Ic() {
        return this.aPR;
    }

    public boolean Id() {
        return this.aPS;
    }

    public u Ie() {
        return this.aPT;
    }
}
