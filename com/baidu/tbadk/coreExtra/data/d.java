package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String aEA;
    private int aEx;
    private long aEy;
    private long aEz;
    private int aEu = 1;
    private int aEw = 0;
    private int aEB = 0;
    private int aEC = 1;
    private int aED = 0;
    private int aEE = 0;
    private int aEF = 300;
    private int aEG = 1;
    public int aEH = 4;
    public int aEI = 4;
    public int aEJ = 7;
    private f aEv = new f();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aEu = jSONObject.optInt("als_control", 1);
            this.aEw = jSONObject.optInt("not_use_lego_patch", 0);
            this.aEC = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aEE = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aEv.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aEx = optJSONObject.optInt("log_feed_switch", 0);
                this.aEy = optJSONObject.optLong("start_time", -1L);
                this.aEz = optJSONObject.optLong("end_time", -1L);
                this.aEA = optJSONObject.optString("ext_info");
            }
            this.aEB = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aEF = optJSONObject2.optInt("interval", 300);
            }
            this.aEG = jSONObject.optInt("video_page_style", 1);
            this.aED = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aEH = optJSONObject3.optInt("first_floor");
                this.aEI = optJSONObject3.optInt("prefetch_step");
                this.aEJ = optJSONObject3.optInt("step");
            }
        }
    }

    public f CY() {
        return this.aEv;
    }

    public boolean CZ() {
        return this.aEu > 0;
    }

    public boolean Da() {
        if (this.aEx == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aEy < currentTimeMillis && currentTimeMillis < this.aEz;
        }
        return false;
    }

    public boolean Db() {
        return this.aEC == 1;
    }

    public boolean Dc() {
        return this.aEE == 1;
    }

    public String Dd() {
        return this.aEA;
    }

    public boolean De() {
        return this.aEB == 1;
    }

    public int Df() {
        return this.aEF;
    }

    public int Dg() {
        return this.aEG;
    }

    public boolean Dh() {
        return this.aED == 0;
    }
}
