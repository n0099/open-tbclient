package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private long aOA;
    private String aOB;
    private String aOC;
    private String aOx;
    private long aOy;
    private long aOz;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aOx = jSONObject.optString("splash_video_url");
                this.aOy = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aOz = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aOA = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aOB = jSONObject.optString("splash_video_h5_url");
                this.aOC = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String GZ() {
        return this.aOx;
    }

    public long Ha() {
        return this.aOy;
    }

    public long Hb() {
        return this.aOz;
    }

    public long Hc() {
        return this.aOA;
    }

    public String Hd() {
        return this.aOB;
    }

    public String He() {
        return this.aOC;
    }
}
