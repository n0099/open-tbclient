package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private long bXA;
    private long bXB;
    private long bXC;
    private String bXD;
    private String bXE;
    private String bXz;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bXz = jSONObject.optString("splash_video_url");
                this.bXA = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bXB = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bXC = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bXD = jSONObject.optString("splash_video_h5_url");
                this.bXE = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String agG() {
        return this.bXz;
    }

    public long agH() {
        return this.bXA;
    }

    public long agI() {
        return this.bXB;
    }

    public long agJ() {
        return this.bXC;
    }

    public String agK() {
        return this.bXD;
    }

    public String agL() {
        return this.bXE;
    }
}
