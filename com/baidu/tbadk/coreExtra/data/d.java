package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String cuA;
    public boolean cuK;
    public String cuL;
    private int cux;
    private long cuy;
    private long cuz;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int cuu = 1;
    private int cuw = 0;
    private int cuB = 0;
    private int cuC = 1;
    private int cuD = 0;
    private int cuE = 0;
    private int cuF = 300;
    private int cuG = 1;
    public int cuH = 4;
    public int cuI = 4;
    public int cuJ = 7;
    private g cuv = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cuu = jSONObject.optInt("als_control", 1);
            this.cuw = jSONObject.optInt("not_use_lego_patch", 0);
            this.cuC = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.cuE = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.cuv.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.cux = optJSONObject.optInt("log_feed_switch", 0);
                this.cuy = optJSONObject.optLong("start_time", -1L);
                this.cuz = optJSONObject.optLong("end_time", -1L);
                this.cuA = optJSONObject.optString("ext_info");
            }
            this.cuB = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.cuF = optJSONObject2.optInt("interval", 300);
            }
            this.cuG = jSONObject.optInt("video_page_style", 1);
            this.cuD = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.cuH = optJSONObject3.optInt("first_floor");
                this.cuI = optJSONObject3.optInt("prefetch_step");
                this.cuJ = optJSONObject3.optInt("step");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("action_control");
            if (optJSONObject4 != null) {
                this.url = optJSONObject4.optString("url");
                this.name = optJSONObject4.optString("name");
                this.text_color = optJSONObject4.optString("text_color");
                this.text_color_pressed = optJSONObject4.optString("text_color_pressed");
            }
            this.cuK = jSONObject.optInt("afd_jump_pb") == 1;
            this.cuL = jSONObject.optString("afd_eid");
        }
    }

    public g aoS() {
        return this.cuv;
    }

    public boolean aoT() {
        return this.cuu > 0;
    }

    public boolean aoU() {
        if (this.cux == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cuy < currentTimeMillis && currentTimeMillis < this.cuz;
        }
        return false;
    }

    public boolean aoV() {
        return this.cuC == 1;
    }

    public boolean aoW() {
        return this.cuE == 1;
    }

    public String aoX() {
        return this.cuA;
    }

    public boolean aoY() {
        return this.cuB == 1;
    }

    public int aoZ() {
        return this.cuF;
    }

    public int apa() {
        return this.cuG;
    }

    public boolean apb() {
        return this.cuD == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
