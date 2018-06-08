package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String aBL;
    private long aBM;
    private long aBN;
    private long aBO;
    private String aBP;
    private String aBQ;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aBL = jSONObject.optString("splash_video_url");
                this.aBM = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aBN = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aBO = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aBP = jSONObject.optString("splash_video_h5_url");
                this.aBQ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Cm() {
        return this.aBL;
    }

    public long Cn() {
        return this.aBM;
    }

    public long Co() {
        return this.aBN;
    }

    public long Cp() {
        return this.aBO;
    }

    public String Cq() {
        return this.aBP;
    }

    public String Cr() {
        return this.aBQ;
    }
}
