package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int eZj;
    public int eZk;
    public int eZl;
    public int eZm;
    public int eZn;
    public int eZo;
    public long eZp;
    public long eZq;
    public long eZr;
    public long eZs;
    public int eZt;
    public int eZu;
    public int eZv;
    public int eZw;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eZj = jSONObject.optInt("last_identity");
                this.eZk = jSONObject.optInt("last_class");
                this.eZl = jSONObject.optInt("now_identity");
                this.eZm = jSONObject.optInt("now_class");
                this.eZn = jSONObject.optInt("cur_share_proportion");
                this.eZo = jSONObject.optInt("will_share_proportion");
                this.eZp = jSONObject.optLong("task_begin_time");
                this.eZq = jSONObject.optLong("task_end_time");
                this.eZr = jSONObject.optLong("valid_live_time");
                this.eZs = jSONObject.optLong("charm_income");
                this.eZt = jSONObject.optInt("valid_live_day");
                this.eZu = jSONObject.optInt("task_type");
                this.eZv = jSONObject.optInt("task_finish_ratio");
                this.eZw = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
