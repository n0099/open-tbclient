package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public int fNT;
    public int fNU;
    public int fNV;
    public int fNW;
    public int fNX;
    public int fNY;
    public long fNZ;
    public long fOa;
    public long fOb;
    public long fOc;
    public int fOd;
    public int fOe;
    public int fOf;
    public int fOg;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fNT = jSONObject.optInt("last_identity");
                this.fNU = jSONObject.optInt("last_class");
                this.fNV = jSONObject.optInt("now_identity");
                this.fNW = jSONObject.optInt("now_class");
                this.fNX = jSONObject.optInt("cur_share_proportion");
                this.fNY = jSONObject.optInt("will_share_proportion");
                this.fNZ = jSONObject.optLong("task_begin_time");
                this.fOa = jSONObject.optLong("task_end_time");
                this.fOb = jSONObject.optLong("valid_live_time");
                this.fOc = jSONObject.optLong("charm_income");
                this.fOd = jSONObject.optInt("valid_live_day");
                this.fOe = jSONObject.optInt("task_type");
                this.fOf = jSONObject.optInt("task_finish_ratio");
                this.fOg = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
