package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public int gNm;
    public int gNn;
    public int gNo;
    public int gNp;
    public int gNq;
    public int gNr;
    public long gNs;
    public long gNt;
    public long gNu;
    public long gNv;
    public int gNw;
    public int gNx;
    public int gNy;
    public int gNz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gNm = jSONObject.optInt("last_identity");
                this.gNn = jSONObject.optInt("last_class");
                this.gNo = jSONObject.optInt("now_identity");
                this.gNp = jSONObject.optInt("now_class");
                this.gNq = jSONObject.optInt("cur_share_proportion");
                this.gNr = jSONObject.optInt("will_share_proportion");
                this.gNs = jSONObject.optLong("task_begin_time");
                this.gNt = jSONObject.optLong("task_end_time");
                this.gNu = jSONObject.optLong("valid_live_time");
                this.gNv = jSONObject.optLong("charm_income");
                this.gNw = jSONObject.optInt("valid_live_day");
                this.gNx = jSONObject.optInt("task_type");
                this.gNy = jSONObject.optInt("task_finish_ratio");
                this.gNz = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
