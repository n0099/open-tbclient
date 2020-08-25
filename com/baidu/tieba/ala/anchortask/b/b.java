package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String fNC;
    public a fOd;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fNC = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.fOd = new a();
                    this.fOd.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
