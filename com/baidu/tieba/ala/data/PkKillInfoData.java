package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkKillInfoData extends BaseData implements Serializable {
    public int countDown;
    public long endTime;
    public long startTime;
    public int status;
    public String tip;
    public String title;
    public long winner;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.status = jSONObject.optInt("status");
        this.title = jSONObject.optString("msg1");
        this.tip = jSONObject.optString("msg2");
        this.startTime = jSONObject.optLong("start_time");
        this.countDown = jSONObject.optInt("count_down");
        this.winner = jSONObject.optLong("winner");
        this.endTime = jSONObject.optLong("end_time");
    }

    public String toString() {
        return "PkKillInfoData{status=" + this.status + ", title='" + this.title + "', tip='" + this.tip + "', startTime=" + this.startTime + ", countDown=" + this.countDown + ", winner=" + this.winner + ", endTime=" + this.endTime + '}';
    }
}
