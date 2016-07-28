package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private String aDKillerUrl;
    private String ahA;
    private String ahB;
    private String ahC;
    private String ahD;
    private int ahE;
    private int ahF;
    private long ahG;
    private int ahH;
    private String ahJ;
    private String ahK;
    private String ahL;
    private String ahM;
    public int ahO;
    private String ahw;
    private String ahx;
    private String ahy;
    private String ahz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int ahI = 0;
    private int ahN = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ahw = jSONObject.optString("drop_pic");
                this.ahx = jSONObject.optString("drop_pic_md5");
                this.ahy = jSONObject.optString("drop_pic_num");
                this.ahz = jSONObject.optString("drop_bg_color_day");
                this.ahA = jSONObject.optString("drop_bg_color_night");
                this.ahB = jSONObject.optString("apply_vip_live_room_pid");
                this.ahJ = jSONObject.optString("max_cache");
                this.ahK = jSONObject.optString("frs_max_cache");
                this.ahL = jSONObject.optString("frs_pn");
                this.ahC = jSONObject.optString("tail_link");
                this.ahD = jSONObject.optString("bubble_link");
                this.ahE = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ahF = jSONObject.optInt("new_resign", 0);
                this.ahG = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.ahH = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ahM = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.ahI = jSONObject.optInt("read_thread_switch", 0);
                this.ahN = jSONObject.optInt("localvideo_open", 2);
                this.ahO = jSONObject.optInt("card_show_statistic", 200);
                com.baidu.tbadk.pageStayDuration.e.Es().eM(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wM() {
        return this.ahB;
    }

    public String wN() {
        return this.ahw;
    }

    public String wO() {
        return this.ahx;
    }

    public String wP() {
        return this.ahy;
    }

    public String wQ() {
        return this.ahz;
    }

    public String wR() {
        return this.ahA;
    }

    public String wS() {
        return this.ahJ;
    }

    public String wT() {
        return this.ahK;
    }

    public String wU() {
        return this.ahL;
    }

    public String wV() {
        return this.ahC;
    }

    public String wW() {
        return this.ahD;
    }

    public int wX() {
        return this.ahE;
    }

    public long wY() {
        return this.lastUpdateTime;
    }

    public long wZ() {
        return this.ahG;
    }

    public int xa() {
        return this.ahH;
    }

    public int xb() {
        return this.ahF;
    }

    public String xc() {
        return this.infoIconUrl;
    }

    public String xd() {
        return this.infoTargetUrl;
    }

    public long xe() {
        return this.infoTimeStamp;
    }

    public String xf() {
        return this.ahM;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int xg() {
        return this.ahI;
    }

    public boolean xh() {
        return this.ahN == 1;
    }
}
