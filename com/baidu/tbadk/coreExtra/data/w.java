package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.core.data.j {
    private long mStartTime = Long.MAX_VALUE;
    private long mEndTime = 0;
    private String ebx = null;

    @Override // com.baidu.tbadk.core.data.j
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStartTime = jSONObject.optLong("start_time", Long.MAX_VALUE);
                this.mEndTime = jSONObject.optLong("end_time", 0L);
                this.ebx = jSONObject.optString("dest_url", "");
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

    public String aYf() {
        return this.ebx;
    }
}
