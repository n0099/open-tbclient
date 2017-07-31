package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private long arA;
    private String arB;
    private int ary;
    private long arz;
    private int arv = 1;
    private int arx = 0;
    private int arC = 0;
    private int arD = 1;
    private int arE = 0;
    private int arF = 300;
    private int arG = 1;
    private c arw = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.arv = jSONObject.optInt("als_control", 1);
            this.arx = jSONObject.optInt("not_use_lego_patch", 0);
            this.arD = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.arE = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.arw.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ary = optJSONObject.optInt("log_feed_switch", 0);
                this.arz = optJSONObject.optLong("start_time", -1L);
                this.arA = optJSONObject.optLong("end_time", -1L);
                this.arB = optJSONObject.optString("ext_info");
            }
            this.arC = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.arF = optJSONObject2.optInt("interval", 300);
            }
            this.arG = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xU() {
        return this.arw;
    }

    public boolean xV() {
        return this.arv > 0;
    }

    public boolean xW() {
        if (this.ary == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.arz < currentTimeMillis && currentTimeMillis < this.arA;
        }
        return false;
    }

    public boolean xX() {
        return this.arD == 1;
    }

    public boolean xY() {
        return this.arE == 1;
    }

    public String xZ() {
        return this.arB;
    }

    public boolean ya() {
        return this.arC == 1;
    }

    public int yb() {
        return this.arF;
    }

    public int yc() {
        return this.arG;
    }
}
