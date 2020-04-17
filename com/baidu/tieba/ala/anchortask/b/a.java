package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int eZe;
    public int eZf;
    public int eZg;
    public int eZh;
    public int eZi;
    public int eZj;
    public long eZk;
    public long eZl;
    public long eZm;
    public long eZn;
    public int eZo;
    public int eZp;
    public int eZq;
    public int eZr;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eZe = jSONObject.optInt("last_identity");
                this.eZf = jSONObject.optInt("last_class");
                this.eZg = jSONObject.optInt("now_identity");
                this.eZh = jSONObject.optInt("now_class");
                this.eZi = jSONObject.optInt("cur_share_proportion");
                this.eZj = jSONObject.optInt("will_share_proportion");
                this.eZk = jSONObject.optLong("task_begin_time");
                this.eZl = jSONObject.optLong("task_end_time");
                this.eZm = jSONObject.optLong("valid_live_time");
                this.eZn = jSONObject.optLong("charm_income");
                this.eZo = jSONObject.optInt("valid_live_day");
                this.eZp = jSONObject.optInt("task_type");
                this.eZq = jSONObject.optInt("task_finish_ratio");
                this.eZr = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
