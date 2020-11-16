package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String fcJ;
    private long fcK;
    private long fcL;
    private long fcM;
    private String fcN;
    private String fcO;

    public void parseJson(String str) {
        if (!au.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fcJ = jSONObject.optString("splash_video_url");
                this.fcK = jSONObject.optLong("splash_video_start_time") * 1000;
                this.fcL = jSONObject.optLong("splash_video_end_time") * 1000;
                this.fcM = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.fcN = jSONObject.optString("splash_video_h5_url");
                this.fcO = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bun() {
        return this.fcJ;
    }

    public long buo() {
        return this.fcK;
    }

    public long bup() {
        return this.fcL;
    }

    public long buq() {
        return this.fcM;
    }

    public String bur() {
        return this.fcN;
    }

    public String bus() {
        return this.fcO;
    }
}
