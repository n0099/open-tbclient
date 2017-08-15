package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private long arA;
    private long arB;
    private String arC;
    private int arz;
    private int arw = 1;
    private int ary = 0;
    private int arD = 0;
    private int arE = 1;
    private int arF = 0;
    private int arG = 300;
    private int arH = 1;
    private c arx = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.arw = jSONObject.optInt("als_control", 1);
            this.ary = jSONObject.optInt("not_use_lego_patch", 0);
            this.arE = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.arF = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.arx.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.arz = optJSONObject.optInt("log_feed_switch", 0);
                this.arA = optJSONObject.optLong("start_time", -1L);
                this.arB = optJSONObject.optLong("end_time", -1L);
                this.arC = optJSONObject.optString("ext_info");
            }
            this.arD = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.arG = optJSONObject2.optInt("interval", 300);
            }
            this.arH = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xU() {
        return this.arx;
    }

    public boolean xV() {
        return this.arw > 0;
    }

    public boolean xW() {
        if (this.arz == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.arA < currentTimeMillis && currentTimeMillis < this.arB;
        }
        return false;
    }

    public boolean xX() {
        return this.arE == 1;
    }

    public boolean xY() {
        return this.arF == 1;
    }

    public String xZ() {
        return this.arC;
    }

    public boolean ya() {
        return this.arD == 1;
    }

    public int yb() {
        return this.arG;
    }

    public int yc() {
        return this.arH;
    }
}
