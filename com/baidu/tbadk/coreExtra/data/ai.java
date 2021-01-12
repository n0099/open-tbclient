package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String fph;
    private long fpi;
    private long fpj;
    private long fpk;
    private String fpl;
    private String fpm;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fph = jSONObject.optString("splash_video_url");
                this.fpi = jSONObject.optLong("splash_video_start_time") * 1000;
                this.fpj = jSONObject.optLong("splash_video_end_time") * 1000;
                this.fpk = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.fpl = jSONObject.optString("splash_video_h5_url");
                this.fpm = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bwo() {
        return this.fph;
    }

    public long bwp() {
        return this.fpi;
    }

    public long bwq() {
        return this.fpj;
    }

    public long bwr() {
        return this.fpk;
    }

    public String bws() {
        return this.fpl;
    }

    public String bwt() {
        return this.fpm;
    }
}
