package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public int gLA;
    public int gLB;
    public int gLC;
    public int gLD;
    public int gLE;
    public int gLF;
    public long gLG;
    public long gLH;
    public long gLI;
    public long gLJ;
    public int gLK;
    public int gLL;
    public int gLM;
    public int gLN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gLA = jSONObject.optInt("last_identity");
                this.gLB = jSONObject.optInt("last_class");
                this.gLC = jSONObject.optInt("now_identity");
                this.gLD = jSONObject.optInt("now_class");
                this.gLE = jSONObject.optInt("cur_share_proportion");
                this.gLF = jSONObject.optInt("will_share_proportion");
                this.gLG = jSONObject.optLong("task_begin_time");
                this.gLH = jSONObject.optLong("task_end_time");
                this.gLI = jSONObject.optLong("valid_live_time");
                this.gLJ = jSONObject.optLong("charm_income");
                this.gLK = jSONObject.optInt("valid_live_day");
                this.gLL = jSONObject.optInt("task_type");
                this.gLM = jSONObject.optInt("task_finish_ratio");
                this.gLN = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
