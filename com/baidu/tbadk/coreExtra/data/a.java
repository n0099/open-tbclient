package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int aji;
    private int ajk;
    private long ajl;
    private long ajm;
    private String ajn;
    private int ajh = 1;
    private c ajj = new c();

    public void parserJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.ajh = jSONObject.optInt("als_control", 1);
            this.aji = jSONObject.optInt("new_log_enabled", 0);
            this.ajj.parserJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("log_feed_control");
            if (optJSONObject != null) {
                this.ajk = optJSONObject.optInt("log_feed_switch", 0);
                this.ajl = optJSONObject.optLong(ThActivityDetailActivityConfig.START_TIME, -1L);
                this.ajm = optJSONObject.optLong(ThActivityDetailActivityConfig.END_TIME, -1L);
                this.ajn = optJSONObject.optString("ext_info");
            }
        }
    }

    public c xy() {
        return this.ajj;
    }

    public boolean xz() {
        return this.ajh > 0;
    }

    public boolean xA() {
        return this.aji > 0;
    }

    public boolean xB() {
        if (this.ajk == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.ajl < currentTimeMillis && currentTimeMillis < this.ajm;
        }
        return false;
    }

    public String xC() {
        return this.ajn;
    }
}
