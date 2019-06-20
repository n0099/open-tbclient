package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int cev;
    private long cew;
    private long cex;
    private String cey;
    private String name;
    private String text_color;
    private String text_color_pressed;
    private String url;
    private int ces = 1;
    private int ceu = 0;
    private int cez = 0;
    private int ceA = 1;
    private int ceB = 0;
    private int ceC = 0;
    private int ceD = 300;
    private int ceE = 1;
    public int ceF = 4;
    public int ceG = 4;
    public int ceH = 7;
    private g cet = new g();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ces = jSONObject.optInt("als_control", 1);
            this.ceu = jSONObject.optInt("not_use_lego_patch", 0);
            this.ceA = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ceC = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.cet.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.cev = optJSONObject.optInt("log_feed_switch", 0);
                this.cew = optJSONObject.optLong("start_time", -1L);
                this.cex = optJSONObject.optLong("end_time", -1L);
                this.cey = optJSONObject.optString("ext_info");
            }
            this.cez = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ceD = optJSONObject2.optInt("interval", 300);
            }
            this.ceE = jSONObject.optInt("video_page_style", 1);
            this.ceB = jSONObject.optInt("ad_download_lib", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("afd_sync_config");
            if (optJSONObject3 != null) {
                this.ceF = optJSONObject3.optInt("first_floor");
                this.ceG = optJSONObject3.optInt("prefetch_step");
                this.ceH = optJSONObject3.optInt("step");
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
        return this.cet;
    }

    public boolean akV() {
        return this.ces > 0;
    }

    public boolean akW() {
        if (this.cev == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.cew < currentTimeMillis && currentTimeMillis < this.cex;
        }
        return false;
    }

    public boolean akX() {
        return this.ceA == 1;
    }

    public boolean akY() {
        return this.ceC == 1;
    }

    public String akZ() {
        return this.cey;
    }

    public boolean ala() {
        return this.cez == 1;
    }

    public int alb() {
        return this.ceD;
    }

    public int alc() {
        return this.ceE;
    }

    public boolean ald() {
        return this.ceB == 0;
    }

    public String getUrl() {
        return this.url;
    }
}
