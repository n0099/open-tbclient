package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {
    private String aKW;
    private long aKX;
    private long aKY;
    private long aKZ;
    private String aLa;
    private String aLb;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aKW = jSONObject.optString("splash_video_url");
                this.aKX = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aKY = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aKZ = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aLa = jSONObject.optString("splash_video_h5_url");
                this.aLb = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String FU() {
        return this.aKW;
    }

    public long FV() {
        return this.aKX;
    }

    public long FW() {
        return this.aKY;
    }

    public long FX() {
        return this.aKZ;
    }

    public String FY() {
        return this.aLa;
    }

    public String FZ() {
        return this.aLb;
    }
}
