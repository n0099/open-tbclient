package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private long aCA;
    private String aCB;
    private String aCC;
    private String aCx;
    private long aCy;
    private long aCz;

    public void parseJson(String str) {
        if (!ap.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCx = jSONObject.optString("splash_video_url");
                this.aCy = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aCz = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aCA = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aCB = jSONObject.optString("splash_video_h5_url");
                this.aCC = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Cu() {
        return this.aCx;
    }

    public long Cv() {
        return this.aCy;
    }

    public long Cw() {
        return this.aCz;
    }

    public long Cx() {
        return this.aCA;
    }

    public String Cy() {
        return this.aCB;
    }

    public String Cz() {
        return this.aCC;
    }
}
