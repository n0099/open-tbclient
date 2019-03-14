package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int bWw;
    private long bWx;
    private long bWy;
    private String bWz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int bWt = 1;
    private int bWv = 0;
    private int bWA = 0;
    private int bWB = 1;
    private int bWC = 0;
    private int bWD = 0;
    private int bWE = 300;
    private int bWF = 1;
    public int bWG = 4;
    public int bWH = 4;
    public int bWI = 7;
    private g bWu = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bWt = jSONObject.optInt("als_control", 1);
            this.bWv = jSONObject.optInt("not_use_lego_patch", 0);
            this.bWB = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bWD = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bWu.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bWw = optJSONObject.optInt("log_feed_switch", 0);
                this.bWx = optJSONObject.optLong("start_time", -1L);
                this.bWy = optJSONObject.optLong("end_time", -1L);
                this.bWz = optJSONObject.optString("ext_info");
            }
            this.bWA = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bWE = optJSONObject2.optInt("interval", 300);
            }
            this.bWF = jSONObject.optInt("video_page_style", 1);
            this.bWC = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.bWG = optJSONObject3.optInt("first_floor");
                this.bWH = optJSONObject3.optInt("prefetch_step");
                this.bWI = optJSONObject3.optInt("step");
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
        return this.bWu;
    }

    public boolean afZ() {
        return this.bWt > 0;
    }

    public boolean aga() {
        if (this.bWw == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bWx < currentTimeMillis && currentTimeMillis < this.bWy;
        }
        return false;
    }

    public boolean agb() {
        return this.bWB == 1;
    }

    public boolean agc() {
        return this.bWD == 1;
    }

    public String agd() {
        return this.bWz;
    }

    public boolean age() {
        return this.bWA == 1;
    }

    public int agf() {
        return this.bWE;
    }

    public int agg() {
        return this.bWF;
    }

    public boolean agh() {
        return this.bWC == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
