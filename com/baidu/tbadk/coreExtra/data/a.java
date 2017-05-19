package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aoD;
    private long aoE;
    private long aoF;
    private String aoG;
    private int aoA = 1;
    private int aoC = 0;
    private int aoH = 0;
    private int aoI = 1;
    private int aoJ = 0;
    private int aoK = 300;
    private int aoL = 1;
    private c aoB = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.aoA = jSONObject.optInt("als_control", 1);
            this.aoC = jSONObject.optInt("not_use_lego_patch", 0);
            this.aoI = jSONObject.optInt("ad_video_not_autoplay", 1);
            this.aoJ = jSONObject.optInt("lp_video_not_autoplay", 0);
            this.aoB.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.aoD = optJSONObject.optInt("log_feed_switch", 0);
                this.aoE = optJSONObject.optLong("start_time", -1L);
                this.aoF = optJSONObject.optLong("end_time", -1L);
                this.aoG = optJSONObject.optString("ext_info");
            }
            this.aoH = jSONObject.optInt("ad_collect_switch", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("splash");
            if (optJSONObject2 != null) {
                this.aoK = optJSONObject2.optInt("interval", 300);
            }
            this.aoL = jSONObject.optInt("video_page_style", 1);
        }
    }

    public c xq() {
        return this.aoB;
    }

    public boolean xr() {
        return this.aoA > 0;
    }

    public boolean xs() {
        if (this.aoD == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.aoE < currentTimeMillis && currentTimeMillis < this.aoF;
        }
        return false;
    }

    public boolean xt() {
        return this.aoC == 0;
    }

    public boolean xu() {
        return this.aoI == 1;
    }

    public boolean xv() {
        return this.aoJ == 1;
    }

    public String xw() {
        return this.aoG;
    }

    public boolean xx() {
        return this.aoH == 1;
    }

    public int xy() {
        return this.aoK;
    }

    public int xz() {
        return this.aoL;
    }
}
