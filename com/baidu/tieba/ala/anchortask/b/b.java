package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public int gLm;
    public int gLn;
    public int gLo;
    public int gLp;
    public int gLq;
    public int gLr;
    public long gLs;
    public long gLt;
    public long gLu;
    public long gLv;
    public int gLw;
    public int gLx;
    public int gLy;
    public int gLz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gLm = jSONObject.optInt("last_identity");
                this.gLn = jSONObject.optInt("last_class");
                this.gLo = jSONObject.optInt("now_identity");
                this.gLp = jSONObject.optInt("now_class");
                this.gLq = jSONObject.optInt("cur_share_proportion");
                this.gLr = jSONObject.optInt("will_share_proportion");
                this.gLs = jSONObject.optLong("task_begin_time");
                this.gLt = jSONObject.optLong("task_end_time");
                this.gLu = jSONObject.optLong("valid_live_time");
                this.gLv = jSONObject.optLong("charm_income");
                this.gLw = jSONObject.optInt("valid_live_day");
                this.gLx = jSONObject.optInt("task_type");
                this.gLy = jSONObject.optInt("task_finish_ratio");
                this.gLz = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
