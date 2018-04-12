package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.an;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String atD;
    private long atE;
    private long atF;
    private long atG;
    private String atH;
    private String atI;

    public void parseJson(String str) {
        if (!an.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.atD = jSONObject.optString("splash_video_url");
                this.atE = jSONObject.optLong("splash_video_start_time") * 1000;
                this.atF = jSONObject.optLong("splash_video_end_time") * 1000;
                this.atG = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.atH = jSONObject.optString("splash_video_h5_url");
                this.atI = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String yN() {
        return this.atD;
    }

    public long yO() {
        return this.atE;
    }

    public long yP() {
        return this.atF;
    }

    public long yQ() {
        return this.atG;
    }

    public String yR() {
        return this.atH;
    }

    public String yS() {
        return this.atI;
    }
}
