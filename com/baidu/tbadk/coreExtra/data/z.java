package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String cvB;
    private long cvC;
    private long cvD;
    private long cvE;
    private String cvF;
    private String cvG;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cvB = jSONObject.optString("splash_video_url");
                this.cvC = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cvD = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cvE = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cvF = jSONObject.optString("splash_video_h5_url");
                this.cvG = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String apw() {
        return this.cvB;
    }

    public long apx() {
        return this.cvC;
    }

    public long apy() {
        return this.cvD;
    }

    public long apz() {
        return this.cvE;
    }

    public String apA() {
        return this.cvF;
    }

    public String apB() {
        return this.cvG;
    }
}
