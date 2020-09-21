package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int fRe;
    public int fRf;
    public int fRg;
    public int fRh;
    public int fRi;
    public int fRj;
    public long fRk;
    public long fRl;
    public long fRm;
    public long fRn;
    public int fRo;
    public int fRp;
    public int fRq;
    public int fRr;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fRe = jSONObject.optInt("last_identity");
                this.fRf = jSONObject.optInt("last_class");
                this.fRg = jSONObject.optInt("now_identity");
                this.fRh = jSONObject.optInt("now_class");
                this.fRi = jSONObject.optInt("cur_share_proportion");
                this.fRj = jSONObject.optInt("will_share_proportion");
                this.fRk = jSONObject.optLong("task_begin_time");
                this.fRl = jSONObject.optLong("task_end_time");
                this.fRm = jSONObject.optLong("valid_live_time");
                this.fRn = jSONObject.optLong("charm_income");
                this.fRo = jSONObject.optInt("valid_live_day");
                this.fRp = jSONObject.optInt("task_type");
                this.fRq = jSONObject.optInt("task_finish_ratio");
                this.fRr = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
