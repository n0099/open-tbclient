package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fUj;
    public int fUk;
    public int fUl;
    public int fUm;
    public int fUn;
    public int fUo;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fUj = -1;
        this.fUk = -1;
        this.fUl = -1;
        this.fUm = -1;
        this.fUn = -1;
        this.fUo = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fUj = jSONObject.optInt("game-day");
            this.fUk = jSONObject.optInt("flower-week");
            this.fUl = jSONObject.optInt("rich-week");
            this.fUm = jSONObject.optInt("hot-week");
            this.fUn = jSONObject.optInt("charm-week");
            this.fUo = jSONObject.optInt("pk_rank_no");
        }
    }
}
