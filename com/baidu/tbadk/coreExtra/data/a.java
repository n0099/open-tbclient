package com.baidu.tbadk.coreExtra.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int ajD;
    private long ajE;
    private long ajF;
    private String ajG;
    private int ajA = 1;
    private int ajC = 0;
    private int ajH = 0;
    private c ajB = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ajA = jSONObject.optInt("als_control", 1);
            this.ajC = jSONObject.optInt("not_use_lego_patch", 0);
            this.ajB.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ajD = optJSONObject.optInt("log_feed_switch", 0);
                this.ajE = optJSONObject.optLong("start_time", -1L);
                this.ajF = optJSONObject.optLong("end_time", -1L);
                this.ajG = optJSONObject.optString("ext_info");
            }
            this.ajH = jSONObject.optInt("ad_collect_switch", 0);
        }
    }

    public c xq() {
        return this.ajB;
    }

    public boolean xr() {
        return this.ajA > 0;
    }

    public boolean xs() {
        if (this.ajD == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ajE < currentTimeMillis && currentTimeMillis < this.ajF;
        }
        return false;
    }

    public boolean xt() {
        return this.ajC == 0;
    }

    public String xu() {
        return this.ajG;
    }

    public boolean xv() {
        return this.ajH == 1;
    }
}
