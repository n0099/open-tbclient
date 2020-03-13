package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String dnd;
    private long dne;
    private long dnf;
    private long dng;
    private String dnh;
    private String dni;

    public void parseJson(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.dnd = jSONObject.optString("splash_video_url");
                this.dne = jSONObject.optLong("splash_video_start_time") * 1000;
                this.dnf = jSONObject.optLong("splash_video_end_time") * 1000;
                this.dng = jSONObject.optLong("splash_video_interval_time") * 1000;
                this.dnh = jSONObject.optString("splash_video_h5_url");
                this.dni = jSONObject.optString("splash_video_h5_text");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String aJI() {
        return this.dnd;
    }

    public long aJJ() {
        return this.dne;
    }

    public long aJK() {
        return this.dnf;
    }

    public long aJL() {
        return this.dng;
    }

    public String aJM() {
        return this.dnh;
    }

    public String aJN() {
        return this.dni;
    }
}
