package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int fNP;
    public int fNQ;
    public int fNR;
    public int fNS;
    public int fNT;
    public int fNU;
    public long fNV;
    public long fNW;
    public long fNX;
    public long fNY;
    public int fNZ;
    public int fOa;
    public int fOb;
    public int fOc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fNP = jSONObject.optInt("last_identity");
                this.fNQ = jSONObject.optInt("last_class");
                this.fNR = jSONObject.optInt("now_identity");
                this.fNS = jSONObject.optInt("now_class");
                this.fNT = jSONObject.optInt("cur_share_proportion");
                this.fNU = jSONObject.optInt("will_share_proportion");
                this.fNV = jSONObject.optLong("task_begin_time");
                this.fNW = jSONObject.optLong("task_end_time");
                this.fNX = jSONObject.optLong("valid_live_time");
                this.fNY = jSONObject.optLong("charm_income");
                this.fNZ = jSONObject.optInt("valid_live_day");
                this.fOa = jSONObject.optInt("task_type");
                this.fOb = jSONObject.optInt("task_finish_ratio");
                this.fOc = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
