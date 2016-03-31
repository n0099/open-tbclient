package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private String aDKillerUrl;
    private int akA;
    private long akB;
    private int akC;
    private String akE;
    private String akF;
    private String akG;
    private String akH;
    private String akr;
    private String aks;
    private String akt;
    private String aku;
    private String akv;
    private String akw;
    private String akx;
    private String aky;
    private int akz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int akD = 0;
    private int akI = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akr = jSONObject.optString("drop_pic");
                this.aks = jSONObject.optString("drop_pic_md5");
                this.akt = jSONObject.optString("drop_pic_num");
                this.aku = jSONObject.optString("drop_bg_color_day");
                this.akv = jSONObject.optString("drop_bg_color_night");
                this.akw = jSONObject.optString("apply_vip_live_room_pid");
                this.akE = jSONObject.optString("max_cache");
                this.akF = jSONObject.optString("frs_max_cache");
                this.akG = jSONObject.optString("frs_pn");
                this.akx = jSONObject.optString("tail_link");
                this.aky = jSONObject.optString("bubble_link");
                this.akz = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.akA = jSONObject.optInt("new_resign", 0);
                this.akB = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.akC = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.akH = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.akD = jSONObject.optInt("read_thread_switch", 0);
                this.akI = jSONObject.optInt("localvideo_open", 2);
                com.baidu.tbadk.pageStayDuration.e.Gr().fc(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yO() {
        return this.akw;
    }

    public String yP() {
        return this.akr;
    }

    public String yQ() {
        return this.aks;
    }

    public String yR() {
        return this.akt;
    }

    public String yS() {
        return this.aku;
    }

    public String yT() {
        return this.akv;
    }

    public String yU() {
        return this.akE;
    }

    public String yV() {
        return this.akF;
    }

    public String yW() {
        return this.akG;
    }

    public String yX() {
        return this.akx;
    }

    public String yY() {
        return this.aky;
    }

    public int yZ() {
        return this.akz;
    }

    public long za() {
        return this.lastUpdateTime;
    }

    public long zb() {
        return this.akB;
    }

    public int zc() {
        return this.akC;
    }

    public int zd() {
        return this.akA;
    }

    public String ze() {
        return this.infoIconUrl;
    }

    public String zf() {
        return this.infoTargetUrl;
    }

    public long zg() {
        return this.infoTimeStamp;
    }

    public String zh() {
        return this.akH;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int zi() {
        return this.akD;
    }

    public boolean zj() {
        return this.akI == 1;
    }
}
