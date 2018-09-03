package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aBs;
    private long aBt;
    private long aBu;
    private String aBv;
    private int aBp = 1;
    private int aBr = 0;
    private int aBw = 0;
    private int aBx = 1;
    private int aBy = 0;
    private int aBz = 0;
    private int aBA = 300;
    private int aBB = 1;
    public int aBC = 4;
    public int aBD = 4;
    public int aBE = 7;
    private e aBq = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aBp = jSONObject.optInt("als_control", 1);
            this.aBr = jSONObject.optInt("not_use_lego_patch", 0);
            this.aBx = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aBz = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aBq.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aBs = optJSONObject.optInt("log_feed_switch", 0);
                this.aBt = optJSONObject.optLong("start_time", -1L);
                this.aBu = optJSONObject.optLong("end_time", -1L);
                this.aBv = optJSONObject.optString("ext_info");
            }
            this.aBw = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aBA = optJSONObject2.optInt("interval", 300);
            }
            this.aBB = jSONObject.optInt("video_page_style", 1);
            this.aBy = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aBC = optJSONObject3.optInt("first_floor");
                this.aBD = optJSONObject3.optInt("prefetch_step");
                this.aBE = optJSONObject3.optInt("step");
            }
        }
    }

    public e BK() {
        return this.aBq;
    }

    public boolean BL() {
        return this.aBp > 0;
    }

    public boolean BM() {
        if (this.aBs == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aBt < currentTimeMillis && currentTimeMillis < this.aBu;
        }
        return false;
    }

    public boolean BN() {
        return this.aBx == 1;
    }

    public boolean BO() {
        return this.aBz == 1;
    }

    public String BP() {
        return this.aBv;
    }

    public boolean BQ() {
        return this.aBw == 1;
    }

    public int BR() {
        return this.aBA;
    }

    public int BS() {
        return this.aBB;
    }

    public boolean BT() {
        return this.aBy == 0;
    }
}
