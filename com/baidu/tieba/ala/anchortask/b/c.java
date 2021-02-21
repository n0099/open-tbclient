package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public String gKX;
    public b gLO;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gKX = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.gLO = new b();
                    this.gLO.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
