package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String bXC;
    private long bXD;
    private long bXE;
    private long bXF;
    private String bXG;
    private String bXH;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bXC = jSONObject.optString("splash_video_url");
                this.bXD = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bXE = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bXF = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bXG = jSONObject.optString("splash_video_h5_url");
                this.bXH = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String agD() {
        return this.bXC;
    }

    public long agE() {
        return this.bXD;
    }

    public long agF() {
        return this.bXE;
    }

    public long agG() {
        return this.bXF;
    }

    public String agH() {
        return this.bXG;
    }

    public String agI() {
        return this.bXH;
    }
}
