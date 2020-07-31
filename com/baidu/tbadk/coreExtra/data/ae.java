package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.as;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private String eqF;
    private long eqG;
    private long eqH;
    private long eqI;
    private String eqJ;
    private String eqK;

    public void parseJson(String str) {
        if (!as.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eqF = jSONObject.optString("splash_video_url");
                this.eqG = jSONObject.optLong("splash_video_start_time") * 1000;
                this.eqH = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eqI = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.eqJ = jSONObject.optString("splash_video_h5_url");
                this.eqK = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String beq() {
        return this.eqF;
    }

    public long ber() {
        return this.eqG;
    }

    public long bes() {
        return this.eqH;
    }

    public long bet() {
        return this.eqI;
    }

    public String beu() {
        return this.eqJ;
    }

    public String bev() {
        return this.eqK;
    }
}
