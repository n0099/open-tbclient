package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a activityPrizeData;
    private String biA;
    private String biB;
    private int biC;
    private long biD;
    private q biE;
    private String biF;
    private String bif;
    private String bih;
    private String bii;
    private String bij;
    private String bik;
    private String bil;
    private String bim;
    private String bin;
    private long bio;
    private int bip;
    private int biq;
    private long bir;
    private int bis;
    private String biu;
    private String biv;
    private String biw;
    public int biy;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int bit = 0;
    private int bix = 2;
    private String biz = "";
    private int biG = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bif = jSONObject.optString("drop_pic");
                this.bih = jSONObject.optString("drop_pic_md5");
                this.bii = jSONObject.optString("drop_pic_num");
                this.bij = jSONObject.optString("drop_bg_color_day");
                this.bik = jSONObject.optString("drop_bg_color_night");
                this.bil = jSONObject.optString("apply_vip_live_room_pid");
                this.biu = jSONObject.optString("max_cache");
                this.biv = jSONObject.optString("frs_max_cache");
                this.biw = jSONObject.optString("frs_pn");
                this.bim = jSONObject.optString("tail_link");
                this.bin = jSONObject.optString("bubble_link");
                this.bio = jSONObject.optLong("use_duration");
                this.bip = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.biB = jSONObject.optString("url_analyze_text");
                this.biq = jSONObject.optInt("new_resign", 0);
                this.bir = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bis = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.bix = jSONObject.optInt("localvideo_open", 2);
                this.biy = jSONObject.optInt("card_show_statistic", 200);
                this.biz = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.NR().m13if(jSONObject.optInt("statlog_path_max", 3));
                this.bit = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.biA = jSONObject.optString("nickname_activity_link");
                this.biC = jSONObject.optInt("android_tab_show", 7);
                this.biD = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.biE = new q();
                    this.biE.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.pW(jSONObject.optInt("android_max_stranger"));
                this.biG = jSONObject.optInt("style_ab_switch", 0);
                this.biF = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.biF);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Gg() {
        return this.bil;
    }

    public String Gh() {
        return this.bif;
    }

    public String Gi() {
        return this.bih;
    }

    public String Gj() {
        return this.bii;
    }

    public String Gk() {
        return this.bij;
    }

    public String Gl() {
        return this.bik;
    }

    public String Gm() {
        return this.biu;
    }

    public String Gn() {
        return this.biv;
    }

    public String Go() {
        return this.biw;
    }

    public String Gp() {
        return this.bim;
    }

    public String Gq() {
        return this.bin;
    }

    public long Gr() {
        return this.bio;
    }

    public int Gs() {
        return this.bip;
    }

    public long Gt() {
        return this.lastUpdateTime;
    }

    public int Gu() {
        return this.biC;
    }

    public long Gv() {
        return this.bir;
    }

    public int Gw() {
        return this.bis;
    }

    public int Gx() {
        return this.biq;
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
        return this.biz;
    }

    public boolean GC() {
        return this.bix == 1;
    }

    public int GD() {
        return this.bit;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String GE() {
        return this.biA;
    }

    public String GF() {
        return this.biB;
    }

    public long GG() {
        return this.biD;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int GH() {
        return this.biG;
    }

    public q GI() {
        return this.biE;
    }
}
