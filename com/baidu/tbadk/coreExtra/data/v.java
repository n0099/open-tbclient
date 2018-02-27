package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a activityPrizeData;
    private long biA;
    private q biB;
    private String biC;
    private String bib;
    private String bic;
    private String bie;
    private String bif;
    private String bih;
    private String bii;
    private String bij;
    private String bik;
    private long bil;
    private int bim;
    private int bin;
    private long bio;
    private int bip;
    private String bir;
    private String bis;
    private String bit;
    public int biv;
    private String bix;
    private String biy;
    private int biz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int biq = 0;
    private int biu = 2;
    private String biw = "";
    private int biD = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bib = jSONObject.optString("drop_pic");
                this.bic = jSONObject.optString("drop_pic_md5");
                this.bie = jSONObject.optString("drop_pic_num");
                this.bif = jSONObject.optString("drop_bg_color_day");
                this.bih = jSONObject.optString("drop_bg_color_night");
                this.bii = jSONObject.optString("apply_vip_live_room_pid");
                this.bir = jSONObject.optString("max_cache");
                this.bis = jSONObject.optString("frs_max_cache");
                this.bit = jSONObject.optString("frs_pn");
                this.bij = jSONObject.optString("tail_link");
                this.bik = jSONObject.optString("bubble_link");
                this.bil = jSONObject.optLong("use_duration");
                this.bim = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.biy = jSONObject.optString("url_analyze_text");
                this.bin = jSONObject.optInt("new_resign", 0);
                this.bio = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.bip = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.biu = jSONObject.optInt("localvideo_open", 2);
                this.biv = jSONObject.optInt("card_show_statistic", 200);
                this.biw = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.NQ().m13if(jSONObject.optInt("statlog_path_max", 3));
                this.biq = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.bix = jSONObject.optString("nickname_activity_link");
                this.biz = jSONObject.optInt("android_tab_show", 7);
                this.biA = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.biB = new q();
                    this.biB.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.pV(jSONObject.optInt("android_max_stranger"));
                this.biD = jSONObject.optInt("style_ab_switch", 0);
                this.biC = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.biC);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String Gf() {
        return this.bii;
    }

    public String Gg() {
        return this.bib;
    }

    public String Gh() {
        return this.bic;
    }

    public String Gi() {
        return this.bie;
    }

    public String Gj() {
        return this.bif;
    }

    public String Gk() {
        return this.bih;
    }

    public String Gl() {
        return this.bir;
    }

    public String Gm() {
        return this.bis;
    }

    public String Gn() {
        return this.bit;
    }

    public String Go() {
        return this.bij;
    }

    public String Gp() {
        return this.bik;
    }

    public long Gq() {
        return this.bil;
    }

    public int Gr() {
        return this.bim;
    }

    public long Gs() {
        return this.lastUpdateTime;
    }

    public int Gt() {
        return this.biz;
    }

    public long Gu() {
        return this.bio;
    }

    public int Gv() {
        return this.bip;
    }

    public int Gw() {
        return this.bin;
    }

    public String Gx() {
        return this.infoIconUrl;
    }

    public String Gy() {
        return this.infoTargetUrl;
    }

    public long Gz() {
        return this.infoTimeStamp;
    }

    public String GA() {
        return this.biw;
    }

    public boolean GB() {
        return this.biu == 1;
    }

    public int GC() {
        return this.biq;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String GD() {
        return this.bix;
    }

    public String GE() {
        return this.biy;
    }

    public long GF() {
        return this.biA;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int GG() {
        return this.biD;
    }

    public q GH() {
        return this.biB;
    }
}
