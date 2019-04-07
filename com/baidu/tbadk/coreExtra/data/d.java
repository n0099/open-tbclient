package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private long bWA;
    private String bWB;
    private int bWy;
    private long bWz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int bWv = 1;
    private int bWx = 0;
    private int bWC = 0;
    private int bWD = 1;
    private int bWE = 0;
    private int bWF = 0;
    private int bWG = 300;
    private int bWH = 1;
    public int bWI = 4;
    public int bWJ = 4;
    public int bWK = 7;
    private g bWw = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bWv = jSONObject.optInt("als_control", 1);
            this.bWx = jSONObject.optInt("not_use_lego_patch", 0);
            this.bWD = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bWF = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bWw.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bWy = optJSONObject.optInt("log_feed_switch", 0);
                this.bWz = optJSONObject.optLong("start_time", -1L);
                this.bWA = optJSONObject.optLong("end_time", -1L);
                this.bWB = optJSONObject.optString("ext_info");
            }
            this.bWC = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bWG = optJSONObject2.optInt("interval", 300);
            }
            this.bWH = jSONObject.optInt("video_page_style", 1);
            this.bWE = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.bWI = optJSONObject3.optInt("first_floor");
                this.bWJ = optJSONObject3.optInt("prefetch_step");
                this.bWK = optJSONObject3.optInt("step");
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
        return this.bWw;
    }

    public boolean afW() {
        return this.bWv > 0;
    }

    public boolean afX() {
        if (this.bWy == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bWz < currentTimeMillis && currentTimeMillis < this.bWA;
        }
        return false;
    }

    public boolean afY() {
        return this.bWD == 1;
    }

    public boolean afZ() {
        return this.bWF == 1;
    }

    public String aga() {
        return this.bWB;
    }

    public boolean agb() {
        return this.bWC == 1;
    }

    public int agc() {
        return this.bWG;
    }

    public int agd() {
        return this.bWH;
    }

    public boolean age() {
        return this.bWE == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
