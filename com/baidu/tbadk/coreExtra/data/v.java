package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.data.k {
    private long mStartTime = Long.MAX_VALUE;
    private long baF = 0;
    private String cvw = null;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStartTime = jSONObject.optLong("start_time", Long.MAX_VALUE);
                this.baF = jSONObject.optLong("end_time", 0L);
                this.cvw = jSONObject.optString("dest_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.baF;
    }

    public String app() {
        return this.cvw;
    }
}
