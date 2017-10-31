package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aqt;
    private long aqu;
    private long aqv;
    private String aqw;
    private int aqq = 1;
    private int aqs = 0;
    private int aqx = 0;
    private int aqy = 1;
    private int aqz = 0;
    private int aqA = 300;
    private int aqB = 1;
    private c aqr = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqq = jSONObject.optInt("als_control", 1);
            this.aqs = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqy = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aqz = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqr.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqt = optJSONObject.optInt("log_feed_switch", 0);
                this.aqu = optJSONObject.optLong("start_time", -1L);
                this.aqv = optJSONObject.optLong("end_time", -1L);
                this.aqw = optJSONObject.optString("ext_info");
            }
            this.aqx = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqA = optJSONObject2.optInt("interval", 300);
            }
            this.aqB = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xv() {
        return this.aqr;
    }

    public boolean xw() {
        return this.aqq > 0;
    }

    public boolean xx() {
        if (this.aqt == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aqu < currentTimeMillis && currentTimeMillis < this.aqv;
        }
        return false;
    }

    public boolean xy() {
        return this.aqy == 1;
    }

    public boolean xz() {
        return this.aqz == 1;
    }

    public String xA() {
        return this.aqw;
    }

    public boolean xB() {
        return this.aqx == 1;
    }

    public int xC() {
        return this.aqA;
    }

    public int xD() {
        return this.aqB;
    }
}
