package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private String aOA;
    private String aOv;
    private long aOw;
    private long aOx;
    private long aOy;
    private String aOz;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aOv = jSONObject.optString("splash_video_url");
                this.aOw = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aOx = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aOy = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aOz = jSONObject.optString("splash_video_h5_url");
                this.aOA = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String GY() {
        return this.aOv;
    }

    public long GZ() {
        return this.aOw;
    }

    public long Ha() {
        return this.aOx;
    }

    public long Hb() {
        return this.aOy;
    }

    public String Hc() {
        return this.aOz;
    }

    public String Hd() {
        return this.aOA;
    }
}
