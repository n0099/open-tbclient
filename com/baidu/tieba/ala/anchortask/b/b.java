package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int gBA;
    public int gBB;
    public int gBC;
    public int gBD;
    public int gBE;
    public int gBF;
    public long gBG;
    public long gBH;
    public long gBI;
    public long gBJ;
    public int gBK;
    public int gBL;
    public int gBM;
    public int gBN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gBA = jSONObject.optInt("last_identity");
                this.gBB = jSONObject.optInt("last_class");
                this.gBC = jSONObject.optInt("now_identity");
                this.gBD = jSONObject.optInt("now_class");
                this.gBE = jSONObject.optInt("cur_share_proportion");
                this.gBF = jSONObject.optInt("will_share_proportion");
                this.gBG = jSONObject.optLong("task_begin_time");
                this.gBH = jSONObject.optLong("task_end_time");
                this.gBI = jSONObject.optLong("valid_live_time");
                this.gBJ = jSONObject.optLong("charm_income");
                this.gBK = jSONObject.optInt("valid_live_day");
                this.gBL = jSONObject.optInt("task_type");
                this.gBM = jSONObject.optInt("task_finish_ratio");
                this.gBN = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
