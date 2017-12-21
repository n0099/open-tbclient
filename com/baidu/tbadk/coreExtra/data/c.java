package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aqZ;
    private long ara;
    private long arb;
    private String arc;
    private int aqW = 1;
    private int aqY = 0;
    private int ard = 0;
    private int are = 1;
    private int arf = 0;
    private int arg = 300;
    private int arh = 1;
    private e aqX = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqW = jSONObject.optInt("als_control", 1);
            this.aqY = jSONObject.optInt("not_use_lego_patch", 0);
            this.are = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.arf = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqX.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqZ = optJSONObject.optInt("log_feed_switch", 0);
                this.ara = optJSONObject.optLong("start_time", -1L);
                this.arb = optJSONObject.optLong("end_time", -1L);
                this.arc = optJSONObject.optString("ext_info");
            }
            this.ard = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.arg = optJSONObject2.optInt("interval", 300);
            }
            this.arh = jSONObject.optInt("video_page_style", 1);
        }
    }

    public e xF() {
        return this.aqX;
    }

    public boolean xG() {
        return this.aqW > 0;
    }

    public boolean xH() {
        if (this.aqZ == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ara < currentTimeMillis && currentTimeMillis < this.arb;
        }
        return false;
    }

    public boolean xI() {
        return this.are == 1;
    }

    public boolean xJ() {
        return this.arf == 1;
    }

    public String xK() {
        return this.arc;
    }

    public boolean xL() {
        return this.ard == 1;
    }

    public int xM() {
        return this.arg;
    }

    public int xN() {
        return this.arh;
    }
}
