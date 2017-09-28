package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aqk;
    private long aql;
    private long aqm;
    private String aqn;
    private int aqh = 1;
    private int aqj = 0;
    private int aqo = 0;
    private int aqp = 1;
    private int aqq = 0;
    private int aqr = 300;
    private int aqs = 1;
    private c aqi = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqh = jSONObject.optInt("als_control", 1);
            this.aqj = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqp = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aqq = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqi.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqk = optJSONObject.optInt("log_feed_switch", 0);
                this.aql = optJSONObject.optLong("start_time", -1L);
                this.aqm = optJSONObject.optLong("end_time", -1L);
                this.aqn = optJSONObject.optString("ext_info");
            }
            this.aqo = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqr = optJSONObject2.optInt("interval", 300);
            }
            this.aqs = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xv() {
        return this.aqi;
    }

    public boolean xw() {
        return this.aqh > 0;
    }

    public boolean xx() {
        if (this.aqk == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aql < currentTimeMillis && currentTimeMillis < this.aqm;
        }
        return false;
    }

    public boolean xy() {
        return this.aqp == 1;
    }

    public boolean xz() {
        return this.aqq == 1;
    }

    public String xA() {
        return this.aqn;
    }

    public boolean xB() {
        return this.aqo == 1;
    }

    public int xC() {
        return this.aqr;
    }

    public int xD() {
        return this.aqs;
    }
}
