package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int eqO;
    public int eqP;
    public int eqQ;
    public int eqR;
    public int eqS;
    public int eqT;
    public long eqU;
    public long eqV;
    public long eqW;
    public long eqX;
    public int eqY;
    public int eqZ;
    public int era;
    public int erb;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eqO = jSONObject.optInt("last_identity");
                this.eqP = jSONObject.optInt("last_class");
                this.eqQ = jSONObject.optInt("now_identity");
                this.eqR = jSONObject.optInt("now_class");
                this.eqS = jSONObject.optInt("cur_share_proportion");
                this.eqT = jSONObject.optInt("will_share_proportion");
                this.eqU = jSONObject.optLong("task_begin_time");
                this.eqV = jSONObject.optLong("task_end_time");
                this.eqW = jSONObject.optLong("valid_live_time");
                this.eqX = jSONObject.optLong("charm_income");
                this.eqY = jSONObject.optInt("valid_live_day");
                this.eqZ = jSONObject.optInt("task_type");
                this.era = jSONObject.optInt("task_finish_ratio");
                this.erb = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
