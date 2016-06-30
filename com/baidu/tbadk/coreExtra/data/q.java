package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private String aDKillerUrl;
    private String agI;
    private String agJ;
    private String agK;
    private String agL;
    private String agM;
    private String agN;
    private String agO;
    private String agP;
    private int agQ;
    private int agR;
    private long agS;
    private int agT;
    private String agV;
    private String agW;
    private String agX;
    private String agY;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int agU = 0;
    private int agZ = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agI = jSONObject.optString("drop_pic");
                this.agJ = jSONObject.optString("drop_pic_md5");
                this.agK = jSONObject.optString("drop_pic_num");
                this.agL = jSONObject.optString("drop_bg_color_day");
                this.agM = jSONObject.optString("drop_bg_color_night");
                this.agN = jSONObject.optString("apply_vip_live_room_pid");
                this.agV = jSONObject.optString("max_cache");
                this.agW = jSONObject.optString("frs_max_cache");
                this.agX = jSONObject.optString("frs_pn");
                this.agO = jSONObject.optString("tail_link");
                this.agP = jSONObject.optString("bubble_link");
                this.agQ = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.agR = jSONObject.optInt("new_resign", 0);
                this.agS = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.agT = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.agY = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.agU = jSONObject.optInt("read_thread_switch", 0);
                this.agZ = jSONObject.optInt("localvideo_open", 2);
                com.baidu.tbadk.pageStayDuration.e.Et().eM(jSONObject.optInt("statlog_path_max", 3));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String wM() {
        return this.agN;
    }

    public String wN() {
        return this.agI;
    }

    public String wO() {
        return this.agJ;
    }

    public String wP() {
        return this.agK;
    }

    public String wQ() {
        return this.agL;
    }

    public String wR() {
        return this.agM;
    }

    public String wS() {
        return this.agV;
    }

    public String wT() {
        return this.agW;
    }

    public String wU() {
        return this.agX;
    }

    public String wV() {
        return this.agO;
    }

    public String wW() {
        return this.agP;
    }

    public int wX() {
        return this.agQ;
    }

    public long wY() {
        return this.lastUpdateTime;
    }

    public long wZ() {
        return this.agS;
    }

    public int xa() {
        return this.agT;
    }

    public int xb() {
        return this.agR;
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
        return this.agY;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int xg() {
        return this.agU;
    }

    public boolean xh() {
        return this.agZ == 1;
    }
}
