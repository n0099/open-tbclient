package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.data.k {
    private long mStartTime = Long.MAX_VALUE;
    private long ban = 0;
    private String cuF = null;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStartTime = jSONObject.optLong("start_time", Long.MAX_VALUE);
                this.ban = jSONObject.optLong("end_time", 0L);
                this.cuF = jSONObject.optString("dest_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.ban;
    }

    public String apn() {
        return this.cuF;
    }
}
