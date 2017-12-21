package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a activityPrizeData;
    private String arR;
    private String arS;
    private String arT;
    private String arU;
    private String arV;
    private String arW;
    private String arX;
    private String arY;
    private long arZ;
    private int asa;
    private int asb;
    private long asc;
    private int asd;
    private String asf;
    private String asg;
    private String ash;
    public int asj;
    private String asl;
    private String asm;
    private int asn;
    private long aso;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private String uegVoiceWarning;
    private int ase = 0;
    private int asi = 2;
    private String ask = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arR = jSONObject.optString("drop_pic");
                this.arS = jSONObject.optString("drop_pic_md5");
                this.arT = jSONObject.optString("drop_pic_num");
                this.arU = jSONObject.optString("drop_bg_color_day");
                this.arV = jSONObject.optString("drop_bg_color_night");
                this.arW = jSONObject.optString("apply_vip_live_room_pid");
                this.asf = jSONObject.optString("max_cache");
                this.asg = jSONObject.optString("frs_max_cache");
                this.ash = jSONObject.optString("frs_pn");
                this.arX = jSONObject.optString("tail_link");
                this.arY = jSONObject.optString("bubble_link");
                this.arZ = jSONObject.optLong("use_duration");
                this.asa = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.asm = jSONObject.optString("url_analyze_text");
                this.asb = jSONObject.optInt("new_resign", 0);
                this.asc = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.asd = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.asi = jSONObject.optInt("localvideo_open", 2);
                this.asj = jSONObject.optInt("card_show_statistic", 200);
                this.ask = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FW().fn(jSONObject.optInt("statlog_path_max", 3));
                this.ase = jSONObject.optInt("photo_cache_num", 30);
                this.uegVoiceWarning = jSONObject.optString("ueg_voice_warning");
                this.asl = jSONObject.optString("nickname_activity_link");
                this.asn = jSONObject.optInt("android_tab_show", 7);
                this.aso = jSONObject.optLong("android_new_log_upload_interval", 0L);
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
        return this.arW;
    }

    public String yn() {
        return this.arR;
    }

    public String yo() {
        return this.arS;
    }

    public String yp() {
        return this.arT;
    }

    public String yq() {
        return this.arU;
    }

    public String yr() {
        return this.arV;
    }

    public String ys() {
        return this.asf;
    }

    public String yt() {
        return this.asg;
    }

    public String yu() {
        return this.ash;
    }

    public String yv() {
        return this.arX;
    }

    public String yw() {
        return this.arY;
    }

    public long yx() {
        return this.arZ;
    }

    public int yy() {
        return this.asa;
    }

    public long yz() {
        return this.lastUpdateTime;
    }

    public int yA() {
        return this.asn;
    }

    public long yB() {
        return this.asc;
    }

    public int yC() {
        return this.asd;
    }

    public int yD() {
        return this.asb;
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
        return this.ask;
    }

    public boolean yI() {
        return this.asi == 1;
    }

    public int yJ() {
        return this.ase;
    }

    public String getUegVoiceWarning() {
        return this.uegVoiceWarning;
    }

    public String yK() {
        return this.asl;
    }

    public String yL() {
        return this.asm;
    }

    public long yM() {
        return this.aso;
    }

    public a getActivityPrizeData() {
        return this.activityPrizeData;
    }
}
