package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a activityPrizeData;
    private String atJ;
    private String atK;
    private String atL;
    private String atM;
    private String atN;
    private String atO;
    private String atP;
    private String atQ;
    private long atR;
    private int atS;
    private int atT;
    private long atU;
    private int atV;
    private String atX;
    private String atY;
    private String atZ;
    public int aub;
    private String aud;
    private String aue;
    private int auf;
    private long aug;
    private q auh;
    private String aui;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int atW = 0;
    private int aua = 2;
    private String auc = "";
    private int auj = 0;
    private int auk = 0;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.atJ = jSONObject.optString("drop_pic");
                this.atK = jSONObject.optString("drop_pic_md5");
                this.atL = jSONObject.optString("drop_pic_num");
                this.atM = jSONObject.optString("drop_bg_color_day");
                this.atN = jSONObject.optString("drop_bg_color_night");
                this.atO = jSONObject.optString("apply_vip_live_room_pid");
                this.atX = jSONObject.optString("max_cache");
                this.atY = jSONObject.optString("frs_max_cache");
                this.atZ = jSONObject.optString("frs_pn");
                this.atP = jSONObject.optString("tail_link");
                this.atQ = jSONObject.optString("bubble_link");
                this.atR = jSONObject.optLong("use_duration");
                this.atS = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.aue = jSONObject.optString("url_analyze_text");
                this.atT = jSONObject.optInt("new_resign", 0);
                this.atU = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.atV = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.aua = jSONObject.optInt("localvideo_open", 2);
                this.aub = jSONObject.optInt("card_show_statistic", 200);
                this.auc = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Gt().fe(jSONObject.optInt("statlog_path_max", 3));
                this.atW = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.aud = jSONObject.optString("nickname_activity_link");
                this.auf = jSONObject.optInt("android_tab_show", 7);
                this.aug = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("nani_video");
                if (optJSONObject2 != null) {
                    this.auh = new q();
                    this.auh.parse(optJSONObject2);
                }
                com.baidu.tieba.im.db.n.nt(jSONObject.optInt("android_max_stranger"));
                this.auj = jSONObject.optInt("style_ab_switch", 0);
                this.auk = jSONObject.optInt("abstract_ab_switch", 0);
                this.aui = jSONObject.optString("android_splash_video");
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_video_splash_config", this.aui);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yT() {
        return this.atO;
    }

    public String yU() {
        return this.atJ;
    }

    public String yV() {
        return this.atK;
    }

    public String yW() {
        return this.atL;
    }

    public String yX() {
        return this.atM;
    }

    public String yY() {
        return this.atN;
    }

    public String yZ() {
        return this.atX;
    }

    public String za() {
        return this.atY;
    }

    public String zb() {
        return this.atZ;
    }

    public String zc() {
        return this.atP;
    }

    public String zd() {
        return this.atQ;
    }

    public long ze() {
        return this.atR;
    }

    public int zf() {
        return this.atS;
    }

    public long zg() {
        return this.lastUpdateTime;
    }

    public int zh() {
        return this.auf;
    }

    public long zi() {
        return this.atU;
    }

    public int zj() {
        return this.atV;
    }

    public int zk() {
        return this.atT;
    }

    public String zl() {
        return this.infoIconUrl;
    }

    public String zm() {
        return this.infoTargetUrl;
    }

    public long zn() {
        return this.infoTimeStamp;
    }

    public String zo() {
        return this.auc;
    }

    public boolean zp() {
        return this.aua == 1;
    }

    public int zq() {
        return this.atW;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String zr() {
        return this.aud;
    }

    public String zs() {
        return this.aue;
    }

    public long zt() {
        return this.aug;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }

    public int zu() {
        return this.auj;
    }

    public int zv() {
        return this.auk;
    }

    public q zw() {
        return this.auh;
    }
}
