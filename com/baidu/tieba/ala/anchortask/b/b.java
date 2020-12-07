package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int gBA;
    public int gBB;
    public int gBC;
    public int gBD;
    public long gBE;
    public long gBF;
    public long gBG;
    public long gBH;
    public int gBI;
    public int gBJ;
    public int gBK;
    public int gBL;
    public int gBy;
    public int gBz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gBy = jSONObject.optInt("last_identity");
                this.gBz = jSONObject.optInt("last_class");
                this.gBA = jSONObject.optInt("now_identity");
                this.gBB = jSONObject.optInt("now_class");
                this.gBC = jSONObject.optInt("cur_share_proportion");
                this.gBD = jSONObject.optInt("will_share_proportion");
                this.gBE = jSONObject.optLong("task_begin_time");
                this.gBF = jSONObject.optLong("task_end_time");
                this.gBG = jSONObject.optLong("valid_live_time");
                this.gBH = jSONObject.optLong("charm_income");
                this.gBI = jSONObject.optInt("valid_live_day");
                this.gBJ = jSONObject.optInt("task_type");
                this.gBK = jSONObject.optInt("task_finish_ratio");
                this.gBL = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
