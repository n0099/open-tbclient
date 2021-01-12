package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public String gHZ;
    public b gIU;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gHZ = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.gIU = new b();
                    this.gIU.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
