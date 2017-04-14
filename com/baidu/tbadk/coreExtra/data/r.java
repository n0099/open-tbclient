package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String apA;
    private String apB;
    private String apC;
    private String apD;
    private String apE;
    private int apF;
    private int apG;
    private long apH;
    private int apI;
    private String apL;
    private String apM;
    private String apN;
    public int apP;
    private String apx;
    private String apy;
    private String apz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int apJ = 0;
    private int apK = 0;
    private int apO = 2;
    public int apQ = 0;
    public String apR = "";
    public String apS = "";
    private String apT = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.apx = jSONObject.optString("drop_pic");
                this.apy = jSONObject.optString("drop_pic_md5");
                this.apz = jSONObject.optString("drop_pic_num");
                this.apA = jSONObject.optString("drop_bg_color_day");
                this.apB = jSONObject.optString("drop_bg_color_night");
                this.apC = jSONObject.optString("apply_vip_live_room_pid");
                this.apL = jSONObject.optString("max_cache");
                this.apM = jSONObject.optString("frs_max_cache");
                this.apN = jSONObject.optString("frs_pn");
                this.apD = jSONObject.optString("tail_link");
                this.apE = jSONObject.optString("bubble_link");
                this.apF = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.apG = jSONObject.optInt("new_resign", 0);
                this.apH = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.apI = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.apJ = jSONObject.optInt("read_thread_switch", 0);
                this.apO = jSONObject.optInt("localvideo_open", 2);
                this.apP = jSONObject.optInt("card_show_statistic", 200);
                this.apT = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Gb().fa(jSONObject.optInt("statlog_path_max", 3));
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.apQ = optJSONObject.optInt("switch", 0);
                    this.apR = optJSONObject.optString("tabName", "");
                    this.apS = optJSONObject.optString("url", "");
                }
                this.apK = jSONObject.optInt("photo_cache_num", 30);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yJ() {
        return this.apC;
    }

    public String yK() {
        return this.apx;
    }

    public String yL() {
        return this.apy;
    }

    public String yM() {
        return this.apz;
    }

    public String yN() {
        return this.apA;
    }

    public String yO() {
        return this.apB;
    }

    public String yP() {
        return this.apL;
    }

    public String yQ() {
        return this.apM;
    }

    public String yR() {
        return this.apN;
    }

    public String yS() {
        return this.apD;
    }

    public String yT() {
        return this.apE;
    }

    public int yU() {
        return this.apF;
    }

    public long yV() {
        return this.lastUpdateTime;
    }

    public long yW() {
        return this.apH;
    }

    public int yX() {
        return this.apI;
    }

    public int yY() {
        return this.apG;
    }

    public String yZ() {
        return this.infoIconUrl;
    }

    public String za() {
        return this.infoTargetUrl;
    }

    public long zb() {
        return this.infoTimeStamp;
    }

    public int zc() {
        return this.apJ;
    }

    public int zd() {
        return this.apQ;
    }

    public String ze() {
        return this.apR;
    }

    public String zf() {
        return this.apS;
    }

    public String zg() {
        return this.apT;
    }

    public boolean zh() {
        return this.apO == 1;
    }

    public int zi() {
        return this.apK;
    }
}
