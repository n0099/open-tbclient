package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String ePp;
    private long ePq;
    private long ePr;
    private long ePs;
    private String ePt;
    private String ePu;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ePp = jSONObject.optString("splash_video_url");
                this.ePq = jSONObject.optLong("splash_video_start_time") * 1000;
                this.ePr = jSONObject.optLong("splash_video_end_time") * 1000;
                this.ePs = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.ePt = jSONObject.optString("splash_video_h5_url");
                this.ePu = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bqE() {
        return this.ePp;
    }

    public long bqF() {
        return this.ePq;
    }

    public long bqG() {
        return this.ePr;
    }

    public long bqH() {
        return this.ePs;
    }

    public String bqI() {
        return this.ePt;
    }

    public String bqJ() {
        return this.ePu;
    }
}
