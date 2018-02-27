package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.am;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String bhV;
    private long bhW;
    private long bhX;
    private long bhY;
    private String bhZ;
    private String bia;

    public void parseJson(String str) {
        if (!am.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bhV = jSONObject.optString("splash_video_url");
                this.bhW = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bhX = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bhY = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bhZ = jSONObject.optString("splash_video_h5_url");
                this.bia = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String FZ() {
        return this.bhV;
    }

    public long Ga() {
        return this.bhW;
    }

    public long Gb() {
        return this.bhX;
    }

    public long Gc() {
        return this.bhY;
    }

    public String Gd() {
        return this.bhZ;
    }

    public String Ge() {
        return this.bia;
    }
}
