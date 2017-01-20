package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String ajK;
    private String ajL;
    private String ajM;
    private String ajN;
    private String ajO;
    private String ajP;
    private String ajQ;
    private String ajR;
    private int ajS;
    private int ajT;
    private long ajU;
    private int ajV;
    private String ajX;
    private String ajY;
    private String ajZ;
    public int akb;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int ajW = 0;
    private int aka = 2;
    public int akc = 0;
    public String akd = "";
    public String ake = "";
    private String akf = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ajK = jSONObject.optString("drop_pic");
                this.ajL = jSONObject.optString("drop_pic_md5");
                this.ajM = jSONObject.optString("drop_pic_num");
                this.ajN = jSONObject.optString("drop_bg_color_day");
                this.ajO = jSONObject.optString("drop_bg_color_night");
                this.ajP = jSONObject.optString("apply_vip_live_room_pid");
                this.ajX = jSONObject.optString("max_cache");
                this.ajY = jSONObject.optString("frs_max_cache");
                this.ajZ = jSONObject.optString("frs_pn");
                this.ajQ = jSONObject.optString("tail_link");
                this.ajR = jSONObject.optString("bubble_link");
                this.ajS = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ajT = jSONObject.optInt("new_resign", 0);
                this.ajU = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.ajV = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.ajW = jSONObject.optInt("read_thread_switch", 0);
                this.aka = jSONObject.optInt("localvideo_open", 2);
                this.akb = jSONObject.optInt("card_show_statistic", 200);
                this.akf = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Fj().fd(jSONObject.optInt("statlog_path_max", 3));
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.akc = optJSONObject.optInt("switch", 0);
                    this.akd = optJSONObject.optString("tabName", "");
                    this.ake = optJSONObject.optString("url", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xP() {
        return this.ajP;
    }

    public String xQ() {
        return this.ajK;
    }

    public String xR() {
        return this.ajL;
    }

    public String xS() {
        return this.ajM;
    }

    public String xT() {
        return this.ajN;
    }

    public String xU() {
        return this.ajO;
    }

    public String xV() {
        return this.ajX;
    }

    public String xW() {
        return this.ajY;
    }

    public String xX() {
        return this.ajZ;
    }

    public String xY() {
        return this.ajQ;
    }

    public String xZ() {
        return this.ajR;
    }

    public int ya() {
        return this.ajS;
    }

    public long yb() {
        return this.lastUpdateTime;
    }

    public long yc() {
        return this.ajU;
    }

    public int yd() {
        return this.ajV;
    }

    public int ye() {
        return this.ajT;
    }

    public String yf() {
        return this.infoIconUrl;
    }

    public String yg() {
        return this.infoTargetUrl;
    }

    public long yh() {
        return this.infoTimeStamp;
    }

    public int yi() {
        return this.ajW;
    }

    public int yj() {
        return this.akc;
    }

    public String yk() {
        return this.akd;
    }

    public String yl() {
        return this.ake;
    }

    public String ym() {
        return this.akf;
    }

    public boolean yn() {
        return this.aka == 1;
    }
}
