package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String gNb;
    public String gNc;
    public int gNf;
    public String gNg;
    public int gNh;
    public int gNi;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gNf = 0;
                this.gNb = jSONObject.optString("task_url");
                this.gNc = jSONObject.optString("rule_h5");
                this.gNg = jSONObject.optString("pre_page_url");
                this.gNh = jSONObject.optInt("total_task_num");
                this.gNi = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
