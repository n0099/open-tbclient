package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int gnA;
    public int gnB;
    public int gnC;
    public int gnD;
    public int gnE;
    public int gnF;
    public long gnG;
    public long gnH;
    public long gnI;
    public long gnJ;
    public int gnK;
    public int gnL;
    public int gnM;
    public int gnN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gnA = jSONObject.optInt("last_identity");
                this.gnB = jSONObject.optInt("last_class");
                this.gnC = jSONObject.optInt("now_identity");
                this.gnD = jSONObject.optInt("now_class");
                this.gnE = jSONObject.optInt("cur_share_proportion");
                this.gnF = jSONObject.optInt("will_share_proportion");
                this.gnG = jSONObject.optLong("task_begin_time");
                this.gnH = jSONObject.optLong("task_end_time");
                this.gnI = jSONObject.optLong("valid_live_time");
                this.gnJ = jSONObject.optLong("charm_income");
                this.gnK = jSONObject.optInt("valid_live_day");
                this.gnL = jSONObject.optInt("task_type");
                this.gnM = jSONObject.optInt("task_finish_ratio");
                this.gnN = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
