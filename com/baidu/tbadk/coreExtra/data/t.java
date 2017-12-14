package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a activityPrizeData;
    private String arO;
    private String arP;
    private String arQ;
    private String arR;
    private String arS;
    private String arT;
    private String arU;
    private String arV;
    private long arW;
    private int arX;
    private int arY;
    private long arZ;
    private int asa;
    private String asc;
    private String asd;
    private String ase;
    public int asg;
    private String asi;
    private String asj;
    private int ask;
    private long asl;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int asb = 0;
    private int asf = 2;
    private String ash = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arO = jSONObject.optString("drop_pic");
                this.arP = jSONObject.optString("drop_pic_md5");
                this.arQ = jSONObject.optString("drop_pic_num");
                this.arR = jSONObject.optString("drop_bg_color_day");
                this.arS = jSONObject.optString("drop_bg_color_night");
                this.arT = jSONObject.optString("apply_vip_live_room_pid");
                this.asc = jSONObject.optString("max_cache");
                this.asd = jSONObject.optString("frs_max_cache");
                this.ase = jSONObject.optString("frs_pn");
                this.arU = jSONObject.optString("tail_link");
                this.arV = jSONObject.optString("bubble_link");
                this.arW = jSONObject.optLong("use_duration");
                this.arX = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.asj = jSONObject.optString("url_analyze_text");
                this.arY = jSONObject.optInt("new_resign", 0);
                this.arZ = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asa = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asf = jSONObject.optInt("localvideo_open", 2);
                this.asg = jSONObject.optInt("card_show_statistic", 200);
                this.ash = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FW().fn(jSONObject.optInt("statlog_path_max", 3));
                this.asb = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asi = jSONObject.optString("nickname_activity_link");
                this.ask = jSONObject.optInt("android_tab_show", 7);
                this.asl = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                com.baidu.tieba.im.db.m.nj(jSONObject.optInt("android_max_stranger"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String ym() {
        return this.arT;
    }

    public String yn() {
        return this.arO;
    }

    public String yo() {
        return this.arP;
    }

    public String yp() {
        return this.arQ;
    }

    public String yq() {
        return this.arR;
    }

    public String yr() {
        return this.arS;
    }

    public String ys() {
        return this.asc;
    }

    public String yt() {
        return this.asd;
    }

    public String yu() {
        return this.ase;
    }

    public String yv() {
        return this.arU;
    }

    public String yw() {
        return this.arV;
    }

    public long yx() {
        return this.arW;
    }

    public int yy() {
        return this.arX;
    }

    public long yz() {
        return this.lastUpdateTime;
    }

    public int yA() {
        return this.ask;
    }

    public long yB() {
        return this.arZ;
    }

    public int yC() {
        return this.asa;
    }

    public int yD() {
        return this.arY;
    }

    public String yE() {
        return this.infoIconUrl;
    }

    public String yF() {
        return this.infoTargetUrl;
    }

    public long yG() {
        return this.infoTimeStamp;
    }

    public String yH() {
        return this.ash;
    }

    public boolean yI() {
        return this.asf == 1;
    }

    public int yJ() {
        return this.asb;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yK() {
        return this.asi;
    }

    public String yL() {
        return this.asj;
    }

    public long yM() {
        return this.asl;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }
}
