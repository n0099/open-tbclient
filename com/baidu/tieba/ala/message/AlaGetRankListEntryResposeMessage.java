package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gNU;
    public int gNV;
    public int gNW;
    public int gNX;
    public int gNY;
    public int gNZ;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gNU = -1;
        this.gNV = -1;
        this.gNW = -1;
        this.gNX = -1;
        this.gNY = -1;
        this.gNZ = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gNU = jSONObject.optInt("game-day");
            this.gNV = jSONObject.optInt("flower-week");
            this.gNW = jSONObject.optInt("rich-week");
            this.gNX = jSONObject.optInt("hot-week");
            this.gNY = jSONObject.optInt("charm-week");
            this.gNZ = jSONObject.optInt("pk_rank_no");
        }
    }
}
