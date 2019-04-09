package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String bXD;
    private long bXE;
    private long bXF;
    private long bXG;
    private String bXH;
    private String bXI;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bXD = jSONObject.optString("splash_video_url");
                this.bXE = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bXF = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bXG = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bXH = jSONObject.optString("splash_video_h5_url");
                this.bXI = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String agD() {
        return this.bXD;
    }

    public long agE() {
        return this.bXE;
    }

    public long agF() {
        return this.bXF;
    }

    public long agG() {
        return this.bXG;
    }

    public String agH() {
        return this.bXH;
    }

    public String agI() {
        return this.bXI;
    }
}
