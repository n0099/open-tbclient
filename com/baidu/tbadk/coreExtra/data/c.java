package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int beY;
    private long beZ;
    private long bfa;
    private String bfc;
    private int beV = 1;
    private int beX = 0;
    private int bfd = 0;
    private int bfe = 1;
    private int bff = 0;
    private int bfg = 300;
    private int bfh = 1;
    private e beW = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.beV = jSONObject.optInt("als_control", 1);
            this.beX = jSONObject.optInt("not_use_lego_patch", 0);
            this.bfe = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bff = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.beW.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.beY = optJSONObject.optInt("log_feed_switch", 0);
                this.beZ = optJSONObject.optLong("start_time", -1L);
                this.bfa = optJSONObject.optLong("end_time", -1L);
                this.bfc = optJSONObject.optString("ext_info");
            }
            this.bfd = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bfg = optJSONObject2.optInt("interval", 300);
            }
            this.bfh = jSONObject.optInt("video_page_style", 1);
        }
    }

    public e Fe() {
        return this.beW;
    }

    public boolean Ff() {
        return this.beV > 0;
    }

    public boolean Fg() {
        if (this.beY == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.beZ < currentTimeMillis && currentTimeMillis < this.bfa;
        }
        return false;
    }

    public boolean Fh() {
        return this.bfe == 1;
    }

    public boolean Fi() {
        return this.bff == 1;
    }

    public String Fj() {
        return this.bfc;
    }

    public boolean Fk() {
        return this.bfd == 1;
    }

    public int Fl() {
        return this.bfg;
    }

    public int Fm() {
        return this.bfh;
    }
}
