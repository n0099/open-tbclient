package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String gBq;
    public String gBr;
    public int gBu;
    public String gBv;
    public int gBw;
    public int gBx;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gBu = 0;
                this.gBq = jSONObject.optString("task_url");
                this.gBr = jSONObject.optString("rule_h5");
                this.gBv = jSONObject.optString("pre_page_url");
                this.gBw = jSONObject.optInt("total_task_num");
                this.gBx = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
