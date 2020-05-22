package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int flT;
    public int flU;
    public int flV;
    public int flW;
    public int flX;
    public int flY;
    public long flZ;
    public long fma;
    public long fmb;
    public long fmc;
    public int fmd;
    public int fme;
    public int fmf;
    public int fmg;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.flT = jSONObject.optInt("last_identity");
                this.flU = jSONObject.optInt("last_class");
                this.flV = jSONObject.optInt("now_identity");
                this.flW = jSONObject.optInt("now_class");
                this.flX = jSONObject.optInt("cur_share_proportion");
                this.flY = jSONObject.optInt("will_share_proportion");
                this.flZ = jSONObject.optLong("task_begin_time");
                this.fma = jSONObject.optLong("task_end_time");
                this.fmb = jSONObject.optLong("valid_live_time");
                this.fmc = jSONObject.optLong("charm_income");
                this.fmd = jSONObject.optInt("valid_live_day");
                this.fme = jSONObject.optInt("task_type");
                this.fmf = jSONObject.optInt("task_finish_ratio");
                this.fmg = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
