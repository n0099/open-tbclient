package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a activityPrizeData;
    private String atK;
    private String atL;
    private String atM;
    private String atN;
    private String atO;
    private String atP;
    private String atQ;
    private String atR;
    private long atS;
    private int atT;
    private int atU;
    private long atV;
    private int atW;
    private String atY;
    private String atZ;
    private String aua;
    public int auc;
    private String aue;
    private String auf;
    private int aug;
    private long auh;
    private q aui;
    private String auj;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int atX = 0;
    private int aub = 2;
    private String aud = "";
    private int auk = 0;
    private int aul = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.atK = jSONObject.optString("drop_pic");
                this.atL = jSONObject.optString("drop_pic_md5");
                this.atM = jSONObject.optString("drop_pic_num");
                this.atN = jSONObject.optString("drop_bg_color_day");
                this.atO = jSONObject.optString("drop_bg_color_night");
                this.atP = jSONObject.optString("apply_vip_live_room_pid");
                this.atY = jSONObject.optString("max_cache");
                this.atZ = jSONObject.optString("frs_max_cache");
                this.aua = jSONObject.optString("frs_pn");
                this.atQ = jSONObject.optString("tail_link");
                this.atR = jSONObject.optString("bubble_link");
                this.atS = jSONObject.optLong("use_duration");
                this.atT = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.auf = jSONObject.optString("url_analyze_text");
                this.atU = jSONObject.optInt("new_resign", 0);
                this.atV = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.atW = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aub = jSONObject.optInt("localvideo_open", 2);
                this.auc = jSONObject.optInt("card_show_statistic", 200);
                this.aud = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Gr().ff(jSONObject.optInt("statlog_path_max", 3));
                this.atX = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aue = jSONObject.optString("nickname_activity_link");
                this.aug = jSONObject.optInt("android_tab_show", 7);
                this.auh = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.aui = new q();
                    this.aui.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.ns(jSONObject.optInt("android_max_stranger"));
                this.auk = jSONObject.optInt("style_ab_switch", 0);
                this.aul = jSONObject.optInt("abstract_ab_switch", 0);
                this.auj = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.auj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yS() {
        return this.atP;
    }

    public String yT() {
        return this.atK;
    }

    public String yU() {
        return this.atL;
    }

    public String yV() {
        return this.atM;
    }

    public String yW() {
        return this.atN;
    }

    public String yX() {
        return this.atO;
    }

    public String yY() {
        return this.atY;
    }

    public String yZ() {
        return this.atZ;
    }

    public String za() {
        return this.aua;
    }

    public String zb() {
        return this.atQ;
    }

    public String zc() {
        return this.atR;
    }

    public long zd() {
        return this.atS;
    }

    public int ze() {
        return this.atT;
    }

    public long zf() {
        return this.lastUpdateTime;
    }

    public int zg() {
        return this.aug;
    }

    public long zh() {
        return this.atV;
    }

    public int zi() {
        return this.atW;
    }

    public int zj() {
        return this.atU;
    }

    public String zk() {
        return this.infoIconUrl;
    }

    public String zl() {
        return this.infoTargetUrl;
    }

    public long zm() {
        return this.infoTimeStamp;
    }

    public String zn() {
        return this.aud;
    }

    public boolean zo() {
        return this.aub == 1;
    }

    public int zp() {
        return this.atX;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String zq() {
        return this.aue;
    }

    public String zr() {
        return this.auf;
    }

    public long zs() {
        return this.auh;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int zt() {
        return this.auk;
    }

    public int zu() {
        return this.aul;
    }

    public q zv() {
        return this.aui;
    }
}
