package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String aOD;
    private String aOE;
    private String aOF;
    private String aOG;
    private String aOH;
    private String aOI;
    private String aOJ;
    private String aOK;
    private long aOL;
    private int aOM;
    private int aON;
    private long aOO;
    private int aOP;
    private String aOR;
    private String aOS;
    private String aOT;
    public int aOV;
    private String aOX;
    private String aOY;
    private int aOZ;
    private int aPa;
    private int aPb;
    private int aPc;
    private long aPd;
    private s aPe;
    private String aPf;
    private String aPj;
    private String aPl;
    private int aPm;
    private long aPn;
    private long aPo;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aOQ = 0;
    private int aOU = 2;
    private String aOW = "";
    private int aPg = 0;
    private int aPh = 0;
    private int aPi = 0;
    private int aPk = 0;
    private boolean aPp = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOD = jSONObject.optString("drop_pic");
                this.aOE = jSONObject.optString("drop_pic_md5");
                this.aOF = jSONObject.optString("drop_pic_num");
                this.aOG = jSONObject.optString("drop_bg_color_day");
                this.aOH = jSONObject.optString("drop_bg_color_night");
                this.aOI = jSONObject.optString("apply_vip_live_room_pid");
                this.aOR = jSONObject.optString("max_cache");
                this.aOS = jSONObject.optString("frs_max_cache");
                this.aOT = jSONObject.optString("frs_pn");
                this.aOJ = jSONObject.optString("tail_link");
                this.aOK = jSONObject.optString("bubble_link");
                this.aOL = jSONObject.optLong("use_duration");
                this.aOM = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aOY = jSONObject.optString("url_analyze_text");
                this.aON = jSONObject.optInt("new_resign", 0);
                this.aOO = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aOP = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aOU = jSONObject.optInt("localvideo_open", 2);
                this.aOV = jSONObject.optInt("card_show_statistic", 200);
                this.aOW = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.OS().gi(jSONObject.optInt("statlog_path_max", 3));
                this.aOQ = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aOX = jSONObject.optString("nickname_activity_link");
                this.aOZ = jSONObject.optInt("android_tab_show", 7);
                this.aPa = jSONObject.optInt("ribao_switch", 0);
                this.aPb = jSONObject.optInt("default_page", 0);
                this.aPc = jSONObject.optInt("remember_page", 0);
                this.aPd = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aPe = new s();
                    this.aPe.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.qb(jSONObject.optInt("android_max_stranger"));
                this.aPg = jSONObject.optInt("style_ab_switch", 0);
                this.aPh = jSONObject.optInt("abstract_ab_switch", 0);
                this.aPf = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aPf);
                this.aPi = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aPj = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aPj)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aPj);
                }
                this.aPl = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aPl)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aPl);
                }
                this.aPm = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aPm);
                this.aPk = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aPk);
                this.aPn = jSONObject.optInt("dialog_pull_time", 60) * ao.aCn;
                this.aPo = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aPp = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Hf() {
        return this.aOI;
    }

    public String Hg() {
        return this.aOD;
    }

    public String Hh() {
        return this.aOE;
    }

    public String Hi() {
        return this.aOF;
    }

    public String Hj() {
        return this.aOG;
    }

    public String Hk() {
        return this.aOH;
    }

    public String Hl() {
        return this.aOR;
    }

    public String Hm() {
        return this.aOS;
    }

    public String Hn() {
        return this.aOT;
    }

    public String Ho() {
        return this.aOJ;
    }

    public String Hp() {
        return this.aOK;
    }

    public long Hq() {
        return this.aOL;
    }

    public int Hr() {
        return this.aOM;
    }

    public long Hs() {
        return this.lastUpdateTime;
    }

    public int Ht() {
        return this.aOZ;
    }

    public int Hu() {
        return this.aPa;
    }

    public int Hv() {
        return this.aPb;
    }

    public int Hw() {
        return this.aPc;
    }

    public long Hx() {
        return this.aOO;
    }

    public int Hy() {
        return this.aOP;
    }

    public int Hz() {
        return this.aON;
    }

    public String HA() {
        return this.infoIconUrl;
    }

    public String HB() {
        return this.infoTargetUrl;
    }

    public long HC() {
        return this.infoTimeStamp;
    }

    public String HD() {
        return this.aOW;
    }

    public boolean HE() {
        return this.aOU == 1;
    }

    public int HF() {
        return this.aOQ;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String HG() {
        return this.aOX;
    }

    public String HH() {
        return this.aOY;
    }

    public long HI() {
        return this.aPd;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int HJ() {
        return this.aPg;
    }

    public int HK() {
        return this.aPh;
    }

    public s HL() {
        return this.aPe;
    }

    public int HM() {
        return this.aPi;
    }

    public long HN() {
        return this.aPn;
    }

    public long HO() {
        return this.aPo;
    }

    public boolean HP() {
        return this.aPp;
    }
}
