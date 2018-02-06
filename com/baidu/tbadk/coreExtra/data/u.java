package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.am;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String bij;
    private long bik;
    private long bil;
    private long bim;
    private String bin;
    private String bio;

    public void parseJson(String str) {
        if (!am.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bij = jSONObject.optString("splash_video_url");
                this.bik = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bil = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bim = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bin = jSONObject.optString("splash_video_h5_url");
                this.bio = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Ga() {
        return this.bij;
    }

    public long Gb() {
        return this.bik;
    }

    public long Gc() {
        return this.bil;
    }

    public long Gd() {
        return this.bim;
    }

    public String Ge() {
        return this.bin;
    }

    public String Gf() {
        return this.bio;
    }
}
