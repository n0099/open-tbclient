package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String cgE;
    private long cgF;
    private long cgG;
    private long cgH;
    private String cgI;
    private String cgJ;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cgE = jSONObject.optString("splash_video_url");
                this.cgF = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cgG = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cgH = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cgI = jSONObject.optString("splash_video_h5_url");
                this.cgJ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String amH() {
        return this.cgE;
    }

    public long amI() {
        return this.cgF;
    }

    public long amJ() {
        return this.cgG;
    }

    public long amK() {
        return this.cgH;
    }

    public String amL() {
        return this.cgI;
    }

    public String amM() {
        return this.cgJ;
    }
}
