package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aiO;
    private long aiP;
    private long aiQ;
    private String aiR;
    private int aiL = 1;
    private int aiN = 0;
    private int aiS = 0;
    private int aiT = 1;
    private int aiU = 0;
    private c aiM = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aiL = jSONObject.optInt("als_control", 1);
            this.aiN = jSONObject.optInt("not_use_lego_patch", 0);
            this.aiT = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aiU = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aiM.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aiO = optJSONObject.optInt("log_feed_switch", 0);
                this.aiP = optJSONObject.optLong("start_time", -1L);
                this.aiQ = optJSONObject.optLong("end_time", -1L);
                this.aiR = optJSONObject.optString("ext_info");
            }
            this.aiS = jSONObject.optInt("ad_collect_switch", 0);
        }
    }

    public c xk() {
        return this.aiM;
    }

    public boolean xl() {
        return this.aiL > 0;
    }

    public boolean xm() {
        if (this.aiO == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aiP < currentTimeMillis && currentTimeMillis < this.aiQ;
        }
        return false;
    }

    public boolean xn() {
        return this.aiN == 0;
    }

    public boolean xo() {
        return this.aiT == 1;
    }

    public boolean xp() {
        return this.aiU == 1;
    }

    public String xq() {
        return this.aiR;
    }

    public boolean xr() {
        return this.aiS == 1;
    }
}
