package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gRo;
    public int gRp;
    public int gRq;
    public int gRr;
    public int gRs;
    public int gRt;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gRo = -1;
        this.gRp = -1;
        this.gRq = -1;
        this.gRr = -1;
        this.gRs = -1;
        this.gRt = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gRo = jSONObject.optInt("game-day");
            this.gRp = jSONObject.optInt("flower-week");
            this.gRq = jSONObject.optInt("rich-week");
            this.gRr = jSONObject.optInt("hot-week");
            this.gRs = jSONObject.optInt("charm-week");
            this.gRt = jSONObject.optInt("pk_rank_no");
        }
    }
}
