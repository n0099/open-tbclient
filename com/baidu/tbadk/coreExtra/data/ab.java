package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dmP;
    private long dmQ;
    private long dmR;
    private long dmS;
    private String dmT;
    private String dmU;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dmP = jSONObject.optString("splash_video_url");
                this.dmQ = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dmR = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dmS = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dmT = jSONObject.optString("splash_video_h5_url");
                this.dmU = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aJF() {
        return this.dmP;
    }

    public long aJG() {
        return this.dmQ;
    }

    public long aJH() {
        return this.dmR;
    }

    public long aJI() {
        return this.dmS;
    }

    public String aJJ() {
        return this.dmT;
    }

    public String aJK() {
        return this.dmU;
    }
}
