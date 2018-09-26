package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String aFD;
    private long aFE;
    private long aFF;
    private long aFG;
    private String aFH;
    private String aFI;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aFD = jSONObject.optString("splash_video_url");
                this.aFE = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aFF = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aFG = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aFH = jSONObject.optString("splash_video_h5_url");
                this.aFI = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String DH() {
        return this.aFD;
    }

    public long DI() {
        return this.aFE;
    }

    public long DJ() {
        return this.aFF;
    }

    public long DK() {
        return this.aFG;
    }

    public String DL() {
        return this.aFH;
    }

    public String DM() {
        return this.aFI;
    }
}
