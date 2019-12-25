package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private String diA;
    private String div;
    private long diw;
    private long dix;
    private long diy;
    private String diz;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.div = jSONObject.optString("splash_video_url");
                this.diw = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dix = jSONObject.optLong("splash_video_end_time") * 1000;
                this.diy = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.diz = jSONObject.optString("splash_video_h5_url");
                this.diA = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aGS() {
        return this.div;
    }

    public long aGT() {
        return this.diw;
    }

    public long aGU() {
        return this.dix;
    }

    public long aGV() {
        return this.diy;
    }

    public String aGW() {
        return this.diz;
    }

    public String aGX() {
        return this.diA;
    }
}
