package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String aCD;
    private String aCE;
    private String aCF;
    private String aCG;
    private String aCH;
    private String aCI;
    private String aCJ;
    private String aCK;
    private long aCL;
    private int aCM;
    private int aCN;
    private long aCO;
    private int aCP;
    private String aCR;
    private String aCS;
    private String aCT;
    public int aCV;
    private String aCX;
    private String aCY;
    private int aCZ;
    private int aDa;
    private int aDb;
    private int aDc;
    private long aDd;
    private q aDe;
    private String aDf;
    private String aDj;
    private String aDl;
    private int aDm;
    private long aDn;
    private long aDo;
    private a activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aCQ = 0;
    private int aCU = 2;
    private String aCW = "";
    private int aDg = 0;
    private int aDh = 0;
    private int aDi = 0;
    private int aDk = 0;
    private boolean aDp = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aCD = jSONObject.optString("drop_pic");
                this.aCE = jSONObject.optString("drop_pic_md5");
                this.aCF = jSONObject.optString("drop_pic_num");
                this.aCG = jSONObject.optString("drop_bg_color_day");
                this.aCH = jSONObject.optString("drop_bg_color_night");
                this.aCI = jSONObject.optString("apply_vip_live_room_pid");
                this.aCR = jSONObject.optString("max_cache");
                this.aCS = jSONObject.optString("frs_max_cache");
                this.aCT = jSONObject.optString("frs_pn");
                this.aCJ = jSONObject.optString("tail_link");
                this.aCK = jSONObject.optString("bubble_link");
                this.aCL = jSONObject.optLong("use_duration");
                this.aCM = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aCY = jSONObject.optString("url_analyze_text");
                this.aCN = jSONObject.optInt("new_resign", 0);
                this.aCO = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aCP = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aCU = jSONObject.optInt("localvideo_open", 2);
                this.aCV = jSONObject.optInt("card_show_statistic", 200);
                this.aCW = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Kq().fk(jSONObject.optInt("statlog_path_max", 3));
                this.aCQ = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aCX = jSONObject.optString("nickname_activity_link");
                this.aCZ = jSONObject.optInt("android_tab_show", 7);
                this.aDa = jSONObject.optInt("ribao_switch", 0);
                this.aDb = jSONObject.optInt("default_page", 0);
                this.aDc = jSONObject.optInt("remember_page", 0);
                this.aDd = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aDe = new q();
                    this.aDe.parse(optJSONObject2);
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
                this.aDg = jSONObject.optInt("style_ab_switch", 0);
                this.aDh = jSONObject.optInt("abstract_ab_switch", 0);
                this.aDf = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aDf);
                this.aDi = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aDj = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.aDj)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aDj);
                }
                this.aDl = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.aDl)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aDl);
                }
                this.aDm = jSONObject.optInt("android_video_slide_guide_count", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_video_guide_max_count", this.aDm);
                this.aDk = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aDk);
                this.aDn = jSONObject.optInt("dialog_pull_time", 60) * ap.aqR;
                this.aDo = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
                this.aDp = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String CA() {
        return this.aCI;
    }

    public String CB() {
        return this.aCD;
    }

    public String CC() {
        return this.aCE;
    }

    public String CD() {
        return this.aCF;
    }

    public String CE() {
        return this.aCG;
    }

    public String CF() {
        return this.aCH;
    }

    public String CG() {
        return this.aCR;
    }

    public String CH() {
        return this.aCS;
    }

    public String CI() {
        return this.aCT;
    }

    public String CJ() {
        return this.aCJ;
    }

    public String CK() {
        return this.aCK;
    }

    public long CL() {
        return this.aCL;
    }

    public int CM() {
        return this.aCM;
    }

    public long CN() {
        return this.lastUpdateTime;
    }

    public int CO() {
        return this.aCZ;
    }

    public int CP() {
        return this.aDa;
    }

    public int CQ() {
        return this.aDb;
    }

    public int CR() {
        return this.aDc;
    }

    public long CS() {
        return this.aCO;
    }

    public int CT() {
        return this.aCP;
    }

    public int CU() {
        return this.aCN;
    }

    public String CV() {
        return this.infoIconUrl;
    }

    public String CW() {
        return this.infoTargetUrl;
    }

    public long CX() {
        return this.infoTimeStamp;
    }

    public String CY() {
        return this.aCW;
    }

    public boolean CZ() {
        return this.aCU == 1;
    }

    public int Da() {
        return this.aCQ;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Db() {
        return this.aCX;
    }

    public String Dc() {
        return this.aCY;
    }

    public long Dd() {
        return this.aDd;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int De() {
        return this.aDg;
    }

    public int Df() {
        return this.aDh;
    }

    public q Dg() {
        return this.aDe;
    }

    public int Dh() {
        return this.aDi;
    }

    public long Di() {
        return this.aDn;
    }

    public long Dj() {
        return this.aDo;
    }

    public boolean Dk() {
        return this.aDp;
    }
}
