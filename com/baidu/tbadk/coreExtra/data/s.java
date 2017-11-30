package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private a activityPrizeData;
    private String arJ;
    private String arK;
    private String arL;
    private String arM;
    private String arN;
    private String arO;
    private String arP;
    private String arQ;
    private long arR;
    private int arS;
    private int arT;
    private long arU;
    private int arV;
    private String arX;
    private String arY;
    private String arZ;
    public int asb;
    private String asd;
    private String ase;
    private int asf;
    private long asg;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int arW = 0;
    private int asa = 2;
    private String asc = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arJ = jSONObject.optString("drop_pic");
                this.arK = jSONObject.optString("drop_pic_md5");
                this.arL = jSONObject.optString("drop_pic_num");
                this.arM = jSONObject.optString("drop_bg_color_day");
                this.arN = jSONObject.optString("drop_bg_color_night");
                this.arO = jSONObject.optString("apply_vip_live_room_pid");
                this.arX = jSONObject.optString("max_cache");
                this.arY = jSONObject.optString("frs_max_cache");
                this.arZ = jSONObject.optString("frs_pn");
                this.arP = jSONObject.optString("tail_link");
                this.arQ = jSONObject.optString("bubble_link");
                this.arR = jSONObject.optLong("use_duration");
                this.arS = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ase = jSONObject.optString("url_analyze_text");
                this.arT = jSONObject.optInt("new_resign", 0);
                this.arU = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.arV = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asa = jSONObject.optInt("localvideo_open", 2);
                this.asb = jSONObject.optInt("card_show_statistic", 200);
                this.asc = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FV().fn(jSONObject.optInt("statlog_path_max", 3));
                this.arW = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asd = jSONObject.optString("nickname_activity_link");
                this.asf = jSONObject.optInt("android_tab_show", 7);
                this.asg = jSONObject.optLong("android_new_log_upload_interval", 0L);
                JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
                if (optJSONObject != null) {
                    this.activityPrizeData = new a();
                    this.activityPrizeData.parse(optJSONObject);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
                }
                com.baidu.tieba.im.db.m.nc(jSONObject.optInt("android_max_stranger"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yl() {
        return this.arO;
    }

    public String ym() {
        return this.arJ;
    }

    public String yn() {
        return this.arK;
    }

    public String yo() {
        return this.arL;
    }

    public String yp() {
        return this.arM;
    }

    public String yq() {
        return this.arN;
    }

    public String yr() {
        return this.arX;
    }

    public String ys() {
        return this.arY;
    }

    public String yt() {
        return this.arZ;
    }

    public String yu() {
        return this.arP;
    }

    public String yv() {
        return this.arQ;
    }

    public long yw() {
        return this.arR;
    }

    public int yx() {
        return this.arS;
    }

    public long yy() {
        return this.lastUpdateTime;
    }

    public int yz() {
        return this.asf;
    }

    public long yA() {
        return this.arU;
    }

    public int yB() {
        return this.arV;
    }

    public int yC() {
        return this.arT;
    }

    public String yD() {
        return this.infoIconUrl;
    }

    public String yE() {
        return this.infoTargetUrl;
    }

    public long yF() {
        return this.infoTimeStamp;
    }

    public String yG() {
        return this.asc;
    }

    public boolean yH() {
        return this.asa == 1;
    }

    public int yI() {
        return this.arW;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yJ() {
        return this.asd;
    }

    public String yK() {
        return this.ase;
    }

    public long yL() {
        return this.asg;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }
}
