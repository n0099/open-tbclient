package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String bXA;
    private long bXB;
    private long bXC;
    private long bXD;
    private String bXE;
    private String bXF;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bXA = jSONObject.optString("splash_video_url");
                this.bXB = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bXC = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bXD = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bXE = jSONObject.optString("splash_video_h5_url");
                this.bXF = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String agG() {
        return this.bXA;
    }

    public long agH() {
        return this.bXB;
    }

    public long agI() {
        return this.bXC;
    }

    public long agJ() {
        return this.bXD;
    }

    public String agK() {
        return this.bXE;
    }

    public String agL() {
        return this.bXF;
    }
}
