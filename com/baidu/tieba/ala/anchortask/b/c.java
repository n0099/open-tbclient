package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public String gAV;
    public b gBO;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gAV = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.gBO = new b();
                    this.gBO.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
