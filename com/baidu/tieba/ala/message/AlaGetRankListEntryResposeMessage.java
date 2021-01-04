package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hTA;
    public int hTv;
    public int hTw;
    public int hTx;
    public int hTy;
    public int hTz;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hTv = -1;
        this.hTw = -1;
        this.hTx = -1;
        this.hTy = -1;
        this.hTz = -1;
        this.hTA = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTv = jSONObject.optInt("game-day");
            this.hTw = jSONObject.optInt("flower-week");
            this.hTx = jSONObject.optInt("rich-week");
            this.hTy = jSONObject.optInt("hot-week");
            this.hTz = jSONObject.optInt("charm-week");
            this.hTA = jSONObject.optInt("pk_rank_no");
        }
    }
}
