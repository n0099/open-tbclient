package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private String aCG;
    private String aCH;
    private String aCI;
    private String aCJ;
    private String aCK;
    private String aCL;
    private String aCM;
    private String aCN;
    private long aCO;
    private int aCP;
    private int aCQ;
    private long aCR;
    private int aCS;
    private String aCU;
    private String aCV;
    private String aCW;
    public int aCY;
    private String aDa;
    private String aDb;
    private int aDc;
    private int aDd;
    private int aDe;
    private int aDf;
    private long aDg;
    private q aDh;
    private String aDi;
    private String aDm;
    private String aDo;
    private int aDp;
    private long aDq;
    private a activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aCT = 0;
    private int aCX = 2;
    private String aCZ = "";
    private int aDj = 0;
    private int aDk = 0;
    private int aDl = 0;
    private int aDn = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aCG = jSONObject.optString("drop_pic");
                this.aCH = jSONObject.optString("drop_pic_md5");
                this.aCI = jSONObject.optString("drop_pic_num");
                this.aCJ = jSONObject.optString("drop_bg_color_day");
                this.aCK = jSONObject.optString("drop_bg_color_night");
                this.aCL = jSONObject.optString("apply_vip_live_room_pid");
                this.aCU = jSONObject.optString("max_cache");
                this.aCV = jSONObject.optString("frs_max_cache");
                this.aCW = jSONObject.optString("frs_pn");
                this.aCM = jSONObject.optString("tail_link");
                this.aCN = jSONObject.optString("bubble_link");
                this.aCO = jSONObject.optLong("use_duration");
                this.aCP = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aDb = jSONObject.optString("url_analyze_text");
                this.aCQ = jSONObject.optInt("new_resign", 0);
                this.aCR = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aCS = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aCX = jSONObject.optInt("localvideo_open", 2);
                this.aCY = jSONObject.optInt("card_show_statistic", 200);
                this.aCZ = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Km().fl(jSONObject.optInt("statlog_path_max", 3));
                this.aCT = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aDa = jSONObject.optString("nickname_activity_link");
                this.aDc = jSONObject.optInt("android_tab_show", 7);
                this.aDd = jSONObject.optInt("ribao_switch", 0);
                this.aDe = jSONObject.optInt("default_page", 0);
                this.aDf = jSONObject.optInt("remember_page", 0);
                this.aDg = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aDh = new q();
                    this.aDh.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.nZ(jSONObject.optInt("android_max_stranger"));
                this.aDj = jSONObject.optInt("style_ab_switch", 0);
                this.aDk = jSONObject.optInt("abstract_ab_switch", 0);
                this.aDi = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aDi);
                this.aDl = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aDm = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.aDm)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aDm);
                }
                this.aDo = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.aDo)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aDo);
                }
                this.aDp = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aDp);
                this.aDn = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aDn);
                this.aDq = jSONObject.optInt("dialog_pull_time", 60) * ap.aqQ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String CC() {
        return this.aCL;
    }

    public String CD() {
        return this.aCG;
    }

    public String CE() {
        return this.aCH;
    }

    public String CF() {
        return this.aCI;
    }

    public String CG() {
        return this.aCJ;
    }

    public String CH() {
        return this.aCK;
    }

    public String CI() {
        return this.aCU;
    }

    public String CJ() {
        return this.aCV;
    }

    public String CK() {
        return this.aCW;
    }

    public String CL() {
        return this.aCM;
    }

    public String CM() {
        return this.aCN;
    }

    public long CN() {
        return this.aCO;
    }

    public int CO() {
        return this.aCP;
    }

    public long CP() {
        return this.lastUpdateTime;
    }

    public int CQ() {
        return this.aDc;
    }

    public int CR() {
        return this.aDd;
    }

    public int CS() {
        return this.aDe;
    }

    public int CT() {
        return this.aDf;
    }

    public long CU() {
        return this.aCR;
    }

    public int CV() {
        return this.aCS;
    }

    public int CW() {
        return this.aCQ;
    }

    public String CX() {
        return this.infoIconUrl;
    }

    public String CY() {
        return this.infoTargetUrl;
    }

    public long CZ() {
        return this.infoTimeStamp;
    }

    public String Da() {
        return this.aCZ;
    }

    public boolean Db() {
        return this.aCX == 1;
    }

    public int Dc() {
        return this.aCT;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Dd() {
        return this.aDa;
    }

    public String De() {
        return this.aDb;
    }

    public long Df() {
        return this.aDg;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Dg() {
        return this.aDj;
    }

    public int Dh() {
        return this.aDk;
    }

    public q Di() {
        return this.aDh;
    }

    public int Dj() {
        return this.aDl;
    }

    public long Dk() {
        return this.aDq;
    }
}
