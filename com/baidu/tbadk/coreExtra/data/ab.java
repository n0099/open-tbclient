package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dNp;
    private long dNq;
    private long dNr;
    private long dNs;
    private String dNt;
    private String dNu;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dNp = jSONObject.optString("splash_video_url");
                this.dNq = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dNr = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dNs = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dNt = jSONObject.optString("splash_video_h5_url");
                this.dNu = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aSg() {
        return this.dNp;
    }

    public long aSh() {
        return this.dNq;
    }

    public long aSi() {
        return this.dNr;
    }

    public long aSj() {
        return this.dNs;
    }

    public String aSk() {
        return this.dNt;
    }

    public String aSl() {
        return this.dNu;
    }
}
