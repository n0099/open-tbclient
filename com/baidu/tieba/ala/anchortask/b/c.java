package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public String gMG;
    public b gNx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gMG = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.gNx = new b();
                    this.gNx.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
