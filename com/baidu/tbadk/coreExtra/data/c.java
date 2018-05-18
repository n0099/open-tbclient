package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int asB;
    private long asC;
    private long asD;
    private String asE;
    private int asy = 1;
    private int asA = 0;
    private int asF = 0;
    private int asG = 1;
    private int asH = 0;
    private int asI = 0;
    private int asJ = 300;
    private int asK = 1;
    public int asL = 4;
    public int asM = 4;
    public int asN = 7;
    private e asz = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.asy = jSONObject.optInt("als_control", 1);
            this.asA = jSONObject.optInt("not_use_lego_patch", 0);
            this.asG = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.asI = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.asz.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.asB = optJSONObject.optInt("log_feed_switch", 0);
                this.asC = optJSONObject.optLong("start_time", -1L);
                this.asD = optJSONObject.optLong("end_time", -1L);
                this.asE = optJSONObject.optString("ext_info");
            }
            this.asF = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.asJ = optJSONObject2.optInt("interval", 300);
            }
            this.asK = jSONObject.optInt("video_page_style", 1);
            this.asH = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.asL = optJSONObject3.optInt("first_floor");
                this.asM = optJSONObject3.optInt("prefetch_step");
                this.asN = optJSONObject3.optInt("step");
            }
        }
    }

    public e ye() {
        return this.asz;
    }

    public boolean yf() {
        return this.asy > 0;
    }

    public boolean yg() {
        if (this.asB == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.asC < currentTimeMillis && currentTimeMillis < this.asD;
        }
        return false;
    }

    public boolean yh() {
        return this.asG == 1;
    }

    public boolean yi() {
        return this.asI == 1;
    }

    public String yj() {
        return this.asE;
    }

    public boolean yk() {
        return this.asF == 1;
    }

    public int yl() {
        return this.asJ;
    }

    public int ym() {
        return this.asK;
    }

    public boolean yn() {
        return this.asH == 0;
    }
}
