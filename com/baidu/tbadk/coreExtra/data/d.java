package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int bWv;
    private long bWw;
    private long bWx;
    private String bWy;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int bWs = 1;
    private int bWu = 0;
    private int bWz = 0;
    private int bWA = 1;
    private int bWB = 0;
    private int bWC = 0;
    private int bWD = 300;
    private int bWE = 1;
    public int bWF = 4;
    public int bWG = 4;
    public int bWH = 7;
    private g bWt = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bWs = jSONObject.optInt("als_control", 1);
            this.bWu = jSONObject.optInt("not_use_lego_patch", 0);
            this.bWA = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bWC = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bWt.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bWv = optJSONObject.optInt("log_feed_switch", 0);
                this.bWw = optJSONObject.optLong("start_time", -1L);
                this.bWx = optJSONObject.optLong("end_time", -1L);
                this.bWy = optJSONObject.optString("ext_info");
            }
            this.bWz = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bWD = optJSONObject2.optInt("interval", 300);
            }
            this.bWE = jSONObject.optInt("video_page_style", 1);
            this.bWB = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.bWF = optJSONObject3.optInt("first_floor");
                this.bWG = optJSONObject3.optInt("prefetch_step");
                this.bWH = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
        }
    }

    public g afY() {
        return this.bWt;
    }

    public boolean afZ() {
        return this.bWs > 0;
    }

    public boolean aga() {
        if (this.bWv == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bWw < currentTimeMillis && currentTimeMillis < this.bWx;
        }
        return false;
    }

    public boolean agb() {
        return this.bWA == 1;
    }

    public boolean agc() {
        return this.bWC == 1;
    }

    public String agd() {
        return this.bWy;
    }

    public boolean age() {
        return this.bWz == 1;
    }

    public int agf() {
        return this.bWD;
    }

    public int agg() {
        return this.bWE;
    }

    public boolean agh() {
        return this.bWB == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
