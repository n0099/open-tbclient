package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String aCF;
    private long aCG;
    private long aCH;
    private long aCI;
    private String aCJ;
    private String aCK;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCF = jSONObject.optString("splash_video_url");
                this.aCG = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aCH = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aCI = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aCJ = jSONObject.optString("splash_video_h5_url");
                this.aCK = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String CE() {
        return this.aCF;
    }

    public long CF() {
        return this.aCG;
    }

    public long CG() {
        return this.aCH;
    }

    public long CH() {
        return this.aCI;
    }

    public String CI() {
        return this.aCJ;
    }

    public String CJ() {
        return this.aCK;
    }
}
