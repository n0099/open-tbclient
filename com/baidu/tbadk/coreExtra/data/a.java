package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int arf;
    private long arg;
    private long arh;
    private String ari;
    private int arc = 1;
    private int are = 0;
    private int arj = 0;
    private int ark = 1;
    private int arl = 0;
    private int arm = 300;
    private int arn = 1;
    private c ard = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.arc = jSONObject.optInt("als_control", 1);
            this.are = jSONObject.optInt("not_use_lego_patch", 0);
            this.ark = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.arl = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ard.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.arf = optJSONObject.optInt("log_feed_switch", 0);
                this.arg = optJSONObject.optLong("start_time", -1L);
                this.arh = optJSONObject.optLong("end_time", -1L);
                this.ari = optJSONObject.optString("ext_info");
            }
            this.arj = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.arm = optJSONObject2.optInt("interval", 300);
            }
            this.arn = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xW() {
        return this.ard;
    }

    public boolean xX() {
        return this.arc > 0;
    }

    public boolean xY() {
        if (this.arf == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.arg < currentTimeMillis && currentTimeMillis < this.arh;
        }
        return false;
    }

    public boolean xZ() {
        return this.ark == 1;
    }

    public boolean ya() {
        return this.arl == 1;
    }

    public String yb() {
        return this.ari;
    }

    public boolean yc() {
        return this.arj == 1;
    }

    public int yd() {
        return this.arm;
    }

    public int ye() {
        return this.arn;
    }
}
