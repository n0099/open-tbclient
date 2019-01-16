package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String aPa;
    private long aPb;
    private long aPc;
    private long aPd;
    private String aPe;
    private String aPf;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPa = jSONObject.optString("splash_video_url");
                this.aPb = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aPc = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aPd = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aPe = jSONObject.optString("splash_video_h5_url");
                this.aPf = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Hn() {
        return this.aPa;
    }

    public long Ho() {
        return this.aPb;
    }

    public long Hp() {
        return this.aPc;
    }

    public long Hq() {
        return this.aPd;
    }

    public String Hr() {
        return this.aPe;
    }

    public String Hs() {
        return this.aPf;
    }
}
