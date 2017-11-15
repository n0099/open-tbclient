package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private long aqA;
    private long aqB;
    private String aqC;
    private int aqz;
    private int aqw = 1;
    private int aqy = 0;
    private int aqD = 0;
    private int aqE = 1;
    private int aqF = 0;
    private int aqG = 300;
    private int aqH = 1;
    private d aqx = new d();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aqw = jSONObject.optInt("als_control", 1);
            this.aqy = jSONObject.optInt("not_use_lego_patch", 0);
            this.aqE = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aqF = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aqx.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aqz = optJSONObject.optInt("log_feed_switch", 0);
                this.aqA = optJSONObject.optLong("start_time", -1L);
                this.aqB = optJSONObject.optLong("end_time", -1L);
                this.aqC = optJSONObject.optString("ext_info");
            }
            this.aqD = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aqG = optJSONObject2.optInt("interval", 300);
            }
            this.aqH = jSONObject.optInt("video_page_style", 1);
        }
    }

    public d xD() {
        return this.aqx;
    }

    public boolean xE() {
        return this.aqw > 0;
    }

    public boolean xF() {
        if (this.aqz == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aqA < currentTimeMillis && currentTimeMillis < this.aqB;
        }
        return false;
    }

    public boolean xG() {
        return this.aqE == 1;
    }

    public boolean xH() {
        return this.aqF == 1;
    }

    public String xI() {
        return this.aqC;
    }

    public boolean xJ() {
        return this.aqD == 1;
    }

    public int xK() {
        return this.aqG;
    }

    public int xL() {
        return this.aqH;
    }
}
