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
                com.baidu.tbadk.pageStayDuration.e.Ek().eH(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wI() {
        return this.agj;
    }

    public String wJ() {
        return this.agd;
    }

    public String wK() {
        return this.agf;
    }

    public String wL() {
        return this.agg;
    }

    public String wM() {
        return this.agh;
    }

    public String wN() {
        return this.agi;
    }

    public String wO() {
        return this.agr;
    }

    public String wP() {
        return this.ags;
    }

    public String wQ() {
        return this.agt;
    }

    public String wR() {
        return this.agk;
    }

    public String wS() {
        return this.agl;
    }

    public int wT() {
        return this.agm;
    }

    public long wU() {
        return this.lastUpdateTime;
    }

    public long wV() {
        return this.ago;
    }

    public int wW() {
        return this.agp;
    }

    public int wX() {
        return this.agn;
    }

    public String wY() {
        return this.infoIconUrl;
    }

    public String wZ() {
        return this.infoTargetUrl;
    }

    public long xa() {
        return this.infoTimeStamp;
    }

    public String xb() {
        return this.agu;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int xc() {
        return this.agq;
    }

    public boolean xd() {
        return this.agv == 1;
    }
}
