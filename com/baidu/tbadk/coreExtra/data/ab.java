package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dNl;
    private long dNm;
    private long dNn;
    private long dNo;
    private String dNp;
    private String dNq;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dNl = jSONObject.optString("splash_video_url");
                this.dNm = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dNn = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dNo = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dNp = jSONObject.optString("splash_video_h5_url");
                this.dNq = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aSj() {
        return this.dNl;
    }

    public long aSk() {
        return this.dNm;
    }

    public long aSl() {
        return this.dNn;
    }

    public long aSm() {
        return this.dNo;
    }

    public String aSn() {
        return this.dNp;
    }

    public String aSo() {
        return this.dNq;
    }
}
