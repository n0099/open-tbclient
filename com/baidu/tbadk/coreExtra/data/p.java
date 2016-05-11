package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private String aDKillerUrl;
    private String agd;
    private String agf;
    private String agg;
    private String agh;
    private String agi;
    private String agj;
    private String agk;
    private String agl;
    private int agm;
    private int agn;
    private long ago;
    private int agp;
    private String agr;
    private String ags;
    private String agt;
    private String agu;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int agq = 0;
    private int agv = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agd = jSONObject.optString("drop_pic");
                this.agf = jSONObject.optString("drop_pic_md5");
                this.agg = jSONObject.optString("drop_pic_num");
                this.agh = jSONObject.optString("drop_bg_color_day");
                this.agi = jSONObject.optString("drop_bg_color_night");
                this.agj = jSONObject.optString("apply_vip_live_room_pid");
                this.agr = jSONObject.optString("max_cache");
                this.ags = jSONObject.optString("frs_max_cache");
                this.agt = jSONObject.optString("frs_pn");
                this.agk = jSONObject.optString("tail_link");
                this.agl = jSONObject.optString("bubble_link");
                this.agm = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.agn = jSONObject.optInt("new_resign", 0);
                this.ago = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.agp = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.agu = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.agq = jSONObject.optInt("read_thread_switch", 0);
                this.agv = jSONObject.optInt("localvideo_open", 2);
                com.baidu.tbadk.pageStayDuration.e.Ej().eI(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wH() {
        return this.agj;
    }

    public String wI() {
        return this.agd;
    }

    public String wJ() {
        return this.agf;
    }

    public String wK() {
        return this.agg;
    }

    public String wL() {
        return this.agh;
    }

    public String wM() {
        return this.agi;
    }

    public String wN() {
        return this.agr;
    }

    public String wO() {
        return this.ags;
    }

    public String wP() {
        return this.agt;
    }

    public String wQ() {
        return this.agk;
    }

    public String wR() {
        return this.agl;
    }

    public int wS() {
        return this.agm;
    }

    public long wT() {
        return this.lastUpdateTime;
    }

    public long wU() {
        return this.ago;
    }

    public int wV() {
        return this.agp;
    }

    public int wW() {
        return this.agn;
    }

    public String wX() {
        return this.infoIconUrl;
    }

    public String wY() {
        return this.infoTargetUrl;
    }

    public long wZ() {
        return this.infoTimeStamp;
    }

    public String xa() {
        return this.agu;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int xb() {
        return this.agq;
    }

    public boolean xc() {
        return this.agv == 1;
    }
}
