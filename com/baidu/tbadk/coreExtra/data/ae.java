package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private String ekr;
    private long eks;
    private long ekt;
    private long eku;
    private String ekv;
    private String ekw;

    public void parseJson(String str) {
        if (!ar.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ekr = jSONObject.optString("splash_video_url");
                this.eks = jSONObject.optLong("splash_video_start_time") * 1000;
                this.ekt = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eku = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.ekv = jSONObject.optString("splash_video_h5_url");
                this.ekw = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bat() {
        return this.ekr;
    }

    public long bau() {
        return this.eks;
    }

    public long bav() {
        return this.ekt;
    }

    public long baw() {
        return this.eku;
    }

    public String bax() {
        return this.ekv;
    }

    public String bay() {
        return this.ekw;
    }
}
