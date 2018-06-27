package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private String aCL;
    private String aCM;
    private String aCN;
    private String aCO;
    private String aCP;
    private String aCQ;
    private String aCR;
    private String aCS;
    private long aCT;
    private int aCU;
    private int aCV;
    private long aCW;
    private int aCX;
    private String aCZ;
    private String aDa;
    private String aDb;
    public int aDd;
    private String aDf;
    private String aDg;
    private int aDh;
    private long aDi;
    private q aDj;
    private String aDk;
    private String aDo;
    private String aDq;
    private a activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aCY = 0;
    private int aDc = 2;
    private String aDe = "";
    private int aDl = 0;
    private int aDm = 0;
    private int aDn = 0;
    private int aDp = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aCL = jSONObject.optString("drop_pic");
                this.aCM = jSONObject.optString("drop_pic_md5");
                this.aCN = jSONObject.optString("drop_pic_num");
                this.aCO = jSONObject.optString("drop_bg_color_day");
                this.aCP = jSONObject.optString("drop_bg_color_night");
                this.aCQ = jSONObject.optString("apply_vip_live_room_pid");
                this.aCZ = jSONObject.optString("max_cache");
                this.aDa = jSONObject.optString("frs_max_cache");
                this.aDb = jSONObject.optString("frs_pn");
                this.aCR = jSONObject.optString("tail_link");
                this.aCS = jSONObject.optString("bubble_link");
                this.aCT = jSONObject.optLong("use_duration");
                this.aCU = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aDg = jSONObject.optString("url_analyze_text");
                this.aCV = jSONObject.optInt("new_resign", 0);
                this.aCW = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aCX = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aDc = jSONObject.optInt("localvideo_open", 2);
                this.aDd = jSONObject.optInt("card_show_statistic", 200);
                this.aDe = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Kr().fk(jSONObject.optInt("statlog_path_max", 3));
                this.aCY = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aDf = jSONObject.optString("nickname_activity_link");
                this.aDh = jSONObject.optInt("android_tab_show", 7);
                this.aDi = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aDj = new q();
                    this.aDj.parse(optJSONObject2);
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
                    if (!StringUtils.isNull(optJSONObject3.optString("video", ""))) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video", optString3);
                    }
                }
                com.baidu.tieba.im.db.n.nL(jSONObject.optInt("android_max_stranger"));
                this.aDl = jSONObject.optInt("style_ab_switch", 0);
                this.aDm = jSONObject.optInt("abstract_ab_switch", 0);
                this.aDk = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aDk);
                this.aDn = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aDo = jSONObject.optString("shoubai_regex", "");
                if (!ap.isEmpty(this.aDo)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aDo);
                }
                this.aDq = jSONObject.optString("redpacket_pop", "");
                if (!ap.isEmpty(this.aDq)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aDq);
                }
                this.aDp = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aDp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String CK() {
        return this.aCQ;
    }

    public String CL() {
        return this.aCL;
    }

    public String CM() {
        return this.aCM;
    }

    public String CN() {
        return this.aCN;
    }

    public String CO() {
        return this.aCO;
    }

    public String CP() {
        return this.aCP;
    }

    public String CQ() {
        return this.aCZ;
    }

    public String CR() {
        return this.aDa;
    }

    public String CS() {
        return this.aDb;
    }

    public String CT() {
        return this.aCR;
    }

    public String CU() {
        return this.aCS;
    }

    public long CV() {
        return this.aCT;
    }

    public int CW() {
        return this.aCU;
    }

    public long CX() {
        return this.lastUpdateTime;
    }

    public int CY() {
        return this.aDh;
    }

    public long CZ() {
        return this.aCW;
    }

    public int Da() {
        return this.aCX;
    }

    public int Db() {
        return this.aCV;
    }

    public String Dc() {
        return this.infoIconUrl;
    }

    public String Dd() {
        return this.infoTargetUrl;
    }

    public long De() {
        return this.infoTimeStamp;
    }

    public String Df() {
        return this.aDe;
    }

    public boolean Dg() {
        return this.aDc == 1;
    }

    public int Dh() {
        return this.aCY;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String Di() {
        return this.aDf;
    }

    public String Dj() {
        return this.aDg;
    }

    public long Dk() {
        return this.aDi;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int Dl() {
        return this.aDl;
    }

    public int Dm() {
        return this.aDm;
    }

    public q Dn() {
        return this.aDj;
    }

    public int Do() {
        return this.aDn;
    }
}
