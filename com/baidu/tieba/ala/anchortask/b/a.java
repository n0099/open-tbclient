package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int euZ;
    public int eva;
    public int evb;
    public int evc;
    public int evd;
    public int eve;
    public long evf;
    public long evg;
    public long evh;
    public long evi;
    public int evj;
    public int evk;
    public int evl;
    public int evm;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.euZ = jSONObject.optInt("last_identity");
                this.eva = jSONObject.optInt("last_class");
                this.evb = jSONObject.optInt("now_identity");
                this.evc = jSONObject.optInt("now_class");
                this.evd = jSONObject.optInt("cur_share_proportion");
                this.eve = jSONObject.optInt("will_share_proportion");
                this.evf = jSONObject.optLong("task_begin_time");
                this.evg = jSONObject.optLong("task_end_time");
                this.evh = jSONObject.optLong("valid_live_time");
                this.evi = jSONObject.optLong("charm_income");
                this.evj = jSONObject.optInt("valid_live_day");
                this.evk = jSONObject.optInt("task_type");
                this.evl = jSONObject.optInt("task_finish_ratio");
                this.evm = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
