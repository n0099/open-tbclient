package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String aCA;
    private long aCB;
    private long aCC;
    private long aCD;
    private String aCE;
    private String aCF;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCA = jSONObject.optString("splash_video_url");
                this.aCB = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aCC = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aCD = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aCE = jSONObject.optString("splash_video_h5_url");
                this.aCF = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Cw() {
        return this.aCA;
    }

    public long Cx() {
        return this.aCB;
    }

    public long Cy() {
        return this.aCC;
    }

    public long Cz() {
        return this.aCD;
    }

    public String CA() {
        return this.aCE;
    }

    public String CB() {
        return this.aCF;
    }
}
