package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aAI;
    private long aAJ;
    private long aAK;
    private String aAL;
    private int aAF = 1;
    private int aAH = 0;
    private int aAM = 0;
    private int aAN = 1;
    private int aAO = 0;
    private int aAP = 0;
    private int aAQ = 300;
    private int aAR = 1;
    public int aAS = 4;
    public int aAT = 4;
    public int aAU = 7;
    private e aAG = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aAF = jSONObject.optInt("als_control", 1);
            this.aAH = jSONObject.optInt("not_use_lego_patch", 0);
            this.aAN = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aAP = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aAG.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aAI = optJSONObject.optInt("log_feed_switch", 0);
                this.aAJ = optJSONObject.optLong("start_time", -1L);
                this.aAK = optJSONObject.optLong("end_time", -1L);
                this.aAL = optJSONObject.optString("ext_info");
            }
            this.aAM = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aAQ = optJSONObject2.optInt("interval", 300);
            }
            this.aAR = jSONObject.optInt("video_page_style", 1);
            this.aAO = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.aAS = optJSONObject3.optInt("first_floor");
                this.aAT = optJSONObject3.optInt("prefetch_step");
                this.aAU = optJSONObject3.optInt("step");
            }
        }
    }

    public e BE() {
        return this.aAG;
    }

    public boolean BF() {
        return this.aAF > 0;
    }

    public boolean BG() {
        if (this.aAI == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aAJ < currentTimeMillis && currentTimeMillis < this.aAK;
        }
        return false;
    }

    public boolean BH() {
        return this.aAN == 1;
    }

    public boolean BI() {
        return this.aAP == 1;
    }

    public String BJ() {
        return this.aAL;
    }

    public boolean BK() {
        return this.aAM == 1;
    }

    public int BL() {
        return this.aAQ;
    }

    public int BM() {
        return this.aAR;
    }

    public boolean BN() {
        return this.aAO == 0;
    }
}
