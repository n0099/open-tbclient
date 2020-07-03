package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public long fxA;
    public int fxB;
    public int fxC;
    public int fxD;
    public int fxE;
    public int fxr;
    public int fxs;
    public int fxt;
    public int fxu;
    public int fxv;
    public int fxw;
    public long fxx;
    public long fxy;
    public long fxz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fxr = jSONObject.optInt("last_identity");
                this.fxs = jSONObject.optInt("last_class");
                this.fxt = jSONObject.optInt("now_identity");
                this.fxu = jSONObject.optInt("now_class");
                this.fxv = jSONObject.optInt("cur_share_proportion");
                this.fxw = jSONObject.optInt("will_share_proportion");
                this.fxx = jSONObject.optLong("task_begin_time");
                this.fxy = jSONObject.optLong("task_end_time");
                this.fxz = jSONObject.optLong("valid_live_time");
                this.fxA = jSONObject.optLong("charm_income");
                this.fxB = jSONObject.optInt("valid_live_day");
                this.fxC = jSONObject.optInt("task_type");
                this.fxD = jSONObject.optInt("task_finish_ratio");
                this.fxE = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
