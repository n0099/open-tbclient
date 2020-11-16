package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hxO;
    public int hxP;
    public int hxQ;
    public int hxR;
    public int hxS;
    public int hxT;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hxO = -1;
        this.hxP = -1;
        this.hxQ = -1;
        this.hxR = -1;
        this.hxS = -1;
        this.hxT = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hxO = jSONObject.optInt("game-day");
            this.hxP = jSONObject.optInt("flower-week");
            this.hxQ = jSONObject.optInt("rich-week");
            this.hxR = jSONObject.optInt("hot-week");
            this.hxS = jSONObject.optInt("charm-week");
            this.hxT = jSONObject.optInt("pk_rank_no");
        }
    }
}
