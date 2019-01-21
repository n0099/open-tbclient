package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String aPb;
    private long aPc;
    private long aPd;
    private long aPe;
    private String aPf;
    private String aPg;

    public void parseJson(String str) {
        if (!ao.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPb = jSONObject.optString("splash_video_url");
                this.aPc = jSONObject.optLong("splash_video_start_time") * 1000;
                this.aPd = jSONObject.optLong("splash_video_end_time") * 1000;
                this.aPe = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.aPf = jSONObject.optString("splash_video_h5_url");
                this.aPg = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Hn() {
        return this.aPb;
    }

    public long Ho() {
        return this.aPc;
    }

    public long Hp() {
        return this.aPd;
    }

    public long Hq() {
        return this.aPe;
    }

    public String Hr() {
        return this.aPf;
    }

    public String Hs() {
        return this.aPg;
    }
}
