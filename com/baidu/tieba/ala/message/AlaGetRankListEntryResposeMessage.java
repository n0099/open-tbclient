package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fms;
    public int fmt;
    public int fmu;
    public int fmv;
    public int fmw;
    public int fmx;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fms = -1;
        this.fmt = -1;
        this.fmu = -1;
        this.fmv = -1;
        this.fmw = -1;
        this.fmx = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fms = jSONObject.optInt("game-day");
            this.fmt = jSONObject.optInt("flower-week");
            this.fmu = jSONObject.optInt("rich-week");
            this.fmv = jSONObject.optInt("hot-week");
            this.fmw = jSONObject.optInt("charm-week");
            this.fmx = jSONObject.optInt("pk_rank_no");
        }
    }
}
