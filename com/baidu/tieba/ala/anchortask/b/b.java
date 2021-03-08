package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int gNj;
    public int gNk;
    public int gNl;
    public int gNm;
    public int gNn;
    public int gNo;
    public long gNp;
    public long gNq;
    public long gNr;
    public long gNs;
    public int gNt;
    public int gNu;
    public int gNv;
    public int gNw;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gNj = jSONObject.optInt("last_identity");
                this.gNk = jSONObject.optInt("last_class");
                this.gNl = jSONObject.optInt("now_identity");
                this.gNm = jSONObject.optInt("now_class");
                this.gNn = jSONObject.optInt("cur_share_proportion");
                this.gNo = jSONObject.optInt("will_share_proportion");
                this.gNp = jSONObject.optLong("task_begin_time");
                this.gNq = jSONObject.optLong("task_end_time");
                this.gNr = jSONObject.optLong("valid_live_time");
                this.gNs = jSONObject.optLong("charm_income");
                this.gNt = jSONObject.optInt("valid_live_day");
                this.gNu = jSONObject.optInt("task_type");
                this.gNv = jSONObject.optInt("task_finish_ratio");
                this.gNw = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
