package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String fdB;
    private long fdC;
    private long fdD;
    private long fdE;
    private String fdF;
    private String fdG;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fdB = jSONObject.optString("splash_video_url");
                this.fdC = jSONObject.optLong("splash_video_start_time") * 1000;
                this.fdD = jSONObject.optLong("splash_video_end_time") * 1000;
                this.fdE = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.fdF = jSONObject.optString("splash_video_h5_url");
                this.fdG = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String buX() {
        return this.fdB;
    }

    public long buY() {
        return this.fdC;
    }

    public long buZ() {
        return this.fdD;
    }

    public long bva() {
        return this.fdE;
    }

    public String bvb() {
        return this.fdF;
    }

    public String bvc() {
        return this.fdG;
    }
}
