package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aon;
    private long aoo;
    private long aop;
    private String aoq;
    private int aok = 1;
    private int aom = 0;
    private int aor = 0;
    private int aos = 1;
    private int aot = 0;
    private int aou = 300;
    private int aov = 1;
    private c aol = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aok = jSONObject.optInt("als_control", 1);
            this.aom = jSONObject.optInt("not_use_lego_patch", 0);
            this.aos = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aot = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aol.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aon = optJSONObject.optInt("log_feed_switch", 0);
                this.aoo = optJSONObject.optLong("start_time", -1L);
                this.aop = optJSONObject.optLong("end_time", -1L);
                this.aoq = optJSONObject.optString("ext_info");
            }
            this.aor = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aou = optJSONObject2.optInt("interval", 300);
            }
            this.aov = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xj() {
        return this.aol;
    }

    public boolean xk() {
        return this.aok > 0;
    }

    public boolean xl() {
        if (this.aon == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aoo < currentTimeMillis && currentTimeMillis < this.aop;
        }
        return false;
    }

    public boolean xm() {
        return this.aom == 0;
    }

    public boolean xn() {
        return this.aos == 1;
    }

    public boolean xo() {
        return this.aot == 1;
    }

    public String xp() {
        return this.aoq;
    }

    public boolean xq() {
        return this.aor == 1;
    }

    public int xr() {
        return this.aou;
    }

    public int xs() {
        return this.aov;
    }
}
