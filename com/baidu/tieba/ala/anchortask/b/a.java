package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String gLe;
    public String gLf;
    public int gLi;
    public String gLj;
    public int gLk;
    public int gLl;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gLi = 0;
                this.gLe = jSONObject.optString("task_url");
                this.gLf = jSONObject.optString("rule_h5");
                this.gLj = jSONObject.optString("pre_page_url");
                this.gLk = jSONObject.optInt("total_task_num");
                this.gLl = jSONObject.optInt("finish_task_num");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
