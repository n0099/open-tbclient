package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String eqA;
    public a erc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eqA = jSONObject.optString("task_h5url");
                JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject != null) {
                    this.erc = new a();
                    this.erc.parseJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
