package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private String ebG;
    private long ebH;
    private long ebI;
    private long ebJ;
    private String ebK;
    private String ebL;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ebG = jSONObject.optString("splash_video_url");
                this.ebH = jSONObject.optLong("splash_video_start_time") * 1000;
                this.ebI = jSONObject.optLong("splash_video_end_time") * 1000;
                this.ebJ = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.ebK = jSONObject.optString("splash_video_h5_url");
                this.ebL = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aYo() {
        return this.ebG;
    }

    public long aYp() {
        return this.ebH;
    }

    public long aYq() {
        return this.ebI;
    }

    public long aYr() {
        return this.ebJ;
    }

    public String aYs() {
        return this.ebK;
    }

    public String aYt() {
        return this.ebL;
    }
}
