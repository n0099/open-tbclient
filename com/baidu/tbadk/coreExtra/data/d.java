package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long bWA;
    private long bWB;
    private String bWC;
    private int bWz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int bWw = 1;
    private int bWy = 0;
    private int bWD = 0;
    private int bWE = 1;
    private int bWF = 0;
    private int bWG = 0;
    private int bWH = 300;
    private int bWI = 1;
    public int bWJ = 4;
    public int bWK = 4;
    public int bWL = 7;
    private g bWx = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bWw = jSONObject.optInt("als_control", 1);
            this.bWy = jSONObject.optInt("not_use_lego_patch", 0);
            this.bWE = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bWG = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bWx.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bWz = optJSONObject.optInt("log_feed_switch", 0);
                this.bWA = optJSONObject.optLong("start_time", -1L);
                this.bWB = optJSONObject.optLong("end_time", -1L);
                this.bWC = optJSONObject.optString("ext_info");
            }
            this.bWD = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bWH = optJSONObject2.optInt("interval", 300);
            }
            this.bWI = jSONObject.optInt("video_page_style", 1);
            this.bWF = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.bWJ = optJSONObject3.optInt("first_floor");
                this.bWK = optJSONObject3.optInt("prefetch_step");
                this.bWL = optJSONObject3.optInt("step");
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

    public g afV() {
        return this.bWx;
    }

    public boolean afW() {
        return this.bWw > 0;
    }

    public boolean afX() {
        if (this.bWz == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bWA < currentTimeMillis && currentTimeMillis < this.bWB;
        }
        return false;
    }

    public boolean afY() {
        return this.bWE == 1;
    }

    public boolean afZ() {
        return this.bWG == 1;
    }

    public String aga() {
        return this.bWC;
    }

    public boolean agb() {
        return this.bWD == 1;
    }

    public int agc() {
        return this.bWH;
    }

    public int agd() {
        return this.bWI;
    }

    public boolean age() {
        return this.bWF == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
