package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bgT;
    private long bgU;
    private long bgV;
    private String bgW;
    private int bgQ = 1;
    private int bgS = 0;
    private int bgX = 0;
    private int bgY = 1;
    private int bgZ = 0;
    private int bha = 0;
    private int bhb = 300;
    private int bhc = 1;
    private e bgR = new e();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.bgQ = jSONObject.optInt("als_control", 1);
            this.bgS = jSONObject.optInt("not_use_lego_patch", 0);
            this.bgY = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.bha = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.bgR.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.bgT = optJSONObject.optInt("log_feed_switch", 0);
                this.bgU = optJSONObject.optLong("start_time", -1L);
                this.bgV = optJSONObject.optLong("end_time", -1L);
                this.bgW = optJSONObject.optString("ext_info");
            }
            this.bgX = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.bhb = optJSONObject2.optInt("interval", 300);
            }
            this.bhc = jSONObject.optInt("video_page_style", 1);
            this.bgZ = jSONObject.optInt("ad_download_lib", 0);
        }
    }

    public e Fr() {
        return this.bgR;
    }

    public boolean Fs() {
        return this.bgQ > 0;
    }

    public boolean Ft() {
        if (this.bgT == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.bgU < currentTimeMillis && currentTimeMillis < this.bgV;
        }
        return false;
    }

    public boolean Fu() {
        return this.bgY == 1;
    }

    public boolean Fv() {
        return this.bha == 1;
    }

    public String Fw() {
        return this.bgW;
    }

    public boolean Fx() {
        return this.bgX == 1;
    }

    public int Fy() {
        return this.bhb;
    }

    public int Fz() {
        return this.bhc;
    }

    public boolean FA() {
        return this.bgZ == 0;
    }
}
