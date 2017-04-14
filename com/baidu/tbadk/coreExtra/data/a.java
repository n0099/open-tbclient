package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private long aoA;
    private String aoB;
    private int aoy;
    private long aoz;
    private int aov = 1;
    private int aox = 0;
    private int aoC = 0;
    private int aoD = 1;
    private int aoE = 0;
    private int aoF = 300;
    private int aoG = 1;
    private c aow = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aov = jSONObject.optInt("als_control", 1);
            this.aox = jSONObject.optInt("not_use_lego_patch", 0);
            this.aoD = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aoE = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aow.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aoy = optJSONObject.optInt("log_feed_switch", 0);
                this.aoz = optJSONObject.optLong("start_time", -1L);
                this.aoA = optJSONObject.optLong("end_time", -1L);
                this.aoB = optJSONObject.optString("ext_info");
            }
            this.aoC = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aoF = optJSONObject2.optInt("interval", 300);
            }
            this.aoG = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c yc() {
        return this.aow;
    }

    public boolean yd() {
        return this.aov > 0;
    }

    public boolean ye() {
        if (this.aoy == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aoz < currentTimeMillis && currentTimeMillis < this.aoA;
        }
        return false;
    }

    public boolean yf() {
        return this.aox == 0;
    }

    public boolean yg() {
        return this.aoD == 1;
    }

    public boolean yh() {
        return this.aoE == 1;
    }

    public String yi() {
        return this.aoB;
    }

    public boolean yj() {
        return this.aoC == 1;
    }

    public int yk() {
        return this.aoF;
    }

    public int yl() {
        return this.aoG;
    }
}
