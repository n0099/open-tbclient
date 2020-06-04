package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fme;
    public int fmf;
    public int fmg;
    public int fmh;
    public int fmi;
    public int fmj;
    public long fmk;
    public long fml;
    public long fmm;
    public long fmn;
    public int fmo;
    public int fmp;
    public int fmq;
    public int fmr;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fme = jSONObject.optInt("last_identity");
                this.fmf = jSONObject.optInt("last_class");
                this.fmg = jSONObject.optInt("now_identity");
                this.fmh = jSONObject.optInt("now_class");
                this.fmi = jSONObject.optInt("cur_share_proportion");
                this.fmj = jSONObject.optInt("will_share_proportion");
                this.fmk = jSONObject.optLong("task_begin_time");
                this.fml = jSONObject.optLong("task_end_time");
                this.fmm = jSONObject.optLong("valid_live_time");
                this.fmn = jSONObject.optLong("charm_income");
                this.fmo = jSONObject.optInt("valid_live_day");
                this.fmp = jSONObject.optInt("task_type");
                this.fmq = jSONObject.optInt("task_finish_ratio");
                this.fmr = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
