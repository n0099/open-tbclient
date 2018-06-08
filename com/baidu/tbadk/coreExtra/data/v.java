package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private String aBR;
    private String aBS;
    private String aBT;
    private String aBU;
    private String aBV;
    private String aBW;
    private String aBX;
    private String aBY;
    private long aBZ;
    private int aCa;
    private int aCb;
    private long aCc;
    private int aCd;
    private String aCf;
    private String aCg;
    private String aCh;
    public int aCj;
    private String aCl;
    private String aCm;
    private int aCn;
    private long aCo;
    private q aCp;
    private String aCq;
    private String aCu;
    private String aCw;
    private a activityPrizeData;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int aCe = 0;
    private int aCi = 2;
    private String aCk = "";
    private int aCr = 0;
    private int aCs = 0;
    private int aCt = 0;
    private int aCv = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aBR = jSONObject.optString("drop_pic");
                this.aBS = jSONObject.optString("drop_pic_md5");
                this.aBT = jSONObject.optString("drop_pic_num");
                this.aBU = jSONObject.optString("drop_bg_color_day");
                this.aBV = jSONObject.optString("drop_bg_color_night");
                this.aBW = jSONObject.optString("apply_vip_live_room_pid");
                this.aCf = jSONObject.optString("max_cache");
                this.aCg = jSONObject.optString("frs_max_cache");
                this.aCh = jSONObject.optString("frs_pn");
                this.aBX = jSONObject.optString("tail_link");
                this.aBY = jSONObject.optString("bubble_link");
                this.aBZ = jSONObject.optLong("use_duration");
                this.aCa = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aCm = jSONObject.optString("url_analyze_text");
                this.aCb = jSONObject.optInt("new_resign", 0);
                this.aCc = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.aCd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aCi = jSONObject.optInt("localvideo_open", 2);
                this.aCj = jSONObject.optInt("card_show_statistic", 200);
                this.aCk = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.JZ().fj(jSONObject.optInt("statlog_path_max", 3));
                this.aCe = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aCl = jSONObject.optString("nickname_activity_link");
                this.aCn = jSONObject.optInt("android_tab_show", 7);
                this.aCo = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aCp = new q();
                    this.aCp.parse(optJSONObject2);
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
                com.baidu.tieba.im.db.n.nE(jSONObject.optInt("android_max_stranger"));
                this.aCr = jSONObject.optInt("style_ab_switch", 0);
                this.aCs = jSONObject.optInt("abstract_ab_switch", 0);
                this.aCq = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aCq);
                this.aCt = jSONObject.optInt("android_smart_frs_cache_time", -1);
                this.aCu = jSONObject.optString("shoubai_regex", "");
                if (!ao.isEmpty(this.aCu)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_baidu_password_re", this.aCu);
                }
                this.aCw = jSONObject.optString("redpacket_pop", "");
                if (!ao.isEmpty(this.aCw)) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_redpacket_pop", this.aCw);
                }
                this.aCv = jSONObject.optInt("android_show_ba_concern", 0);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_concern_tab_tips_switch", this.aCv);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Cs() {
        return this.aBW;
    }

    public String Ct() {
        return this.aBR;
    }

    public String Cu() {
        return this.aBS;
    }

    public String Cv() {
        return this.aBT;
    }

    public String Cw() {
        return this.aBU;
    }

    public String Cx() {
        return this.aBV;
    }

    public String Cy() {
        return this.aCf;
    }

    public String Cz() {
        return this.aCg;
    }

    public String CA() {
        return this.aCh;
    }

    public String CB() {
        return this.aBX;
    }

    public String CC() {
        return this.aBY;
    }

    public long CD() {
        return this.aBZ;
    }

    public int CE() {
        return this.aCa;
    }

    public long CF() {
        return this.lastUpdateTime;
    }

    public int CG() {
        return this.aCn;
    }

    public long CH() {
        return this.aCc;
    }

    public int CI() {
        return this.aCd;
    }

    public int CJ() {
        return this.aCb;
    }

    public String CK() {
        return this.infoIconUrl;
    }

    public String CL() {
        return this.infoTargetUrl;
    }

    public long CM() {
        return this.infoTimeStamp;
    }

    public String CN() {
        return this.aCk;
    }

    public boolean CO() {
        return this.aCi == 1;
    }

    public int CP() {
        return this.aCe;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String CQ() {
        return this.aCl;
    }

    public String CR() {
        return this.aCm;
    }

    public long CS() {
        return this.aCo;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int CT() {
        return this.aCr;
    }

    public int CU() {
        return this.aCs;
    }

    public q CV() {
        return this.aCp;
    }

    public int CW() {
        return this.aCt;
    }
}
