package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private long cfA;
    private long cfB;
    private long cfC;
    private String cfD;
    private String cfE;
    private String cfz;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cfz = jSONObject.optString("splash_video_url");
                this.cfA = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cfB = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cfC = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cfD = jSONObject.optString("splash_video_h5_url");
                this.cfE = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String alC() {
        return this.cfz;
    }

    public long alD() {
        return this.cfA;
    }

    public long alE() {
        return this.cfB;
    }

    public long alF() {
        return this.cfC;
    }

    public String alG() {
        return this.cfD;
    }

    public String alH() {
        return this.cfE;
    }
}
