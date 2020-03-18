package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int evJ;
    public int evK;
    public int evL;
    public int evM;
    public int evN;
    public int evO;
    public long evP;
    public long evQ;
    public long evR;
    public long evS;
    public int evT;
    public int evU;
    public int evV;
    public int evW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.evJ = jSONObject.optInt("last_identity");
                this.evK = jSONObject.optInt("last_class");
                this.evL = jSONObject.optInt("now_identity");
                this.evM = jSONObject.optInt("now_class");
                this.evN = jSONObject.optInt("cur_share_proportion");
                this.evO = jSONObject.optInt("will_share_proportion");
                this.evP = jSONObject.optLong("task_begin_time");
                this.evQ = jSONObject.optLong("task_end_time");
                this.evR = jSONObject.optLong("valid_live_time");
                this.evS = jSONObject.optLong("charm_income");
                this.evT = jSONObject.optInt("valid_live_day");
                this.evU = jSONObject.optInt("task_type");
                this.evV = jSONObject.optInt("task_finish_ratio");
                this.evW = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
