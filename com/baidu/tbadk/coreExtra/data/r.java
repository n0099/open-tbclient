package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String apC;
    private String apD;
    private String apE;
    private String apF;
    private String apG;
    private String apH;
    private String apI;
    private String apJ;
    private int apK;
    private int apL;
    private long apM;
    private int apN;
    private String apQ;
    private String apR;
    private String apS;
    public int apU;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int apO = 0;
    private int apP = 0;
    private int apT = 2;
    private String apV = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.apC = jSONObject.optString("drop_pic");
                this.apD = jSONObject.optString("drop_pic_md5");
                this.apE = jSONObject.optString("drop_pic_num");
                this.apF = jSONObject.optString("drop_bg_color_day");
                this.apG = jSONObject.optString("drop_bg_color_night");
                this.apH = jSONObject.optString("apply_vip_live_room_pid");
                this.apQ = jSONObject.optString("max_cache");
                this.apR = jSONObject.optString("frs_max_cache");
                this.apS = jSONObject.optString("frs_pn");
                this.apI = jSONObject.optString("tail_link");
                this.apJ = jSONObject.optString("bubble_link");
                this.apK = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.apL = jSONObject.optInt("new_resign", 0);
                this.apM = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.apN = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.apO = jSONObject.optInt("read_thread_switch", 0);
                this.apT = jSONObject.optInt("localvideo_open", 2);
                this.apU = jSONObject.optInt("card_show_statistic", 200);
                this.apV = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Ff().eW(jSONObject.optInt("statlog_path_max", 3));
                this.apP = jSONObject.optInt("photo_cache_num", 30);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xX() {
        return this.apH;
    }

    public String xY() {
        return this.apC;
    }

    public String xZ() {
        return this.apD;
    }

    public String ya() {
        return this.apE;
    }

    public String yb() {
        return this.apF;
    }

    public String yc() {
        return this.apG;
    }

    public String yd() {
        return this.apQ;
    }

    public String ye() {
        return this.apR;
    }

    public String yf() {
        return this.apS;
    }

    public String yg() {
        return this.apI;
    }

    public String yh() {
        return this.apJ;
    }

    public int yi() {
        return this.apK;
    }

    public long yj() {
        return this.lastUpdateTime;
    }

    public long yk() {
        return this.apM;
    }

    public int yl() {
        return this.apN;
    }

    public int ym() {
        return this.apL;
    }

    public String yn() {
        return this.infoIconUrl;
    }

    public String yo() {
        return this.infoTargetUrl;
    }

    public long yp() {
        return this.infoTimeStamp;
    }

    public int yq() {
        return this.apO;
    }

    public String yr() {
        return this.apV;
    }

    public boolean ys() {
        return this.apT == 1;
    }

    public int yt() {
        return this.apP;
    }
}
