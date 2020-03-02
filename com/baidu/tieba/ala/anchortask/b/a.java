package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int eva;
    public int evb;
    public int evc;
    public int evd;
    public int eve;
    public int evf;
    public long evg;
    public long evh;
    public long evi;
    public long evj;
    public int evk;
    public int evl;
    public int evm;
    public int evn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eva = jSONObject.optInt("last_identity");
                this.evb = jSONObject.optInt("last_class");
                this.evc = jSONObject.optInt("now_identity");
                this.evd = jSONObject.optInt("now_class");
                this.eve = jSONObject.optInt("cur_share_proportion");
                this.evf = jSONObject.optInt("will_share_proportion");
                this.evg = jSONObject.optLong("task_begin_time");
                this.evh = jSONObject.optLong("task_end_time");
                this.evi = jSONObject.optLong("valid_live_time");
                this.evj = jSONObject.optLong("charm_income");
                this.evk = jSONObject.optInt("valid_live_day");
                this.evl = jSONObject.optInt("task_type");
                this.evm = jSONObject.optInt("task_finish_ratio");
                this.evn = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
