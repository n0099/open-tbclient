package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dnq;
    private long dnr;
    private long dnt;
    private long dnu;
    private String dnv;
    private String dnw;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dnq = jSONObject.optString("splash_video_url");
                this.dnr = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dnt = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dnu = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dnv = jSONObject.optString("splash_video_h5_url");
                this.dnw = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aJM() {
        return this.dnq;
    }

    public long aJN() {
        return this.dnr;
    }

    public long aJO() {
        return this.dnt;
    }

    public long aJP() {
        return this.dnu;
    }

    public String aJQ() {
        return this.dnv;
    }

    public String aJR() {
        return this.dnw;
    }
}
