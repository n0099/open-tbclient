package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private int aLA;
    private int aLB;
    private long aLC;
    private s aLD;
    private String aLE;
    private String aLI;
    private String aLK;
    private int aLL;
    private long aLM;
    private long aLN;
    private String aLc;
    private String aLd;
    private String aLe;
    private String aLf;
    private String aLg;
    private String aLh;
    private String aLi;
    private String aLj;
    private long aLk;
    private int aLl;
    private int aLm;
    private long aLn;
    private int aLo;
    private String aLq;
    private String aLr;
    private String aLs;
    public int aLu;
    private String aLw;
    private String aLx;
    private int aLy;
    private int aLz;
    private b activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aLp = 0;
    private int aLt = 2;
    private String aLv = "";
    private int aLF = 0;
    private int aLG = 0;
    private int aLH = 0;
    private int aLJ = 0;
    private boolean aLO = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aLc = jSONObject.optString("drop_pic");
                this.aLd = jSONObject.optString("drop_pic_md5");
                this.aLe = jSONObject.optString("drop_pic_num");
                this.aLf = jSONObject.optString("drop_bg_color_day");
                this.aLg = jSONObject.optString("drop_bg_color_night");
                this.aLh = jSONObject.optString("apply_vip_live_room_pid");
                this.aLq = jSONObject.optString("max_cache");
                this.aLr = jSONObject.optString("frs_max_cache");
                this.aLs = jSONObject.optString("frs_pn");
                this.aLi = jSONObject.optString("tail_link");
                this.aLj = jSONObject.optString("bubble_link");
                this.aLk = jSONObject.optLong("use_duration");
                this.aLl = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aLx = jSONObject.optString("url_analyze_text");
                this.aLm = jSONObject.optInt("new_resign", 0);
                this.aLn = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aLo = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aLt = jSONObject.optInt("localvideo_open", 2);
                this.aLu = jSONObject.optInt("card_show_statistic", 200);
                this.aLv = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.NN().fT(jSONObject.optInt("statlog_path_max", 3));
                this.aLp = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aLw = jSONObject.optString("nickname_activity_link");
                this.aLy = jSONObject.optInt("android_tab_show", 7);
                this.aLz = jSONObject.optInt("ribao_switch", 0);
                this.aLA = jSONObject.optInt("default_page", 0);
                this.aLB = jSONObject.optInt("remember_page", 0);
                this.aLC = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aLD = new s();
                    this.aLD.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.pu(jSONObject.optInt("android_max_stranger"));
                this.aLF = jSONObject.optInt("style_ab_switch", 0);
                this.aLG = jSONObject.optInt("abstract_ab_switch", 0);
                this.aLE = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aLE);
                this.aLH = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aLI = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aLI)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aLI);
                }
                this.aLK = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aLK)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aLK);
                }
                this.aLL = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aLL);
                this.aLJ = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aLJ);
                this.aLM = jSONObject.optInt("dialog_pull_time", 60) * ao.ayN;
                this.aLN = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aLO = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Ga() {
        return this.aLh;
    }

    public String Gb() {
        return this.aLc;
    }

    public String Gc() {
        return this.aLd;
    }

    public String Gd() {
        return this.aLe;
    }

    public String Ge() {
        return this.aLf;
    }

    public String Gf() {
        return this.aLg;
    }

    public String Gg() {
        return this.aLq;
    }

    public String Gh() {
        return this.aLr;
    }

    public String Gi() {
        return this.aLs;
    }

    public String Gj() {
        return this.aLi;
    }

    public String Gk() {
        return this.aLj;
    }

    public long Gl() {
        return this.aLk;
    }

    public int Gm() {
        return this.aLl;
    }

    public long Gn() {
        return this.lastUpdateTime;
    }

    public int Go() {
        return this.aLy;
    }

    public int Gp() {
        return this.aLz;
    }

    public int Gq() {
        return this.aLA;
    }

    public int Gr() {
        return this.aLB;
    }

    public long Gs() {
        return this.aLn;
    }

    public int Gt() {
        return this.aLo;
    }

    public int Gu() {
        return this.aLm;
    }

    public String Gv() {
        return this.infoIconUrl;
    }

    public String Gw() {
        return this.infoTargetUrl;
    }

    public long Gx() {
        return this.infoTimeStamp;
    }

    public String Gy() {
        return this.aLv;
    }

    public boolean Gz() {
        return this.aLt == 1;
    }

    public int GA() {
        return this.aLp;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String GB() {
        return this.aLw;
    }

    public String GC() {
        return this.aLx;
    }

    public long GD() {
        return this.aLC;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int GE() {
        return this.aLF;
    }

    public int GF() {
        return this.aLG;
    }

    public s GG() {
        return this.aLD;
    }

    public int GH() {
        return this.aLH;
    }

    public long GI() {
        return this.aLM;
    }

    public long GJ() {
        return this.aLN;
    }

    public boolean GK() {
        return this.aLO;
    }
}
