package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int fCA;
    public int fCB;
    public int fCC;
    public int fCD;
    public long fCE;
    public long fCF;
    public long fCG;
    public long fCH;
    public int fCI;
    public int fCJ;
    public int fCK;
    public int fCL;
    public int fCy;
    public int fCz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fCy = jSONObject.optInt("last_identity");
                this.fCz = jSONObject.optInt("last_class");
                this.fCA = jSONObject.optInt("now_identity");
                this.fCB = jSONObject.optInt("now_class");
                this.fCC = jSONObject.optInt("cur_share_proportion");
                this.fCD = jSONObject.optInt("will_share_proportion");
                this.fCE = jSONObject.optLong("task_begin_time");
                this.fCF = jSONObject.optLong("task_end_time");
                this.fCG = jSONObject.optLong("valid_live_time");
                this.fCH = jSONObject.optLong("charm_income");
                this.fCI = jSONObject.optInt("valid_live_day");
                this.fCJ = jSONObject.optInt("task_type");
                this.fCK = jSONObject.optInt("task_finish_ratio");
                this.fCL = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
