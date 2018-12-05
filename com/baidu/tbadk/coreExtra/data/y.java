package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String aOB;
    private String aOC;
    private String aOD;
    private String aOE;
    private String aOF;
    private String aOG;
    private String aOH;
    private String aOI;
    private long aOJ;
    private int aOK;
    private int aOL;
    private long aOM;
    private int aON;
    private String aOP;
    private String aOQ;
    private String aOR;
    public int aOT;
    private String aOV;
    private String aOW;
    private int aOX;
    private int aOY;
    private int aOZ;
    private int aPa;
    private long aPb;
    private s aPc;
    private String aPd;
    private String aPh;
    private String aPj;
    private int aPk;
    private long aPl;
    private long aPm;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aOO = 0;
    private int aOS = 2;
    private String aOU = "";
    private int aPe = 0;
    private int aPf = 0;
    private int aPg = 0;
    private int aPi = 0;
    private boolean aPn = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOB = jSONObject.optString("drop_pic");
                this.aOC = jSONObject.optString("drop_pic_md5");
                this.aOD = jSONObject.optString("drop_pic_num");
                this.aOE = jSONObject.optString("drop_bg_color_day");
                this.aOF = jSONObject.optString("drop_bg_color_night");
                this.aOG = jSONObject.optString("apply_vip_live_room_pid");
                this.aOP = jSONObject.optString("max_cache");
                this.aOQ = jSONObject.optString("frs_max_cache");
                this.aOR = jSONObject.optString("frs_pn");
                this.aOH = jSONObject.optString("tail_link");
                this.aOI = jSONObject.optString("bubble_link");
                this.aOJ = jSONObject.optLong("use_duration");
                this.aOK = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aOW = jSONObject.optString("url_analyze_text");
                this.aOL = jSONObject.optInt("new_resign", 0);
                this.aOM = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aON = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aOS = jSONObject.optInt("localvideo_open", 2);
                this.aOT = jSONObject.optInt("card_show_statistic", 200);
                this.aOU = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.OR().gh(jSONObject.optInt("statlog_path_max", 3));
                this.aOO = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aOV = jSONObject.optString("nickname_activity_link");
                this.aOX = jSONObject.optInt("android_tab_show", 7);
                this.aOY = jSONObject.optInt("ribao_switch", 0);
                this.aOZ = jSONObject.optInt("default_page", 0);
                this.aPa = jSONObject.optInt("remember_page", 0);
                this.aPb = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aPc = new s();
                    this.aPc.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.pO(jSONObject.optInt("android_max_stranger"));
                this.aPe = jSONObject.optInt("style_ab_switch", 0);
                this.aPf = jSONObject.optInt("abstract_ab_switch", 0);
                this.aPd = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aPd);
                this.aPg = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aPh = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aPh)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aPh);
                }
                this.aPj = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aPj)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aPj);
                }
                this.aPk = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aPk);
                this.aPi = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aPi);
                this.aPl = jSONObject.optInt("dialog_pull_time", 60) * ao.aCn;
                this.aPm = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aPn = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String He() {
        return this.aOG;
    }

    public String Hf() {
        return this.aOB;
    }

    public String Hg() {
        return this.aOC;
    }

    public String Hh() {
        return this.aOD;
    }

    public String Hi() {
        return this.aOE;
    }

    public String Hj() {
        return this.aOF;
    }

    public String Hk() {
        return this.aOP;
    }

    public String Hl() {
        return this.aOQ;
    }

    public String Hm() {
        return this.aOR;
    }

    public String Hn() {
        return this.aOH;
    }

    public String Ho() {
        return this.aOI;
    }

    public long Hp() {
        return this.aOJ;
    }

    public int Hq() {
        return this.aOK;
    }

    public long Hr() {
        return this.lastUpdateTime;
    }

    public int Hs() {
        return this.aOX;
    }

    public int Ht() {
        return this.aOY;
    }

    public int Hu() {
        return this.aOZ;
    }

    public int Hv() {
        return this.aPa;
    }

    public long Hw() {
        return this.aOM;
    }

    public int Hx() {
        return this.aON;
    }

    public int Hy() {
        return this.aOL;
    }

    public String Hz() {
        return this.infoIconUrl;
    }

    public String HA() {
        return this.infoTargetUrl;
    }

    public long HB() {
        return this.infoTimeStamp;
    }

    public String HC() {
        return this.aOU;
    }

    public boolean HD() {
        return this.aOS == 1;
    }

    public int HE() {
        return this.aOO;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String HF() {
        return this.aOV;
    }

    public String HG() {
        return this.aOW;
    }

    public long HH() {
        return this.aPb;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int HI() {
        return this.aPe;
    }

    public int HJ() {
        return this.aPf;
    }

    public s HK() {
        return this.aPc;
    }

    public int HL() {
        return this.aPg;
    }

    public long HM() {
        return this.aPl;
    }

    public long HN() {
        return this.aPm;
    }

    public boolean HO() {
        return this.aPn;
    }
}
