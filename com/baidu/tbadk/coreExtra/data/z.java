package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String cuK;
    private long cuL;
    private long cuM;
    private long cuN;
    private String cuO;
    private String cuP;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cuK = jSONObject.optString("splash_video_url");
                this.cuL = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cuM = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cuN = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cuO = jSONObject.optString("splash_video_h5_url");
                this.cuP = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String apu() {
        return this.cuK;
    }

    public long apv() {
        return this.cuL;
    }

    public long apw() {
        return this.cuM;
    }

    public long apx() {
        return this.cuN;
    }

    public String apy() {
        return this.cuO;
    }

    public String apz() {
        return this.cuP;
    }
}
