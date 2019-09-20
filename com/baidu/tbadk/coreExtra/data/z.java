package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String chG;
    private long chH;
    private long chI;
    private long chJ;
    private String chK;
    private String chL;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.chG = jSONObject.optString("splash_video_url");
                this.chH = jSONObject.optLong("splash_video_start_time") * 1000;
                this.chI = jSONObject.optLong("splash_video_end_time") * 1000;
                this.chJ = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.chK = jSONObject.optString("splash_video_h5_url");
                this.chL = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String amV() {
        return this.chG;
    }

    public long amW() {
        return this.chH;
    }

    public long amX() {
        return this.chI;
    }

    public long amY() {
        return this.chJ;
    }

    public String amZ() {
        return this.chK;
    }

    public String ana() {
        return this.chL;
    }
}
