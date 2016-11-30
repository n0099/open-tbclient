package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private String aDKillerUrl;
    private String akV;
    private String akW;
    private String akX;
    private String akY;
    private String akZ;
    private String ala;
    private String alb;
    private String alc;
    private int ald;
    private int ale;
    private long alf;
    private int alg;
    private String ali;
    private String alj;
    private String alk;
    private String alm;
    public int alo;
    public com.baidu.tieba.acrossForum.d alt;
    private String infoIconUrl;
    private String infoTargetUrl;
    private long infoTimeStamp;
    private long lastUpdateTime;
    private int alh = 0;
    private int aln = 2;
    public int alp = 0;
    public String alq = "";
    public String alr = "";
    private String als = "";

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akV = jSONObject.optString("drop_pic");
                this.akW = jSONObject.optString("drop_pic_md5");
                this.akX = jSONObject.optString("drop_pic_num");
                this.akY = jSONObject.optString("drop_bg_color_day");
                this.akZ = jSONObject.optString("drop_bg_color_night");
                this.ala = jSONObject.optString("apply_vip_live_room_pid");
                this.ali = jSONObject.optString("max_cache");
                this.alj = jSONObject.optString("frs_max_cache");
                this.alk = jSONObject.optString("frs_pn");
                this.alb = jSONObject.optString("tail_link");
                this.alc = jSONObject.optString("bubble_link");
                this.ald = jSONObject.optInt("xiaoying_time");
                this.lastUpdateTime = jSONObject.optLong("last_update_time", 0L);
                this.ale = jSONObject.optInt("new_resign", 0);
                this.alf = jSONObject.optLong("personalized_cache_seconds", 43200L);
                this.alg = jSONObject.optInt("personalized_max_count", 300);
                this.infoIconUrl = jSONObject.optString("info_icon_url");
                this.infoTimeStamp = jSONObject.optLong("info_time_stamp", 0L);
                this.infoTargetUrl = jSONObject.optString("info_target_url");
                this.alm = jSONObject.optString("show_ad_killer");
                this.aDKillerUrl = jSONObject.optString("adkiller_url");
                this.alh = jSONObject.optInt("read_thread_switch", 0);
                this.aln = jSONObject.optInt("localvideo_open", 2);
                this.alo = jSONObject.optInt("card_show_statistic", 200);
                this.als = jSONObject.optString("clean_smart_frs_cookie");
                com.baidu.tbadk.pageStayDuration.e.FP().fc(jSONObject.optInt("statlog_path_max", 3));
                if (jSONObject.has("wefans")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("wefans");
                    this.alp = optJSONObject.optInt("switch", 0);
                    this.alq = optJSONObject.optString("tabName", "");
                    this.alr = optJSONObject.optString("url", "");
                }
                if (jSONObject.has("baba_skin_android_url")) {
                    this.alt = new com.baidu.tieba.acrossForum.d();
                    this.alt.aVK = jSONObject.optString("baba_skin_android_url");
                    this.alt.aVL = jSONObject.optString("baba_skin_props_id");
                    this.alt.aVM = jSONObject.optString("baba_skin_show_start");
                    this.alt.aVN = jSONObject.optString("baba_skin_show_end");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String yf() {
        return this.ala;
    }

    public String yg() {
        return this.akV;
    }

    public String yh() {
        return this.akW;
    }

    public String yi() {
        return this.akX;
    }

    public String yj() {
        return this.akY;
    }

    public String yk() {
        return this.akZ;
    }

    public String yl() {
        return this.ali;
    }

    public String ym() {
        return this.alj;
    }

    public String yn() {
        return this.alk;
    }

    public String yo() {
        return this.alb;
    }

    public String yp() {
        return this.alc;
    }

    public int yq() {
        return this.ald;
    }

    public long yr() {
        return this.lastUpdateTime;
    }

    public long ys() {
        return this.alf;
    }

    public int yt() {
        return this.alg;
    }

    public int yu() {
        return this.ale;
    }

    public String yv() {
        return this.infoIconUrl;
    }

    public String yw() {
        return this.infoTargetUrl;
    }

    public long yx() {
        return this.infoTimeStamp;
    }

    public String yy() {
        return this.alm;
    }

    public String getaDKillerUrl() {
        return this.aDKillerUrl;
    }

    public int yz() {
        return this.alh;
    }

    public int yA() {
        return this.alp;
    }

    public String yB() {
        return this.alq;
    }

    public String yC() {
        return this.alr;
    }

    public String yD() {
        return this.als;
    }

    public boolean yE() {
        return this.aln == 1;
    }
}
