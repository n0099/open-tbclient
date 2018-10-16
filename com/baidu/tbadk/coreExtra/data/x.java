package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private String aKA;
    private String aKB;
    private String aKC;
    public int aKE;
    private String aKG;
    private String aKH;
    private int aKI;
    private int aKJ;
    private int aKK;
    private int aKL;
    private long aKM;
    private r aKN;
    private String aKO;
    private String aKS;
    private String aKU;
    private int aKV;
    private long aKW;
    private long aKX;
    private String aKm;
    private String aKn;
    private String aKo;
    private String aKp;
    private String aKq;
    private String aKr;
    private String aKs;
    private String aKt;
    private long aKu;
    private int aKv;
    private int aKw;
    private long aKx;
    private int aKy;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aKz = 0;
    private int aKD = 2;
    private String aKF = "";
    private int aKP = 0;
    private int aKQ = 0;
    private int aKR = 0;
    private int aKT = 0;
    private boolean aKY = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aKm = jSONObject.optString("drop_pic");
                this.aKn = jSONObject.optString("drop_pic_md5");
                this.aKo = jSONObject.optString("drop_pic_num");
                this.aKp = jSONObject.optString("drop_bg_color_day");
                this.aKq = jSONObject.optString("drop_bg_color_night");
                this.aKr = jSONObject.optString("apply_vip_live_room_pid");
                this.aKA = jSONObject.optString("max_cache");
                this.aKB = jSONObject.optString("frs_max_cache");
                this.aKC = jSONObject.optString("frs_pn");
                this.aKs = jSONObject.optString("tail_link");
                this.aKt = jSONObject.optString("bubble_link");
                this.aKu = jSONObject.optLong("use_duration");
                this.aKv = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aKH = jSONObject.optString("url_analyze_text");
                this.aKw = jSONObject.optInt("new_resign", 0);
                this.aKx = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aKy = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aKD = jSONObject.optInt("localvideo_open", 2);
                this.aKE = jSONObject.optInt("card_show_statistic", 200);
                this.aKF = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.NE().fF(jSONObject.optInt("statlog_path_max", 3));
                this.aKz = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aKG = jSONObject.optString("nickname_activity_link");
                this.aKI = jSONObject.optInt("android_tab_show", 7);
                this.aKJ = jSONObject.optInt("ribao_switch", 0);
                this.aKK = jSONObject.optInt("default_page", 0);
                this.aKL = jSONObject.optInt("remember_page", 0);
                this.aKM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aKN = new r();
                    this.aKN.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("index_tab_text");
                if (optJSONObject3 != null && !StringUtils.isNull(optJSONObject3.toString())) {
                    String optString = optJSONObject3.optString("concern", "");
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
                com.baidu.tieba.im.db.n.pb(jSONObject.optInt("android_max_stranger"));
                this.aKP = jSONObject.optInt("style_ab_switch", 0);
                this.aKQ = jSONObject.optInt("abstract_ab_switch", 0);
                this.aKO = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aKO);
                this.aKR = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aKS = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aKS)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aKS);
                }
                this.aKU = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aKU)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aKU);
                }
                this.aKV = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aKV);
                this.aKT = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aKT);
                this.aKW = jSONObject.optInt("dialog_pull_time", 60) * ao.aya;
                this.aKX = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aKY = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String FO() {
        return this.aKr;
    }

    public String FP() {
        return this.aKm;
    }

    public String FQ() {
        return this.aKn;
    }

    public String FR() {
        return this.aKo;
    }

    public String FS() {
        return this.aKp;
    }

    public String FT() {
        return this.aKq;
    }

    public String FU() {
        return this.aKA;
    }

    public String FV() {
        return this.aKB;
    }

    public String FW() {
        return this.aKC;
    }

    public String FX() {
        return this.aKs;
    }

    public String FY() {
        return this.aKt;
    }

    public long FZ() {
        return this.aKu;
    }

    public int Ga() {
        return this.aKv;
    }

    public long Gb() {
        return this.lastUpdateTime;
    }

    public int Gc() {
        return this.aKI;
    }

    public int Gd() {
        return this.aKJ;
    }

    public int Ge() {
        return this.aKK;
    }

    public int Gf() {
        return this.aKL;
    }

    public long Gg() {
        return this.aKx;
    }

    public int Gh() {
        return this.aKy;
    }

    public int Gi() {
        return this.aKw;
    }

    public String Gj() {
        return this.infoIconUrl;
    }

    public String Gk() {
        return this.infoTargetUrl;
    }

    public long Gl() {
        return this.infoTimeStamp;
    }

    public String Gm() {
        return this.aKF;
    }

    public boolean Gn() {
        return this.aKD == 1;
    }

    public int Go() {
        return this.aKz;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Gp() {
        return this.aKG;
    }

    public String Gq() {
        return this.aKH;
    }

    public long Gr() {
        return this.aKM;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Gs() {
        return this.aKP;
    }

    public int Gt() {
        return this.aKQ;
    }

    public r Gu() {
        return this.aKN;
    }

    public int Gv() {
        return this.aKR;
    }

    public long Gw() {
        return this.aKW;
    }

    public long Gx() {
        return this.aKX;
    }

    public boolean Gy() {
        return this.aKY;
    }
}
