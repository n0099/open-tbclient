package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String fNG;
    public a fOh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fNG = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.fOh = new a();
                    this.fOh.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
