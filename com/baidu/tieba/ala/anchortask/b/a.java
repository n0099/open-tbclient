package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int epC;
    public int epD;
    public int epE;
    public int epF;
    public int epG;
    public int epH;
    public long epI;
    public long epJ;
    public long epK;
    public long epL;
    public int epM;
    public int epN;
    public int epO;
    public int epP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.epC = jSONObject.optInt("last_identity");
                this.epD = jSONObject.optInt("last_class");
                this.epE = jSONObject.optInt("now_identity");
                this.epF = jSONObject.optInt("now_class");
                this.epG = jSONObject.optInt("cur_share_proportion");
                this.epH = jSONObject.optInt("will_share_proportion");
                this.epI = jSONObject.optLong("task_begin_time");
                this.epJ = jSONObject.optLong("task_end_time");
                this.epK = jSONObject.optLong("valid_live_time");
                this.epL = jSONObject.optLong("charm_income");
                this.epM = jSONObject.optInt("valid_live_day");
                this.epN = jSONObject.optInt("task_type");
                this.epO = jSONObject.optInt("task_finish_ratio");
                this.epP = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
