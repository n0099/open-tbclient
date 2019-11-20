package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int esi;
    public int esj;
    public int esk;
    public int esl;
    public int esm;
    public int esn;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.esi = -1;
        this.esj = -1;
        this.esk = -1;
        this.esl = -1;
        this.esm = -1;
        this.esn = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.esi = jSONObject.optInt("game-day");
            this.esj = jSONObject.optInt("flower-week");
            this.esk = jSONObject.optInt("rich-week");
            this.esl = jSONObject.optInt("hot-week");
            this.esm = jSONObject.optInt("charm-week");
            this.esn = jSONObject.optInt("pk_rank_no");
        }
    }
}
