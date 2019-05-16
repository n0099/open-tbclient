package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int ceu;
    private long cev;
    private long cew;
    private String cex;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int cer = 1;
    private int cet = 0;
    private int cey = 0;
    private int cez = 1;
    private int ceA = 0;
    private int ceB = 0;
    private int ceC = 300;
    private int ceD = 1;
    public int ceE = 4;
    public int ceF = 4;
    public int ceG = 7;
    private g ces = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.cer = jSONObject.optInt("als_control", 1);
            this.cet = jSONObject.optInt("not_use_lego_patch", 0);
            this.cez = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ceB = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ces.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ceu = optJSONObject.optInt("log_feed_switch", 0);
                this.cev = optJSONObject.optLong("start_time", -1L);
                this.cew = optJSONObject.optLong("end_time", -1L);
                this.cex = optJSONObject.optString("ext_info");
            }
            this.cey = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ceC = optJSONObject2.optInt("interval", 300);
            }
            this.ceD = jSONObject.optInt("video_page_style", 1);
            this.ceA = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.ceE = optJSONObject3.optInt("first_floor");
                this.ceF = optJSONObject3.optInt("prefetch_step");
                this.ceG = optJSONObject3.optInt("step");
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

    public g akU() {
        return this.ces;
    }

    public boolean akV() {
        return this.cer > 0;
    }

    public boolean akW() {
        if (this.ceu == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cev < currentTimeMillis && currentTimeMillis < this.cew;
        }
        return false;
    }

    public boolean akX() {
        return this.cez == 1;
    }

    public boolean akY() {
        return this.ceB == 1;
    }

    public String akZ() {
        return this.cex;
    }

    public boolean ala() {
        return this.cey == 1;
    }

    public int alb() {
        return this.ceC;
    }

    public int alc() {
        return this.ceD;
    }

    public boolean ald() {
        return this.ceA == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
