package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aqf;
    private long aqg;
    private long aqh;
    private String aqi;
    private int aqc = 1;
    private int aqe = 0;
    private int aqj = 0;
    private int aqk = 1;
    private int aql = 0;
    private int aqm = 300;
    private int aqn = 1;
    private c aqd = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqc = jSONObject.optInt("als_control", 1);
            this.aqe = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqk = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aql = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqd.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqf = optJSONObject.optInt("log_feed_switch", 0);
                this.aqg = optJSONObject.optLong("start_time", -1L);
                this.aqh = optJSONObject.optLong("end_time", -1L);
                this.aqi = optJSONObject.optString("ext_info");
            }
            this.aqj = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqm = optJSONObject2.optInt("interval", 300);
            }
            this.aqn = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xM() {
        return this.aqd;
    }

    public boolean xN() {
        return this.aqc > 0;
    }

    public boolean xO() {
        if (this.aqf == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aqg < currentTimeMillis && currentTimeMillis < this.aqh;
        }
        return false;
    }

    public boolean xP() {
        return this.aqk == 1;
    }

    public boolean xQ() {
        return this.aql == 1;
    }

    public String xR() {
        return this.aqi;
    }

    public boolean xS() {
        return this.aqj == 1;
    }

    public int xT() {
        return this.aqm;
    }

    public int xU() {
        return this.aqn;
    }
}
