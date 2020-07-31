package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gBA;
    public int gBB;
    public int gBC;
    public int gBx;
    public int gBy;
    public int gBz;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gBx = -1;
        this.gBy = -1;
        this.gBz = -1;
        this.gBA = -1;
        this.gBB = -1;
        this.gBC = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gBx = jSONObject.optInt("game-day");
            this.gBy = jSONObject.optInt("flower-week");
            this.gBz = jSONObject.optInt("rich-week");
            this.gBA = jSONObject.optInt("hot-week");
            this.gBB = jSONObject.optInt("charm-week");
            this.gBC = jSONObject.optInt("pk_rank_no");
        }
    }
}
