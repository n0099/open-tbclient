package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String fta;
    private long ftb;
    private long ftc;
    private long ftd;
    private String fte;
    private String ftf;

    public void parseJson(String str) {
        if (!au.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fta = jSONObject.optString("splash_video_url");
                this.ftb = jSONObject.optLong("splash_video_start_time") * 1000;
                this.ftc = jSONObject.optLong("splash_video_end_time") * 1000;
                this.ftd = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.fte = jSONObject.optString("splash_video_h5_url");
                this.ftf = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bwJ() {
        return this.fta;
    }

    public long bwK() {
        return this.ftb;
    }

    public long bwL() {
        return this.ftc;
    }

    public long bwM() {
        return this.ftd;
    }

    public String bwN() {
        return this.fte;
    }

    public String bwO() {
        return this.ftf;
    }
}
