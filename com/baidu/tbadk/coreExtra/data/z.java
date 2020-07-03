package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.m {
    private long mStartTime = Long.MAX_VALUE;
    private long mEndTime = 0;
    private String eki = null;

    @Override // com.baidu.tbadk.core.data.m
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStartTime = jSONObject.optLong("start_time", Long.MAX_VALUE);
                this.mEndTime = jSONObject.optLong("end_time", 0L);
                this.eki = jSONObject.optString("dest_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bal() {
        return this.eki;
    }
}
