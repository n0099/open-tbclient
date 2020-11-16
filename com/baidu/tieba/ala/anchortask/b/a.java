package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int gsU;
    public int gsV;
    public int gsW;
    public int gsX;
    public int gsY;
    public int gsZ;
    public long gta;
    public long gtb;
    public long gtc;
    public long gtd;
    public int gte;
    public int gtf;
    public int gtg;
    public int gth;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gsU = jSONObject.optInt("last_identity");
                this.gsV = jSONObject.optInt("last_class");
                this.gsW = jSONObject.optInt("now_identity");
                this.gsX = jSONObject.optInt("now_class");
                this.gsY = jSONObject.optInt("cur_share_proportion");
                this.gsZ = jSONObject.optInt("will_share_proportion");
                this.gta = jSONObject.optLong("task_begin_time");
                this.gtb = jSONObject.optLong("task_end_time");
                this.gtc = jSONObject.optLong("valid_live_time");
                this.gtd = jSONObject.optLong("charm_income");
                this.gte = jSONObject.optInt("valid_live_day");
                this.gtf = jSONObject.optInt("task_type");
                this.gtg = jSONObject.optInt("task_finish_ratio");
                this.gth = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
