package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aBB;
    private long aBC;
    private long aBD;
    private String aBE;
    private int aBy = 1;
    private int aBA = 0;
    private int aBF = 0;
    private int aBG = 1;
    private int aBH = 0;
    private int aBI = 0;
    private int aBJ = 300;
    private int aBK = 1;
    public int aBL = 4;
    public int aBM = 4;
    public int aBN = 7;
    private e aBz = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aBy = jSONObject.optInt("als_control", 1);
            this.aBA = jSONObject.optInt("not_use_lego_patch", 0);
            this.aBG = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aBI = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aBz.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aBB = optJSONObject.optInt("log_feed_switch", 0);
                this.aBC = optJSONObject.optLong("start_time", -1L);
                this.aBD = optJSONObject.optLong("end_time", -1L);
                this.aBE = optJSONObject.optString("ext_info");
            }
            this.aBF = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aBJ = optJSONObject2.optInt("interval", 300);
            }
            this.aBK = jSONObject.optInt("video_page_style", 1);
            this.aBH = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aBL = optJSONObject3.optInt("first_floor");
                this.aBM = optJSONObject3.optInt("prefetch_step");
                this.aBN = optJSONObject3.optInt("step");
            }
        }
    }

    public e BV() {
        return this.aBz;
    }

    public boolean BW() {
        return this.aBy > 0;
    }

    public boolean BX() {
        if (this.aBB == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aBC < currentTimeMillis && currentTimeMillis < this.aBD;
        }
        return false;
    }

    public boolean BY() {
        return this.aBG == 1;
    }

    public boolean BZ() {
        return this.aBI == 1;
    }

    public String Ca() {
        return this.aBE;
    }

    public boolean Cb() {
        return this.aBF == 1;
    }

    public int Cc() {
        return this.aBJ;
    }

    public int Cd() {
        return this.aBK;
    }

    public boolean Ce() {
        return this.aBH == 0;
    }
}
