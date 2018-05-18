package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.an;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String atE;
    private long atF;
    private long atG;
    private long atH;
    private String atI;
    private String atJ;

    public void parseJson(String str) {
        if (!an.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.atE = jSONObject.optString("splash_video_url");
                this.atF = jSONObject.optLong("splash_video_start_time") * 1000;
                this.atG = jSONObject.optLong("splash_video_end_time") * 1000;
                this.atH = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.atI = jSONObject.optString("splash_video_h5_url");
                this.atJ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String yM() {
        return this.atE;
    }

    public long yN() {
        return this.atF;
    }

    public long yO() {
        return this.atG;
    }

    public long yP() {
        return this.atH;
    }

    public String yQ() {
        return this.atI;
    }

    public String yR() {
        return this.atJ;
    }
}
