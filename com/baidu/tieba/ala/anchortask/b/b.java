package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int gIG;
    public int gIH;
    public int gII;
    public int gIJ;
    public int gIK;
    public int gIL;
    public long gIM;
    public long gIN;
    public long gIO;
    public long gIP;
    public int gIQ;
    public int gIR;
    public int gIS;
    public int gIT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gIG = jSONObject.optInt("last_identity");
                this.gIH = jSONObject.optInt("last_class");
                this.gII = jSONObject.optInt("now_identity");
                this.gIJ = jSONObject.optInt("now_class");
                this.gIK = jSONObject.optInt("cur_share_proportion");
                this.gIL = jSONObject.optInt("will_share_proportion");
                this.gIM = jSONObject.optLong("task_begin_time");
                this.gIN = jSONObject.optLong("task_end_time");
                this.gIO = jSONObject.optLong("valid_live_time");
                this.gIP = jSONObject.optLong("charm_income");
                this.gIQ = jSONObject.optInt("valid_live_day");
                this.gIR = jSONObject.optInt("task_type");
                this.gIS = jSONObject.optInt("task_finish_ratio");
                this.gIT = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
