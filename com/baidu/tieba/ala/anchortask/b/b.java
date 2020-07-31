package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public a fCM;
    public String fCk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fCk = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.fCM = new a();
                    this.fCM.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
