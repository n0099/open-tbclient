package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int evA;
    public int evn;
    public int evo;
    public int evp;
    public int evq;
    public int evr;
    public int evs;
    public long evt;
    public long evu;
    public long evv;
    public long evw;
    public int evx;
    public int evy;
    public int evz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.evn = jSONObject.optInt("last_identity");
                this.evo = jSONObject.optInt("last_class");
                this.evp = jSONObject.optInt("now_identity");
                this.evq = jSONObject.optInt("now_class");
                this.evr = jSONObject.optInt("cur_share_proportion");
                this.evs = jSONObject.optInt("will_share_proportion");
                this.evt = jSONObject.optLong("task_begin_time");
                this.evu = jSONObject.optLong("task_end_time");
                this.evv = jSONObject.optLong("valid_live_time");
                this.evw = jSONObject.optLong("charm_income");
                this.evx = jSONObject.optInt("valid_live_day");
                this.evy = jSONObject.optInt("task_type");
                this.evz = jSONObject.optInt("task_finish_ratio");
                this.evA = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
