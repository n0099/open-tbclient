package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.am;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String bhY;
    private long bhZ;
    private long bia;
    private long bib;
    private String bic;
    private String bie;

    public void parseJson(String str) {
        if (!am.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bhY = jSONObject.optString("splash_video_url");
                this.bhZ = jSONObject.optLong("splash_video_start_time") * 1000;
                this.bia = jSONObject.optLong("splash_video_end_time") * 1000;
                this.bib = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.bic = jSONObject.optString("splash_video_h5_url");
                this.bie = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Ga() {
        return this.bhY;
    }

    public long Gb() {
        return this.bhZ;
    }

    public long Gc() {
        return this.bia;
    }

    public long Gd() {
        return this.bib;
    }

    public String Ge() {
        return this.bic;
    }

    public String Gf() {
        return this.bie;
    }
}
