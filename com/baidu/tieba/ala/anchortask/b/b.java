package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String flF;
    public a fmh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.flF = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.fmh = new a();
                    this.fmh.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
