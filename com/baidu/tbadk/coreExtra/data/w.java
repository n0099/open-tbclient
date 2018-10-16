package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String aKg;
    private long aKh;
    private long aKi;
    private long aKj;
    private String aKk;
    private String aKl;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aKg = jSONObject.optString("splash_video_url");
                this.aKh = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aKi = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aKj = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aKk = jSONObject.optString("splash_video_h5_url");
                this.aKl = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String FI() {
        return this.aKg;
    }

    public long FJ() {
        return this.aKh;
    }

    public long FK() {
        return this.aKi;
    }

    public long FL() {
        return this.aKj;
    }

    public String FM() {
        return this.aKk;
    }

    public String FN() {
        return this.aKl;
    }
}
