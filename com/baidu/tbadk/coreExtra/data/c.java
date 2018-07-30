package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aBv;
    private long aBw;
    private long aBx;
    private String aBy;
    private int aBs = 1;
    private int aBu = 0;
    private int aBz = 0;
    private int aBA = 1;
    private int aBB = 0;
    private int aBC = 0;
    private int aBD = 300;
    private int aBE = 1;
    public int aBF = 4;
    public int aBG = 4;
    public int aBH = 7;
    private e aBt = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aBs = jSONObject.optInt("als_control", 1);
            this.aBu = jSONObject.optInt("not_use_lego_patch", 0);
            this.aBA = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aBC = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aBt.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aBv = optJSONObject.optInt("log_feed_switch", 0);
                this.aBw = optJSONObject.optLong("start_time", -1L);
                this.aBx = optJSONObject.optLong("end_time", -1L);
                this.aBy = optJSONObject.optString("ext_info");
            }
            this.aBz = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aBD = optJSONObject2.optInt("interval", 300);
            }
            this.aBE = jSONObject.optInt("video_page_style", 1);
            this.aBB = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aBF = optJSONObject3.optInt("first_floor");
                this.aBG = optJSONObject3.optInt("prefetch_step");
                this.aBH = optJSONObject3.optInt("step");
            }
        }
    }

    public e BN() {
        return this.aBt;
    }

    public boolean BO() {
        return this.aBs > 0;
    }

    public boolean BP() {
        if (this.aBv == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aBw < currentTimeMillis && currentTimeMillis < this.aBx;
        }
        return false;
    }

    public boolean BQ() {
        return this.aBA == 1;
    }

    public boolean BR() {
        return this.aBC == 1;
    }

    public String BS() {
        return this.aBy;
    }

    public boolean BT() {
        return this.aBz == 1;
    }

    public int BU() {
        return this.aBD;
    }

    public int BV() {
        return this.aBE;
    }

    public boolean BW() {
        return this.aBB == 0;
    }
}
