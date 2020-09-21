package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String eDi;
    private long eDj;
    private long eDk;
    private long eDl;
    private String eDm;
    private String eDn;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eDi = jSONObject.optString("splash_video_url");
                this.eDj = jSONObject.optLong("splash_video_start_time") * 1000;
                this.eDk = jSONObject.optLong("splash_video_end_time") * 1000;
                this.eDl = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.eDm = jSONObject.optString("splash_video_h5_url");
                this.eDn = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bnU() {
        return this.eDi;
    }

    public long bnV() {
        return this.eDj;
    }

    public long bnW() {
        return this.eDk;
    }

    public long bnX() {
        return this.eDl;
    }

    public String bnY() {
        return this.eDm;
    }

    public String bnZ() {
        return this.eDn;
    }
}
