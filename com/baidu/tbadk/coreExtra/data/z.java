package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String bXJ;
    private String bXK;
    private String bXL;
    private String bXM;
    private String bXN;
    private String bXO;
    private String bXP;
    private String bXQ;
    private long bXR;
    private int bXS;
    private int bXT;
    private long bXU;
    private int bXV;
    private String bXX;
    private String bXY;
    private String bXZ;
    public int bYb;
    private String bYd;
    private String bYe;
    private int bYf;
    private int bYg;
    private int bYh;
    private int bYi;
    private long bYj;
    private long bYk;
    private s bYl;
    private String bYm;
    private String bYq;
    private String bYs;
    private int bYt;
    private long bYu;
    private long bYv;
    private u bYx;
    private boolean bYy;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int bXW = 0;
    private int bYa = 2;
    private String bYc = "";
    private int bYn = 0;
    private int bYo = 0;
    private int bYp = 0;
    private int bYr = 0;
    private boolean bYw = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bXJ = jSONObject.optString("drop_pic");
                this.bXK = jSONObject.optString("drop_pic_md5");
                this.bXL = jSONObject.optString("drop_pic_num");
                this.bXM = jSONObject.optString("drop_bg_color_day");
                this.bXN = jSONObject.optString("drop_bg_color_night");
                this.bXO = jSONObject.optString("apply_vip_live_room_pid");
                this.bXX = jSONObject.optString("max_cache");
                this.bXY = jSONObject.optString("frs_max_cache");
                this.bXZ = jSONObject.optString("frs_pn");
                this.bXP = jSONObject.optString("tail_link");
                this.bXQ = jSONObject.optString("bubble_link");
                this.bXR = jSONObject.optLong("use_duration");
                this.bXS = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bYe = jSONObject.optString("url_analyze_text");
                this.bXT = jSONObject.optInt("new_resign", 0);
                this.bXU = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bXV = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bYa = jSONObject.optInt("localvideo_open", 2);
                this.bYb = jSONObject.optInt("card_show_statistic", 200);
                this.bYc = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.aoM().jV(jSONObject.optInt("statlog_path_max", 3));
                this.bXW = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bYd = jSONObject.optString("nickname_activity_link");
                this.bYf = jSONObject.optInt("android_tab_show", 23);
                this.bYg = jSONObject.optInt("ribao_switch", 0);
                this.bYh = jSONObject.optInt("default_page", 0);
                this.bYi = jSONObject.optInt("remember_page", 0);
                this.bYj = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.bYk = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bYl = new s();
                    this.bYl.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.tI(jSONObject.optInt("android_max_stranger"));
                this.bYn = jSONObject.optInt("style_ab_switch", 0);
                this.bYo = jSONObject.optInt("abstract_ab_switch", 0);
                this.bYm = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.bYm);
                this.bYp = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.bYq = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.bYq)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.bYq);
                }
                this.bYs = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.bYs)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.bYs);
                }
                this.bYt = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.bYt);
                this.bYr = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.bYr);
                this.bYu = jSONObject.optInt("dialog_pull_time", 60) * ap.bKO;
                this.bYv = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.bYw = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.bYx == null) {
                        this.bYx = new u();
                    }
                    this.bYx.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.bYy = false;
                } else if (optInt == 1) {
                    this.bYy = true;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_fold_small_flow_json", this.bYy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String agJ() {
        return this.bXO;
    }

    public String agK() {
        return this.bXJ;
    }

    public String agL() {
        return this.bXK;
    }

    public String agM() {
        return this.bXL;
    }

    public String agN() {
        return this.bXM;
    }

    public String agO() {
        return this.bXN;
    }

    public String agP() {
        return this.bXX;
    }

    public String agQ() {
        return this.bXY;
    }

    public String agR() {
        return this.bXZ;
    }

    public String agS() {
        return this.bXP;
    }

    public String agT() {
        return this.bXQ;
    }

    public long agU() {
        return this.bXR;
    }

    public int agV() {
        return this.bXS;
    }

    public long agW() {
        return this.lastUpdateTime;
    }

    public int agX() {
        return this.bYf;
    }

    public int agY() {
        return this.bYg;
    }

    public int agZ() {
        return this.bYh;
    }

    public int aha() {
        return this.bYi;
    }

    public long ahb() {
        return this.bXU;
    }

    public int ahc() {
        return this.bXV;
    }

    public int ahd() {
        return this.bXT;
    }

    public String ahe() {
        return this.infoIconUrl;
    }

    public String ahf() {
        return this.infoTargetUrl;
    }

    public long ahg() {
        return this.infoTimeStamp;
    }

    public String ahh() {
        return this.bYc;
    }

    public boolean ahi() {
        return this.bYa == 1;
    }

    public int ahj() {
        return this.bXW;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String ahk() {
        return this.bYd;
    }

    public String ahl() {
        return this.bYe;
    }

    public long ahm() {
        return this.bYj;
    }

    public long ahn() {
        return this.bYk;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aho() {
        return this.bYn;
    }

    public int ahp() {
        return this.bYo;
    }

    public s ahq() {
        return this.bYl;
    }

    public int ahr() {
        return this.bYp;
    }

    public long ahs() {
        return this.bYu;
    }

    public long aht() {
        return this.bYv;
    }

    public boolean ahu() {
        return this.bYw;
    }

    public u ahv() {
        return this.bYx;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean ahw() {
        return this.bYy;
    }
}
