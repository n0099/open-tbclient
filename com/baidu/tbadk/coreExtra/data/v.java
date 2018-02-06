package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a activityPrizeData;
    private long biA;
    private int biB;
    private String biD;
    private String biE;
    private String biF;
    public int biH;
    private String biJ;
    private String biK;
    private int biL;
    private long biM;
    private q biN;
    private String biO;
    private String bip;
    private String biq;
    private String bir;
    private String bis;
    private String bit;
    private String biu;
    private String biv;
    private String biw;
    private long bix;
    private int biy;
    private int biz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int biC = 0;
    private int biG = 2;
    private String biI = "";
    private int biP = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bip = jSONObject.optString("drop_pic");
                this.biq = jSONObject.optString("drop_pic_md5");
                this.bir = jSONObject.optString("drop_pic_num");
                this.bis = jSONObject.optString("drop_bg_color_day");
                this.bit = jSONObject.optString("drop_bg_color_night");
                this.biu = jSONObject.optString("apply_vip_live_room_pid");
                this.biD = jSONObject.optString("max_cache");
                this.biE = jSONObject.optString("frs_max_cache");
                this.biF = jSONObject.optString("frs_pn");
                this.biv = jSONObject.optString("tail_link");
                this.biw = jSONObject.optString("bubble_link");
                this.bix = jSONObject.optLong("use_duration");
                this.biy = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.biK = jSONObject.optString("url_analyze_text");
                this.biz = jSONObject.optInt("new_resign", 0);
                this.biA = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.biB = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.biG = jSONObject.optInt("localvideo_open", 2);
                this.biH = jSONObject.optInt("card_show_statistic", 200);
                this.biI = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.NR().m13if(jSONObject.optInt("statlog_path_max", 3));
                this.biC = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.biJ = jSONObject.optString("nickname_activity_link");
                this.biL = jSONObject.optInt("android_tab_show", 7);
                this.biM = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.biN = new q();
                    this.biN.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.pV(jSONObject.optInt("android_max_stranger"));
                this.biP = jSONObject.optInt("style_ab_switch", 0);
                this.biO = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.biO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Gg() {
        return this.biu;
    }

    public String Gh() {
        return this.bip;
    }

    public String Gi() {
        return this.biq;
    }

    public String Gj() {
        return this.bir;
    }

    public String Gk() {
        return this.bis;
    }

    public String Gl() {
        return this.bit;
    }

    public String Gm() {
        return this.biD;
    }

    public String Gn() {
        return this.biE;
    }

    public String Go() {
        return this.biF;
    }

    public String Gp() {
        return this.biv;
    }

    public String Gq() {
        return this.biw;
    }

    public long Gr() {
        return this.bix;
    }

    public int Gs() {
        return this.biy;
    }

    public long Gt() {
        return this.lastUpdateTime;
    }

    public int Gu() {
        return this.biL;
    }

    public long Gv() {
        return this.biA;
    }

    public int Gw() {
        return this.biB;
    }

    public int Gx() {
        return this.biz;
    }

    public String Gy() {
        return this.infoIconUrl;
    }

    public String Gz() {
        return this.infoTargetUrl;
    }

    public long GA() {
        return this.infoTimeStamp;
    }

    public String GB() {
        return this.biI;
    }

    public boolean GC() {
        return this.biG == 1;
    }

    public int GD() {
        return this.biC;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String GE() {
        return this.biJ;
    }

    public String GF() {
        return this.biK;
    }

    public long GG() {
        return this.biM;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int GH() {
        return this.biP;
    }

    public q GI() {
        return this.biN;
    }
}
