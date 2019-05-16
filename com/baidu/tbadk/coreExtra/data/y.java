package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private long cfA;
    private long cfB;
    private String cfC;
    private String cfD;
    private String cfy;
    private long cfz;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cfy = jSONObject.optString("splash_video_url");
                this.cfz = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cfA = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cfB = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cfC = jSONObject.optString("splash_video_h5_url");
                this.cfD = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String alC() {
        return this.cfy;
    }

    public long alD() {
        return this.cfz;
    }

    public long alE() {
        return this.cfA;
    }

    public long alF() {
        return this.cfB;
    }

    public String alG() {
        return this.cfC;
    }

    public String alH() {
        return this.cfD;
    }
}
