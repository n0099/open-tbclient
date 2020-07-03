package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private long end_time;
    private String link_url;
    private long start_time;

    public String bak() {
        return this.link_url;
    }

    public long getStartTime() {
        return this.start_time;
    }

    public long getEndTime() {
        return this.end_time;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.link_url = jSONObject.optString("link_url", "");
            this.start_time = jSONObject.optLong("start_time", 0L);
            this.end_time = jSONObject.optLong("end_time", 0L);
        }
    }
}
