package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private String cgL;
    private long cgM;
    private long cgN;
    private long cgO;
    private String cgP;
    private String cgQ;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cgL = jSONObject.optString("splash_video_url");
                this.cgM = jSONObject.optLong("splash_video_start_time") * 1000;
                this.cgN = jSONObject.optLong("splash_video_end_time") * 1000;
                this.cgO = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.cgP = jSONObject.optString("splash_video_h5_url");
                this.cgQ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String amJ() {
        return this.cgL;
    }

    public long amK() {
        return this.cgM;
    }

    public long amL() {
        return this.cgN;
    }

    public long amM() {
        return this.cgO;
    }

    public String amN() {
        return this.cgP;
    }

    public String amO() {
        return this.cgQ;
    }
}
