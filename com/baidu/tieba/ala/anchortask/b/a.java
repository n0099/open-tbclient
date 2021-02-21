package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String gLs;
    public String gLt;
    public int gLw;
    public String gLx;
    public int gLy;
    public int gLz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gLw = 0;
                this.gLs = jSONObject.optString("task_url");
                this.gLt = jSONObject.optString("rule_h5");
                this.gLx = jSONObject.optString("pre_page_url");
                this.gLy = jSONObject.optInt("total_task_num");
                this.gLz = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
