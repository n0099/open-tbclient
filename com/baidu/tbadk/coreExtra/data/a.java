package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int apY;
    private long apZ;
    private long aqa;
    private String aqb;
    private int apV = 1;
    private int apX = 0;
    private int aqc = 0;
    private int aqd = 1;
    private int aqe = 0;
    private int aqf = 300;
    private int aqg = 1;
    private c apW = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.apV = jSONObject.optInt("als_control", 1);
            this.apX = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqd = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aqe = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.apW.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.apY = optJSONObject.optInt("log_feed_switch", 0);
                this.apZ = optJSONObject.optLong("start_time", -1L);
                this.aqa = optJSONObject.optLong("end_time", -1L);
                this.aqb = optJSONObject.optString("ext_info");
            }
            this.aqc = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqf = optJSONObject2.optInt("interval", 300);
            }
            this.aqg = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xo() {
        return this.apW;
    }

    public boolean xp() {
        return this.apV > 0;
    }

    public boolean xq() {
        if (this.apY == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.apZ < currentTimeMillis && currentTimeMillis < this.aqa;
        }
        return false;
    }

    public boolean xr() {
        return this.aqd == 1;
    }

    public boolean xs() {
        return this.aqe == 1;
    }

    public String xt() {
        return this.aqb;
    }

    public boolean xu() {
        return this.aqc == 1;
    }

    public int xv() {
        return this.aqf;
    }

    public int xw() {
        return this.aqg;
    }
}
