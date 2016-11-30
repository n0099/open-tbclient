package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int akb;
    private long akc;
    private long akd;
    private String ake;
    private int ajZ = 1;
    private int akf = 0;
    private c aka = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ajZ = jSONObject.optInt("als_control", 1);
            this.aka.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.akb = optJSONObject.optInt("log_feed_switch", 0);
                this.akc = optJSONObject.optLong(ThActivityDetailActivityConfig.START_TIME, -1L);
                this.akd = optJSONObject.optLong(ThActivityDetailActivityConfig.END_TIME, -1L);
                this.ake = optJSONObject.optString("ext_info");
            }
            this.akf = jSONObject.optInt("ad_collect_switch", 0);
        }
    }

    public c xD() {
        return this.aka;
    }

    public boolean xE() {
        return this.ajZ > 0;
    }

    public boolean xF() {
        if (this.akb == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.akc < currentTimeMillis && currentTimeMillis < this.akd;
        }
        return false;
    }

    public String xG() {
        return this.ake;
    }

    public boolean xH() {
        return this.akf == 1;
    }
}
