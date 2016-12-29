package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String aDKillerUrl;
    private String akA;
    private String akB;
    private String akC;
    private String akD;
    private String akE;
    private int akF;
    private int akG;
    private long akH;
    private int akI;
    private String akK;
    private String akL;
    private String akM;
    private String akN;
    public int akP;
    public com.baidu.tieba.acrossForum.d akU;
    private String akx;
    private String aky;
    private String akz;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int akJ = 0;
    private int akO = 2;
    public int akQ = 0;
    public String akR = "";
    public String akS = "";
    private String akT = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akx = jSONObject.optString("drop_pic");
                this.aky = jSONObject.optString("drop_pic_md5");
                this.akz = jSONObject.optString("drop_pic_num");
                this.akA = jSONObject.optString("drop_bg_color_day");
                this.akB = jSONObject.optString("drop_bg_color_night");
                this.akC = jSONObject.optString("apply_vip_live_room_pid");
                this.akK = jSONObject.optString("max_cache");
                this.akL = jSONObject.optString("frs_max_cache");
                this.akM = jSONObject.optString("frs_pn");
                this.akD = jSONObject.optString("tail_link");
                this.akE = jSONObject.optString("bubble_link");
                this.akF = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.akG = jSONObject.optInt("new_resign", 0);
                this.akH = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.akI = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.akN = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.akJ = jSONObject.optInt("read_thread_switch", 0);
                this.akO = jSONObject.optInt("localvideo_open", 2);
                this.akP = jSONObject.optInt("card_show_statistic", 200);
                this.akT = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.Fp().fc(jSONObject.optInt("statlog_path_max", 3));
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.akQ = optJSONObject.optInt("switch", 0);
                    this.akR = optJSONObject.optString("tabName", "");
                    this.akS = optJSONObject.optString("url", "");
                }
                if (jSONObject.has("baba_skin_android_url")) {
                    this.akU = new com.baidu.tieba.acrossForum.d();
                    this.akU.aVb = jSONObject.optString("baba_skin_android_url");
                    this.akU.aVc = jSONObject.optString("baba_skin_props_id");
                    this.akU.aVd = jSONObject.optString("baba_skin_show_start");
                    this.akU.aVe = jSONObject.optString("baba_skin_show_end");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String xT() {
        return this.akC;
    }

    public String xU() {
        return this.akx;
    }

    public String xV() {
        return this.aky;
    }

    public String xW() {
        return this.akz;
    }

    public String xX() {
        return this.akA;
    }

    public String xY() {
        return this.akB;
    }

    public String xZ() {
        return this.akK;
    }

    public String ya() {
        return this.akL;
    }

    public String yb() {
        return this.akM;
    }

    public String yc() {
        return this.akD;
    }

    public String yd() {
        return this.akE;
    }

    public int ye() {
        return this.akF;
    }

    public long yf() {
        return this.lastUpdateTime;
    }

    public long yg() {
        return this.akH;
    }

    public int yh() {
        return this.akI;
    }

    public int yi() {
        return this.akG;
    }

    public String yj() {
        return this.infoIconUrl;
    }

    public String yk() {
        return this.infoTargetUrl;
    }

    public long yl() {
        return this.infoTimeStamp;
    }

    public String ym() {
        return this.akN;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int yn() {
        return this.akJ;
    }

    public int yo() {
        return this.akQ;
    }

    public String yp() {
        return this.akR;
    }

    public String yq() {
        return this.akS;
    }

    public String yr() {
        return this.akT;
    }

    public boolean ys() {
        return this.akO == 1;
    }
}
