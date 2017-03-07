package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aok;
    private long aol;
    private long aom;
    private String aon;
    private int aoh = 1;
    private int aoj = 0;
    private int aoo = 0;
    private int aop = 1;
    private int aoq = 0;
    private int aor = 300;
    private c aoi = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aoh = jSONObject.optInt("als_control", 1);
            this.aoj = jSONObject.optInt("not_use_lego_patch", 0);
            this.aop = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aoq = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aoi.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aok = optJSONObject.optInt("log_feed_switch", 0);
                this.aol = optJSONObject.optLong("start_time", -1L);
                this.aom = optJSONObject.optLong("end_time", -1L);
                this.aon = optJSONObject.optString("ext_info");
            }
            this.aoo = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aor = optJSONObject2.optInt("interval", 300);
            }
        }
    }

    public c xG() {
        return this.aoi;
    }

    public boolean xH() {
        return this.aoh > 0;
    }

    public boolean xI() {
        if (this.aok == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aol < currentTimeMillis && currentTimeMillis < this.aom;
        }
        return false;
    }

    public boolean xJ() {
        return this.aoj == 0;
    }

    public boolean xK() {
        return this.aop == 1;
    }

    public boolean xL() {
        return this.aoq == 1;
    }

    public String xM() {
        return this.aon;
    }

    public boolean xN() {
        return this.aoo == 1;
    }
}
