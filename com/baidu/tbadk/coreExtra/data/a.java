package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int arc;
    private long ard;
    private long are;
    private String arf;
    private int aqZ = 1;
    private int arb = 0;
    private int arg = 0;
    private int arh = 1;
    private int ari = 0;
    private int arj = 300;
    private int ark = 1;
    private c ara = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqZ = jSONObject.optInt("als_control", 1);
            this.arb = jSONObject.optInt("not_use_lego_patch", 0);
            this.arh = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.ari = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.ara.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.arc = optJSONObject.optInt("log_feed_switch", 0);
                this.ard = optJSONObject.optLong("start_time", -1L);
                this.are = optJSONObject.optLong("end_time", -1L);
                this.arf = optJSONObject.optString("ext_info");
            }
            this.arg = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.arj = optJSONObject2.optInt("interval", 300);
            }
            this.ark = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xW() {
        return this.ara;
    }

    public boolean xX() {
        return this.aqZ > 0;
    }

    public boolean xY() {
        if (this.arc == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ard < currentTimeMillis && currentTimeMillis < this.are;
        }
        return false;
    }

    public boolean xZ() {
        return this.arh == 1;
    }

    public boolean ya() {
        return this.ari == 1;
    }

    public String yb() {
        return this.arf;
    }

    public boolean yc() {
        return this.arg == 1;
    }

    public int yd() {
        return this.arj;
    }

    public int ye() {
        return this.ark;
    }
}
