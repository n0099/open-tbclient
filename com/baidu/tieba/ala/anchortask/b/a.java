package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public int gIC;
    public String gID;
    public int gIE;
    public int gIF;
    public String gIy;
    public String gIz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gIC = 0;
                this.gIy = jSONObject.optString("task_url");
                this.gIz = jSONObject.optString("rule_h5");
                this.gID = jSONObject.optString("pre_page_url");
                this.gIE = jSONObject.optInt("total_task_num");
                this.gIF = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
