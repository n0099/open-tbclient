package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dmQ;
    private long dmR;
    private long dmS;
    private long dmT;
    private String dmU;
    private String dmV;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dmQ = jSONObject.optString("splash_video_url");
                this.dmR = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dmS = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dmT = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dmU = jSONObject.optString("splash_video_h5_url");
                this.dmV = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aJH() {
        return this.dmQ;
    }

    public long aJI() {
        return this.dmR;
    }

    public long aJJ() {
        return this.dmS;
    }

    public long aJK() {
        return this.dmT;
    }

    public String aJL() {
        return this.dmU;
    }

    public String aJM() {
        return this.dmV;
    }
}
