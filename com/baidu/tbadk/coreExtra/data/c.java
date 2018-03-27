package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bgW;
    private long bgX;
    private long bgY;
    private String bgZ;
    private int bgT = 1;
    private int bgV = 0;
    private int bha = 0;
    private int bhb = 1;
    private int bhc = 0;
    private int bhd = 0;
    private int bhe = 300;
    private int bhf = 1;
    private e bgU = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bgT = jSONObject.optInt("als_control", 1);
            this.bgV = jSONObject.optInt("not_use_lego_patch", 0);
            this.bhb = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bhd = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bgU.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bgW = optJSONObject.optInt("log_feed_switch", 0);
                this.bgX = optJSONObject.optLong("start_time", -1L);
                this.bgY = optJSONObject.optLong("end_time", -1L);
                this.bgZ = optJSONObject.optString("ext_info");
            }
            this.bha = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bhe = optJSONObject2.optInt("interval", 300);
            }
            this.bhf = jSONObject.optInt("video_page_style", 1);
            this.bhc = jSONObject.optInt("ad_download_lib", 0);
        }
    }

    public e Fs() {
        return this.bgU;
    }

    public boolean Ft() {
        return this.bgT > 0;
    }

    public boolean Fu() {
        if (this.bgW == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bgX < currentTimeMillis && currentTimeMillis < this.bgY;
        }
        return false;
    }

    public boolean Fv() {
        return this.bhb == 1;
    }

    public boolean Fw() {
        return this.bhd == 1;
    }

    public String Fx() {
        return this.bgZ;
    }

    public boolean Fy() {
        return this.bha == 1;
    }

    public int Fz() {
        return this.bhe;
    }

    public int FA() {
        return this.bhf;
    }

    public boolean FB() {
        return this.bhc == 0;
    }
}
