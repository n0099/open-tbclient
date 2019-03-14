package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String bXG;
    private String bXH;
    private String bXI;
    private String bXJ;
    private String bXK;
    private String bXL;
    private String bXM;
    private String bXN;
    private long bXO;
    private int bXP;
    private int bXQ;
    private long bXR;
    private int bXS;
    private String bXU;
    private String bXV;
    private String bXW;
    public int bXY;
    private String bYa;
    private String bYb;
    private int bYc;
    private int bYd;
    private int bYe;
    private int bYf;
    private long bYg;
    private long bYh;
    private s bYi;
    private String bYj;
    private String bYn;
    private String bYp;
    private int bYq;
    private long bYr;
    private long bYs;
    private u bYu;
    private boolean bYv;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int bXT = 0;
    private int bXX = 2;
    private String bXZ = "";
    private int bYk = 0;
    private int bYl = 0;
    private int bYm = 0;
    private int bYo = 0;
    private boolean bYt = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bXG = jSONObject.optString("drop_pic");
                this.bXH = jSONObject.optString("drop_pic_md5");
                this.bXI = jSONObject.optString("drop_pic_num");
                this.bXJ = jSONObject.optString("drop_bg_color_day");
                this.bXK = jSONObject.optString("drop_bg_color_night");
                this.bXL = jSONObject.optString("apply_vip_live_room_pid");
                this.bXU = jSONObject.optString("max_cache");
                this.bXV = jSONObject.optString("frs_max_cache");
                this.bXW = jSONObject.optString("frs_pn");
                this.bXM = jSONObject.optString("tail_link");
                this.bXN = jSONObject.optString("bubble_link");
                this.bXO = jSONObject.optLong("use_duration");
                this.bXP = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bYb = jSONObject.optString("url_analyze_text");
                this.bXQ = jSONObject.optInt("new_resign", 0);
                this.bXR = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bXS = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bXX = jSONObject.optInt("localvideo_open", 2);
                this.bXY = jSONObject.optInt("card_show_statistic", 200);
                this.bXZ = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.aoP().jW(jSONObject.optInt("statlog_path_max", 3));
                this.bXT = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bYa = jSONObject.optString("nickname_activity_link");
                this.bYc = jSONObject.optInt("android_tab_show", 23);
                this.bYd = jSONObject.optInt("ribao_switch", 0);
                this.bYe = jSONObject.optInt("default_page", 0);
                this.bYf = jSONObject.optInt("remember_page", 0);
                this.bYg = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.bYh = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bYi = new s();
                    this.bYi.parse(optJSONObject2);
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
                    String optString5 = optJSONObject3.optString("live", "");
                    if (!StringUtils.isNull(optString5)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_live", optString5);
                    }
                }
                com.baidu.tieba.im.db.n.tM(jSONObject.optInt("android_max_stranger"));
                this.bYk = jSONObject.optInt("style_ab_switch", 0);
                this.bYl = jSONObject.optInt("abstract_ab_switch", 0);
                this.bYj = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.bYj);
                this.bYm = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.bYn = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.bYn)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.bYn);
                }
                this.bYp = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.bYp)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.bYp);
                }
                this.bYq = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.bYq);
                this.bYo = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.bYo);
                this.bYr = jSONObject.optInt("dialog_pull_time", 60) * ap.bKL;
                this.bYs = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.bYt = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.bYu == null) {
                        this.bYu = new u();
                    }
                    this.bYu.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.bYv = false;
                } else if (optInt == 1) {
                    this.bYv = true;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_fold_small_flow_json", this.bYv);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String agM() {
        return this.bXL;
    }

    public String agN() {
        return this.bXG;
    }

    public String agO() {
        return this.bXH;
    }

    public String agP() {
        return this.bXI;
    }

    public String agQ() {
        return this.bXJ;
    }

    public String agR() {
        return this.bXK;
    }

    public String agS() {
        return this.bXU;
    }

    public String agT() {
        return this.bXV;
    }

    public String agU() {
        return this.bXW;
    }

    public String agV() {
        return this.bXM;
    }

    public String agW() {
        return this.bXN;
    }

    public long agX() {
        return this.bXO;
    }

    public int agY() {
        return this.bXP;
    }

    public long agZ() {
        return this.lastUpdateTime;
    }

    public int aha() {
        return this.bYc;
    }

    public int ahb() {
        return this.bYd;
    }

    public int ahc() {
        return this.bYe;
    }

    public int ahd() {
        return this.bYf;
    }

    public long ahe() {
        return this.bXR;
    }

    public int ahf() {
        return this.bXS;
    }

    public int ahg() {
        return this.bXQ;
    }

    public String ahh() {
        return this.infoIconUrl;
    }

    public String ahi() {
        return this.infoTargetUrl;
    }

    public long ahj() {
        return this.infoTimeStamp;
    }

    public String ahk() {
        return this.bXZ;
    }

    public boolean ahl() {
        return this.bXX == 1;
    }

    public int ahm() {
        return this.bXT;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String ahn() {
        return this.bYa;
    }

    public String aho() {
        return this.bYb;
    }

    public long ahp() {
        return this.bYg;
    }

    public long ahq() {
        return this.bYh;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int ahr() {
        return this.bYk;
    }

    public int ahs() {
        return this.bYl;
    }

    public s aht() {
        return this.bYi;
    }

    public int ahu() {
        return this.bYm;
    }

    public long ahv() {
        return this.bYr;
    }

    public long ahw() {
        return this.bYs;
    }

    public boolean ahx() {
        return this.bYt;
    }

    public u ahy() {
        return this.bYu;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean ahz() {
        return this.bYv;
    }
}
