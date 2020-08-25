package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ah {
    private String eAZ;
    private long eBa;
    private long eBb;
    private long eBc;
    private String eBd;
    private String eBe;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eAZ = jSONObject.optString("splash_video_url");
                this.eBa = jSONObject.optLong("splash_video_start_time") * 1000;
                this.eBb = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eBc = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.eBd = jSONObject.optString("splash_video_h5_url");
                this.eBe = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bna() {
        return this.eAZ;
    }

    public long bnb() {
        return this.eBa;
    }

    public long bnc() {
        return this.eBb;
    }

    public long bnd() {
        return this.eBc;
    }

    public String bne() {
        return this.eBd;
    }

    public String bnf() {
        return this.eBe;
    }
}
