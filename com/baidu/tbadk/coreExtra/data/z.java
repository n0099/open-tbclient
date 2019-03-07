package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String bXF;
    private String bXG;
    private String bXH;
    private String bXI;
    private String bXJ;
    private String bXK;
    private String bXL;
    private String bXM;
    private long bXN;
    private int bXO;
    private int bXP;
    private long bXQ;
    private int bXR;
    private String bXT;
    private String bXU;
    private String bXV;
    public int bXX;
    private String bXZ;
    private String bYa;
    private int bYb;
    private int bYc;
    private int bYd;
    private int bYe;
    private long bYf;
    private long bYg;
    private s bYh;
    private String bYi;
    private String bYm;
    private String bYo;
    private int bYp;
    private long bYq;
    private long bYr;
    private u bYt;
    private boolean bYu;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int bXS = 0;
    private int bXW = 2;
    private String bXY = "";
    private int bYj = 0;
    private int bYk = 0;
    private int bYl = 0;
    private int bYn = 0;
    private boolean bYs = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bXF = jSONObject.optString("drop_pic");
                this.bXG = jSONObject.optString("drop_pic_md5");
                this.bXH = jSONObject.optString("drop_pic_num");
                this.bXI = jSONObject.optString("drop_bg_color_day");
                this.bXJ = jSONObject.optString("drop_bg_color_night");
                this.bXK = jSONObject.optString("apply_vip_live_room_pid");
                this.bXT = jSONObject.optString("max_cache");
                this.bXU = jSONObject.optString("frs_max_cache");
                this.bXV = jSONObject.optString("frs_pn");
                this.bXL = jSONObject.optString("tail_link");
                this.bXM = jSONObject.optString("bubble_link");
                this.bXN = jSONObject.optLong("use_duration");
                this.bXO = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bYa = jSONObject.optString("url_analyze_text");
                this.bXP = jSONObject.optInt("new_resign", 0);
                this.bXQ = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bXR = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bXW = jSONObject.optInt("localvideo_open", 2);
                this.bXX = jSONObject.optInt("card_show_statistic", 200);
                this.bXY = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.aoQ().jW(jSONObject.optInt("statlog_path_max", 3));
                this.bXS = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bXZ = jSONObject.optString("nickname_activity_link");
                this.bYb = jSONObject.optInt("android_tab_show", 23);
                this.bYc = jSONObject.optInt("ribao_switch", 0);
                this.bYd = jSONObject.optInt("default_page", 0);
                this.bYe = jSONObject.optInt("remember_page", 0);
                this.bYf = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.bYg = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bYh = new s();
                    this.bYh.parse(optJSONObject2);
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
                this.bYj = jSONObject.optInt("style_ab_switch", 0);
                this.bYk = jSONObject.optInt("abstract_ab_switch", 0);
                this.bYi = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.bYi);
                this.bYl = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.bYm = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.bYm)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.bYm);
                }
                this.bYo = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.bYo)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.bYo);
                }
                this.bYp = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.bYp);
                this.bYn = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.bYn);
                this.bYq = jSONObject.optInt("dialog_pull_time", 60) * ap.bKK;
                this.bYr = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.bYs = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.bYt == null) {
                        this.bYt = new u();
                    }
                    this.bYt.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.bYu = false;
                } else if (optInt == 1) {
                    this.bYu = true;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_fold_small_flow_json", this.bYu);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String agM() {
        return this.bXK;
    }

    public String agN() {
        return this.bXF;
    }

    public String agO() {
        return this.bXG;
    }

    public String agP() {
        return this.bXH;
    }

    public String agQ() {
        return this.bXI;
    }

    public String agR() {
        return this.bXJ;
    }

    public String agS() {
        return this.bXT;
    }

    public String agT() {
        return this.bXU;
    }

    public String agU() {
        return this.bXV;
    }

    public String agV() {
        return this.bXL;
    }

    public String agW() {
        return this.bXM;
    }

    public long agX() {
        return this.bXN;
    }

    public int agY() {
        return this.bXO;
    }

    public long agZ() {
        return this.lastUpdateTime;
    }

    public int aha() {
        return this.bYb;
    }

    public int ahb() {
        return this.bYc;
    }

    public int ahc() {
        return this.bYd;
    }

    public int ahd() {
        return this.bYe;
    }

    public long ahe() {
        return this.bXQ;
    }

    public int ahf() {
        return this.bXR;
    }

    public int ahg() {
        return this.bXP;
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
        return this.bXY;
    }

    public boolean ahl() {
        return this.bXW == 1;
    }

    public int ahm() {
        return this.bXS;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String ahn() {
        return this.bXZ;
    }

    public String aho() {
        return this.bYa;
    }

    public long ahp() {
        return this.bYf;
    }

    public long ahq() {
        return this.bYg;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int ahr() {
        return this.bYj;
    }

    public int ahs() {
        return this.bYk;
    }

    public s aht() {
        return this.bYh;
    }

    public int ahu() {
        return this.bYl;
    }

    public long ahv() {
        return this.bYq;
    }

    public long ahw() {
        return this.bYr;
    }

    public boolean ahx() {
        return this.bYs;
    }

    public u ahy() {
        return this.bYt;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean ahz() {
        return this.bYu;
    }
}
