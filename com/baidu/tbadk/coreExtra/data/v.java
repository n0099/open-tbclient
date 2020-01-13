package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.google.android.exoplayer2.Format;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.data.k {
    private long mStartTime = Format.OFFSET_SAMPLE_RELATIVE;
    private long bDL = 0;
    private String diC = null;

    @Override // com.baidu.tbadk.core.data.k
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mStartTime = jSONObject.optLong("start_time", Format.OFFSET_SAMPLE_RELATIVE);
                this.bDL = jSONObject.optLong("end_time", 0L);
                this.diC = jSONObject.optString("dest_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public long getEndTime() {
        return this.bDL;
    }

    public String aHf() {
        return this.diC;
    }
}
