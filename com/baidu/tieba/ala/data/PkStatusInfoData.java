package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkStatusInfoData extends BaseData implements Serializable {
    public long anchorScore;
    public long endTime;
    public long leadUserID;
    public long nowTime;
    public long pkID;
    public int pkStatus;
    public long rivalScore;
    public long stageEndTime;
    public long stageStartTime;
    public long startTime;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.anchorScore = jSONObject.optLong("anchor_honor");
        this.pkID = jSONObject.optLong("pk_id");
        this.pkStatus = jSONObject.optInt("pk_status");
        this.startTime = jSONObject.optLong("start_time");
        this.endTime = jSONObject.optLong("end_time");
        this.nowTime = jSONObject.optLong("now_time");
        this.rivalScore = jSONObject.optLong("rival_honor");
        this.stageEndTime = jSONObject.optLong("stage_end_time");
        this.stageStartTime = jSONObject.optLong("stage_start_time");
        this.leadUserID = jSONObject.optLong("lead_user_id");
    }
}
