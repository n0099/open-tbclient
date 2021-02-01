package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String frB;
    private long frC;
    private long frD;
    private long frE;
    private String frF;
    private String frG;

    public void parseJson(String str) {
        if (!au.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.frB = jSONObject.optString("splash_video_url");
                this.frC = jSONObject.optLong("splash_video_start_time") * 1000;
                this.frD = jSONObject.optLong("splash_video_end_time") * 1000;
                this.frE = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.frF = jSONObject.optString("splash_video_h5_url");
                this.frG = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bwG() {
        return this.frB;
    }

    public long bwH() {
        return this.frC;
    }

    public long bwI() {
        return this.frD;
    }

    public long bwJ() {
        return this.frE;
    }

    public String bwK() {
        return this.frF;
    }

    public String bwL() {
        return this.frG;
    }
}
