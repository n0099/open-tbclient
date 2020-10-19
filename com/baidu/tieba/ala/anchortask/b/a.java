package com.baidu.tieba.ala.anchortask.b;

import com.baidu.live.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public int gdA;
    public int gdB;
    public long gdC;
    public long gdD;
    public long gdE;
    public long gdF;
    public int gdG;
    public int gdH;
    public int gdI;
    public int gdJ;
    public int gdw;
    public int gdx;
    public int gdy;
    public int gdz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gdw = jSONObject.optInt("last_identity");
                this.gdx = jSONObject.optInt("last_class");
                this.gdy = jSONObject.optInt("now_identity");
                this.gdz = jSONObject.optInt("now_class");
                this.gdA = jSONObject.optInt("cur_share_proportion");
                this.gdB = jSONObject.optInt("will_share_proportion");
                this.gdC = jSONObject.optLong("task_begin_time");
                this.gdD = jSONObject.optLong("task_end_time");
                this.gdE = jSONObject.optLong("valid_live_time");
                this.gdF = jSONObject.optLong("charm_income");
                this.gdG = jSONObject.optInt("valid_live_day");
                this.gdH = jSONObject.optInt("task_type");
                this.gdI = jSONObject.optInt("task_finish_ratio");
                this.gdJ = jSONObject.optInt("task_status");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
