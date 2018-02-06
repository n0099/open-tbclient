package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bhf;
    private long bhg;
    private long bhh;
    private String bhi;
    private int bhc = 1;
    private int bhe = 0;
    private int bhj = 0;
    private int bhk = 1;
    private int bhl = 0;
    private int bhm = 0;
    private int bhn = 300;
    private int bho = 1;
    private e bhd = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bhc = jSONObject.optInt("als_control", 1);
            this.bhe = jSONObject.optInt("not_use_lego_patch", 0);
            this.bhk = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bhm = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bhd.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bhf = optJSONObject.optInt("log_feed_switch", 0);
                this.bhg = optJSONObject.optLong("start_time", -1L);
                this.bhh = optJSONObject.optLong("end_time", -1L);
                this.bhi = optJSONObject.optString("ext_info");
            }
            this.bhj = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bhn = optJSONObject2.optInt("interval", 300);
            }
            this.bho = jSONObject.optInt("video_page_style", 1);
            this.bhl = jSONObject.optInt("ad_download_lib", 0);
        }
    }

    public e Fs() {
        return this.bhd;
    }

    public boolean Ft() {
        return this.bhc > 0;
    }

    public boolean Fu() {
        if (this.bhf == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bhg < currentTimeMillis && currentTimeMillis < this.bhh;
        }
        return false;
    }

    public boolean Fv() {
        return this.bhk == 1;
    }

    public boolean Fw() {
        return this.bhm == 1;
    }

    public String Fx() {
        return this.bhi;
    }

    public boolean Fy() {
        return this.bhj == 1;
    }

    public int Fz() {
        return this.bhn;
    }

    public int FA() {
        return this.bho;
    }

    public boolean FB() {
        return this.bhl == 0;
    }
}
