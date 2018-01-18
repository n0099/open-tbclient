package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bff;
    private long bfg;
    private long bfh;
    private String bfi;
    private int bfc = 1;
    private int bfe = 0;
    private int bfj = 0;
    private int bfk = 1;
    private int bfl = 0;
    private int bfm = 300;
    private int bfn = 1;
    private e bfd = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bfc = jSONObject.optInt("als_control", 1);
            this.bfe = jSONObject.optInt("not_use_lego_patch", 0);
            this.bfk = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bfl = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bfd.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bff = optJSONObject.optInt("log_feed_switch", 0);
                this.bfg = optJSONObject.optLong("start_time", -1L);
                this.bfh = optJSONObject.optLong("end_time", -1L);
                this.bfi = optJSONObject.optString("ext_info");
            }
            this.bfj = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bfm = optJSONObject2.optInt("interval", 300);
            }
            this.bfn = jSONObject.optInt("video_page_style", 1);
        }
    }

    public e EV() {
        return this.bfd;
    }

    public boolean EW() {
        return this.bfc > 0;
    }

    public boolean EX() {
        if (this.bff == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bfg < currentTimeMillis && currentTimeMillis < this.bfh;
        }
        return false;
    }

    public boolean EY() {
        return this.bfk == 1;
    }

    public boolean EZ() {
        return this.bfl == 1;
    }

    public String Fa() {
        return this.bfi;
    }

    public boolean Fb() {
        return this.bfj == 1;
    }

    public int Fc() {
        return this.bfm;
    }

    public int Fd() {
        return this.bfn;
    }
}
