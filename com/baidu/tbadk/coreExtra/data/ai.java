package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String fki;
    private long fkj;
    private long fkk;
    private long fkl;
    private String fkm;
    private String fkn;

    public void parseJson(String str) {
        if (!au.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fki = jSONObject.optString("splash_video_url");
                this.fkj = jSONObject.optLong("splash_video_start_time") * 1000;
                this.fkk = jSONObject.optLong("splash_video_end_time") * 1000;
                this.fkl = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.fkm = jSONObject.optString("splash_video_h5_url");
                this.fkn = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bxN() {
        return this.fki;
    }

    public long bxO() {
        return this.fkj;
    }

    public long bxP() {
        return this.fkk;
    }

    public long bxQ() {
        return this.fkl;
    }

    public String bxR() {
        return this.fkm;
    }

    public String bxS() {
        return this.fkn;
    }
}
