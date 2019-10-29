package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int esZ;
    public int eta;
    public int etb;
    public int etd;
    public int ete;
    public int etf;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.esZ = -1;
        this.eta = -1;
        this.etb = -1;
        this.etd = -1;
        this.ete = -1;
        this.etf = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.esZ = jSONObject.optInt("game-day");
            this.eta = jSONObject.optInt("flower-week");
            this.etb = jSONObject.optInt("rich-week");
            this.etd = jSONObject.optInt("hot-week");
            this.ete = jSONObject.optInt("charm-week");
            this.etf = jSONObject.optInt("pk_rank_no");
        }
    }
}
