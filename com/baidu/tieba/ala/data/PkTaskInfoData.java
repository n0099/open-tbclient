package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkTaskInfoData extends BaseData implements Serializable {
    public String awardRate;
    public int countDown;
    public long endTime;
    public int nowNum;
    public long preStartTime;
    public long startTime;
    public int status;
    public String targetNum;
    public String tip;
    public String title;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.preStartTime = jSONObject.optLong("pre_start_time");
        this.startTime = jSONObject.optLong("start_time");
        this.status = jSONObject.optInt("status");
        this.awardRate = jSONObject.optString("award_rate");
        this.title = jSONObject.optString("task_head_text");
        this.tip = jSONObject.optString("task_title");
        this.targetNum = jSONObject.optString("target_num");
        this.nowNum = jSONObject.optInt("cur_num");
        this.countDown = jSONObject.optInt("count_down");
        this.endTime = jSONObject.optLong("end_time");
    }

    public String toString() {
        return "PkTaskInfoData{preStartTime=" + this.preStartTime + ", startTime=" + this.startTime + ", status=" + this.status + ", awardRate='" + this.awardRate + "', title='" + this.title + "', tip='" + this.tip + "', targetNum='" + this.targetNum + "', nowNum=" + this.nowNum + ", countDown=" + this.countDown + ", endTime=" + this.endTime + '}';
    }
}
