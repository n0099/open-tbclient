package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String gNe;
    public String gNf;
    public int gNi;
    public String gNj;
    public int gNk;
    public int gNl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gNi = 0;
                this.gNe = jSONObject.optString("task_url");
                this.gNf = jSONObject.optString("rule_h5");
                this.gNj = jSONObject.optString("pre_page_url");
                this.gNk = jSONObject.optInt("total_task_num");
                this.gNl = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
