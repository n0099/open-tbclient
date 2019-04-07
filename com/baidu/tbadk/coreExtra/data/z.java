package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private b activityPrizeData;
    private String bXI;
    private String bXJ;
    private String bXK;
    private String bXL;
    private String bXM;
    private String bXN;
    private String bXO;
    private String bXP;
    private long bXQ;
    private int bXR;
    private int bXS;
    private long bXT;
    private int bXU;
    private String bXW;
    private String bXX;
    private String bXY;
    public int bYa;
    private String bYc;
    private String bYd;
    private int bYe;
    private int bYf;
    private int bYg;
    private int bYh;
    private long bYi;
    private long bYj;
    private s bYk;
    private String bYl;
    private String bYp;
    private String bYr;
    private int bYs;
    private long bYt;
    private long bYu;
    private u bYw;
    private boolean bYx;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String mSharePanelText;
    private String uegVoiceWarning;
    private int bXV = 0;
    private int bXZ = 2;
    private String bYb = "";
    private int bYm = 0;
    private int bYn = 0;
    private int bYo = 0;
    private int bYq = 0;
    private boolean bYv = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bXI = jSONObject.optString("drop_pic");
                this.bXJ = jSONObject.optString("drop_pic_md5");
                this.bXK = jSONObject.optString("drop_pic_num");
                this.bXL = jSONObject.optString("drop_bg_color_day");
                this.bXM = jSONObject.optString("drop_bg_color_night");
                this.bXN = jSONObject.optString("apply_vip_live_room_pid");
                this.bXW = jSONObject.optString("max_cache");
                this.bXX = jSONObject.optString("frs_max_cache");
                this.bXY = jSONObject.optString("frs_pn");
                this.bXO = jSONObject.optString("tail_link");
                this.bXP = jSONObject.optString("bubble_link");
                this.bXQ = jSONObject.optLong("use_duration");
                this.bXR = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.bYd = jSONObject.optString("url_analyze_text");
                this.bXS = jSONObject.optInt("new_resign", 0);
                this.bXT = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bXU = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bXZ = jSONObject.optInt("localvideo_open", 2);
                this.bYa = jSONObject.optInt("card_show_statistic", 200);
                this.bYb = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.aoM().jV(jSONObject.optInt("statlog_path_max", 3));
                this.bXV = jSONObject.optInt("photo_cache_num", 60);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bYc = jSONObject.optString("nickname_activity_link");
                this.bYe = jSONObject.optInt("android_tab_show", 23);
                this.bYf = jSONObject.optInt("ribao_switch", 0);
                this.bYg = jSONObject.optInt("default_page", 0);
                this.bYh = jSONObject.optInt("remember_page", 0);
                this.bYi = jSONObject.optLong("android_new_log_upload_interval", 0L);
                this.bYj = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new b();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.bYk = new s();
                    this.bYk.parse(optJSONObject2);
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
                this.bYm = jSONObject.optInt("style_ab_switch", 0);
                this.bYn = jSONObject.optInt("abstract_ab_switch", 0);
                this.bYl = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.bYl);
                this.bYo = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.bYp = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.bYp)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.bYp);
                }
                this.bYr = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.bYr)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.bYr);
                }
                this.bYs = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.bYs);
                this.bYq = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.bYq);
                this.bYt = jSONObject.optInt("dialog_pull_time", 60) * ap.bKN;
                this.bYu = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.bYv = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
                String optString6 = jSONObject.optString("android_spring_shake", "");
                if (!StringUtils.isNull(optString6)) {
                    if (this.bYw == null) {
                        this.bYw = new u();
                    }
                    this.bYw.parserJson(optString6);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("shake_data", optString6);
                }
                this.mSharePanelText = jSONObject.optString("share_panel_text", "");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_play_type", jSONObject.optInt("video_play_type", 0));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
                int optInt = jSONObject.optInt("pb_fold_small_flow", 0);
                if (optInt == 0) {
                    this.bYx = false;
                } else if (optInt == 1) {
                    this.bYx = true;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_fold_small_flow_json", this.bYx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String agJ() {
        return this.bXN;
    }

    public String agK() {
        return this.bXI;
    }

    public String agL() {
        return this.bXJ;
    }

    public String agM() {
        return this.bXK;
    }

    public String agN() {
        return this.bXL;
    }

    public String agO() {
        return this.bXM;
    }

    public String agP() {
        return this.bXW;
    }

    public String agQ() {
        return this.bXX;
    }

    public String agR() {
        return this.bXY;
    }

    public String agS() {
        return this.bXO;
    }

    public String agT() {
        return this.bXP;
    }

    public long agU() {
        return this.bXQ;
    }

    public int agV() {
        return this.bXR;
    }

    public long agW() {
        return this.lastUpdateTime;
    }

    public int agX() {
        return this.bYe;
    }

    public int agY() {
        return this.bYf;
    }

    public int agZ() {
        return this.bYg;
    }

    public int aha() {
        return this.bYh;
    }

    public long ahb() {
        return this.bXT;
    }

    public int ahc() {
        return this.bXU;
    }

    public int ahd() {
        return this.bXS;
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
        return this.bYb;
    }

    public boolean ahi() {
        return this.bXZ == 1;
    }

    public int ahj() {
        return this.bXV;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String ahk() {
        return this.bYc;
    }

    public String ahl() {
        return this.bYd;
    }

    public long ahm() {
        return this.bYi;
    }

    public long ahn() {
        return this.bYj;
    }

    public b getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int aho() {
        return this.bYm;
    }

    public int ahp() {
        return this.bYn;
    }

    public s ahq() {
        return this.bYk;
    }

    public int ahr() {
        return this.bYo;
    }

    public long ahs() {
        return this.bYt;
    }

    public long aht() {
        return this.bYu;
    }

    public boolean ahu() {
        return this.bYv;
    }

    public u ahv() {
        return this.bYw;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public boolean ahw() {
        return this.bYx;
    }
}
