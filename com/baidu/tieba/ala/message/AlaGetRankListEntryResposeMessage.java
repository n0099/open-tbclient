package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fUe;
    public int fUf;
    public int fUg;
    public int fUh;
    public int fUi;
    public int fUj;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fUe = -1;
        this.fUf = -1;
        this.fUg = -1;
        this.fUh = -1;
        this.fUi = -1;
        this.fUj = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fUe = jSONObject.optInt("game-day");
            this.fUf = jSONObject.optInt("flower-week");
            this.fUg = jSONObject.optInt("rich-week");
            this.fUh = jSONObject.optInt("hot-week");
            this.fUi = jSONObject.optInt("charm-week");
            this.fUj = jSONObject.optInt("pk_rank_no");
        }
    }
}
