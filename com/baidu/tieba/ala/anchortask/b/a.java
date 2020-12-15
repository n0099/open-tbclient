package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String gBs;
    public String gBt;
    public int gBw;
    public String gBx;
    public int gBy;
    public int gBz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gBw = 0;
                this.gBs = jSONObject.optString("task_url");
                this.gBt = jSONObject.optString("rule_h5");
                this.gBx = jSONObject.optString("pre_page_url");
                this.gBy = jSONObject.optInt("total_task_num");
                this.gBz = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
