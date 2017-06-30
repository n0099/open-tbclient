package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int apn;
    private long apo;
    private long apq;
    private String apr;
    private int apk = 1;
    private int apm = 0;
    private int aps = 0;
    private int apt = 1;
    private int apu = 0;
    private int apv = 300;
    private int apw = 1;
    private c apl = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.apk = jSONObject.optInt("als_control", 1);
            this.apm = jSONObject.optInt("not_use_lego_patch", 0);
            this.apt = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.apu = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.apl.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.apn = optJSONObject.optInt("log_feed_switch", 0);
                this.apo = optJSONObject.optLong("start_time", -1L);
                this.apq = optJSONObject.optLong("end_time", -1L);
                this.apr = optJSONObject.optString("ext_info");
            }
            this.aps = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.apv = optJSONObject2.optInt("interval", 300);
            }
            this.apw = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xB() {
        return this.apl;
    }

    public boolean xC() {
        return this.apk > 0;
    }

    public boolean xD() {
        if (this.apn == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.apo < currentTimeMillis && currentTimeMillis < this.apq;
        }
        return false;
    }

    public boolean xE() {
        return this.apt == 1;
    }

    public boolean xF() {
        return this.apu == 1;
    }

    public String xG() {
        return this.apr;
    }

    public boolean xH() {
        return this.aps == 1;
    }

    public int xI() {
        return this.apv;
    }

    public int xJ() {
        return this.apw;
    }
}
