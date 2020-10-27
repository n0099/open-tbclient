package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String eXL;
    private long eXM;
    private long eXN;
    private long eXO;
    private String eXP;
    private String eXQ;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eXL = jSONObject.optString("splash_video_url");
                this.eXM = jSONObject.optLong("splash_video_start_time") * 1000;
                this.eXN = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eXO = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.eXP = jSONObject.optString("splash_video_h5_url");
                this.eXQ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bsx() {
        return this.eXL;
    }

    public long bsy() {
        return this.eXM;
    }

    public long bsz() {
        return this.eXN;
    }

    public long bsA() {
        return this.eXO;
    }

    public String bsB() {
        return this.eXP;
    }

    public String bsC() {
        return this.eXQ;
    }
}
