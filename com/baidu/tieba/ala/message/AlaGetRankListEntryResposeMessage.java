package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gNY;
    public int gNZ;
    public int gOa;
    public int gOb;
    public int gOc;
    public int gOd;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gNY = -1;
        this.gNZ = -1;
        this.gOa = -1;
        this.gOb = -1;
        this.gOc = -1;
        this.gOd = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gNY = jSONObject.optInt("game-day");
            this.gNZ = jSONObject.optInt("flower-week");
            this.gOa = jSONObject.optInt("rich-week");
            this.gOb = jSONObject.optInt("hot-week");
            this.gOc = jSONObject.optInt("charm-week");
            this.gOd = jSONObject.optInt("pk_rank_no");
        }
    }
}
