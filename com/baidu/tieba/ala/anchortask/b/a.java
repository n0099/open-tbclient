package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int gtA;
    public int gtn;
    public int gto;
    public int gtp;
    public int gtq;
    public int gtr;
    public int gts;
    public long gtt;
    public long gtu;
    public long gtv;
    public long gtw;
    public int gtx;
    public int gty;
    public int gtz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gtn = jSONObject.optInt("last_identity");
                this.gto = jSONObject.optInt("last_class");
                this.gtp = jSONObject.optInt("now_identity");
                this.gtq = jSONObject.optInt("now_class");
                this.gtr = jSONObject.optInt("cur_share_proportion");
                this.gts = jSONObject.optInt("will_share_proportion");
                this.gtt = jSONObject.optLong("task_begin_time");
                this.gtu = jSONObject.optLong("task_end_time");
                this.gtv = jSONObject.optLong("valid_live_time");
                this.gtw = jSONObject.optLong("charm_income");
                this.gtx = jSONObject.optInt("valid_live_day");
                this.gty = jSONObject.optInt("task_type");
                this.gtz = jSONObject.optInt("task_finish_ratio");
                this.gtA = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
