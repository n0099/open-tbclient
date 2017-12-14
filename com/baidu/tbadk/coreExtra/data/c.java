package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aqW;
    private long aqX;
    private long aqY;
    private String aqZ;
    private int aqT = 1;
    private int aqV = 0;
    private int ara = 0;
    private int arb = 1;
    private int arc = 0;
    private int ard = 300;
    private int are = 1;
    private e aqU = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqT = jSONObject.optInt("als_control", 1);
            this.aqV = jSONObject.optInt("not_use_lego_patch", 0);
            this.arb = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.arc = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqU.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqW = optJSONObject.optInt("log_feed_switch", 0);
                this.aqX = optJSONObject.optLong("start_time", -1L);
                this.aqY = optJSONObject.optLong("end_time", -1L);
                this.aqZ = optJSONObject.optString("ext_info");
            }
            this.ara = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.ard = optJSONObject2.optInt("interval", 300);
            }
            this.are = jSONObject.optInt("video_page_style", 1);
        }
    }

    public e xF() {
        return this.aqU;
    }

    public boolean xG() {
        return this.aqT > 0;
    }

    public boolean xH() {
        if (this.aqW == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aqX < currentTimeMillis && currentTimeMillis < this.aqY;
        }
        return false;
    }

    public boolean xI() {
        return this.arb == 1;
    }

    public boolean xJ() {
        return this.arc == 1;
    }

    public String xK() {
        return this.aqZ;
    }

    public boolean xL() {
        return this.ara == 1;
    }

    public int xM() {
        return this.ard;
    }

    public int xN() {
        return this.are;
    }
}
