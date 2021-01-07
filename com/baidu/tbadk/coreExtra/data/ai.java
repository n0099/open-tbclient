package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private String ftT;
    private long ftU;
    private long ftV;
    private long ftW;
    private String ftX;
    private String ftY;

    public void parseJson(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ftT = jSONObject.optString("splash_video_url");
                this.ftU = jSONObject.optLong("splash_video_start_time") * 1000;
                this.ftV = jSONObject.optLong("splash_video_end_time") * 1000;
                this.ftW = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.ftX = jSONObject.optString("splash_video_h5_url");
                this.ftY = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String bAi() {
        return this.ftT;
    }

    public long bAj() {
        return this.ftU;
    }

    public long bAk() {
        return this.ftV;
    }

    public long bAl() {
        return this.ftW;
    }

    public String bAm() {
        return this.ftX;
    }

    public String bAn() {
        return this.ftY;
    }
}
