package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String diL;
    private long diM;
    private long diN;
    private long diO;
    private String diP;
    private String diQ;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.diL = jSONObject.optString("splash_video_url");
                this.diM = jSONObject.optLong("splash_video_start_time") * 1000;
                this.diN = jSONObject.optLong("splash_video_end_time") * 1000;
                this.diO = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.diP = jSONObject.optString("splash_video_h5_url");
                this.diQ = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aHm() {
        return this.diL;
    }

    public long aHn() {
        return this.diM;
    }

    public long aHo() {
        return this.diN;
    }

    public long aHp() {
        return this.diO;
    }

    public String aHq() {
        return this.diP;
    }

    public String aHr() {
        return this.diQ;
    }
}
