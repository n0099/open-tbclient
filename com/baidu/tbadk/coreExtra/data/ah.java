package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private String eBd;
    private long eBe;
    private long eBf;
    private long eBg;
    private String eBh;
    private String eBi;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eBd = jSONObject.optString("splash_video_url");
                this.eBe = jSONObject.optLong("splash_video_start_time") * 1000;
                this.eBf = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eBg = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.eBh = jSONObject.optString("splash_video_h5_url");
                this.eBi = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bna() {
        return this.eBd;
    }

    public long bnb() {
        return this.eBe;
    }

    public long bnc() {
        return this.eBf;
    }

    public long bnd() {
        return this.eBg;
    }

    public String bne() {
        return this.eBh;
    }

    public String bnf() {
        return this.eBi;
    }
}
