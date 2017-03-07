package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String aph;
    private String api;
    private String apj;
    private String apk;
    private String apl;
    private String apm;
    private String apn;
    private String apo;
    private int apq;
    private int apr;
    private long aps;
    private int apt;
    private String apv;
    private String apw;
    private String apx;
    public int apz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int apu = 0;
    private int apy = 2;
    public int apA = 0;
    public String apB = "";
    public String apC = "";
    private String apD = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aph = jSONObject.optString("drop_pic");
                this.api = jSONObject.optString("drop_pic_md5");
                this.apj = jSONObject.optString("drop_pic_num");
                this.apk = jSONObject.optString("drop_bg_color_day");
                this.apl = jSONObject.optString("drop_bg_color_night");
                this.apm = jSONObject.optString("apply_vip_live_room_pid");
                this.apv = jSONObject.optString("max_cache");
                this.apw = jSONObject.optString("frs_max_cache");
                this.apx = jSONObject.optString("frs_pn");
                this.apn = jSONObject.optString("tail_link");
                this.apo = jSONObject.optString("bubble_link");
                this.apq = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.apr = jSONObject.optInt("new_resign", 0);
                this.aps = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.apt = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.apu = jSONObject.optInt("read_thread_switch", 0);
                this.apy = jSONObject.optInt("localvideo_open", 2);
                this.apz = jSONObject.optInt("card_show_statistic", 200);
                this.apD = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FD().eX(jSONObject.optInt("statlog_path_max", 3));
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.apA = optJSONObject.optInt("switch", 0);
                    this.apB = optJSONObject.optString("tabName", "");
                    this.apC = optJSONObject.optString("url", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yl() {
        return this.apm;
    }

    public String ym() {
        return this.aph;
    }

    public String yn() {
        return this.api;
    }

    public String yo() {
        return this.apj;
    }

    public String yp() {
        return this.apk;
    }

    public String yq() {
        return this.apl;
    }

    public String yr() {
        return this.apv;
    }

    public String ys() {
        return this.apw;
    }

    public String yt() {
        return this.apx;
    }

    public String yu() {
        return this.apn;
    }

    public String yv() {
        return this.apo;
    }

    public int yw() {
        return this.apq;
    }

    public long yx() {
        return this.lastUpdateTime;
    }

    public long yy() {
        return this.aps;
    }

    public int yz() {
        return this.apt;
    }

    public int yA() {
        return this.apr;
    }

    public String yB() {
        return this.infoIconUrl;
    }

    public String yC() {
        return this.infoTargetUrl;
    }

    public long yD() {
        return this.infoTimeStamp;
    }

    public int yE() {
        return this.apu;
    }

    public int yF() {
        return this.apA;
    }

    public String yG() {
        return this.apB;
    }

    public String yH() {
        return this.apC;
    }

    public String yI() {
        return this.apD;
    }

    public boolean yJ() {
        return this.apy == 1;
    }
}
