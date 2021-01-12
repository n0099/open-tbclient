package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hOP;
    public int hOQ;
    public int hOR;
    public int hOS;
    public int hOT;
    public int hOU;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hOP = -1;
        this.hOQ = -1;
        this.hOR = -1;
        this.hOS = -1;
        this.hOT = -1;
        this.hOU = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hOP = jSONObject.optInt("game-day");
            this.hOQ = jSONObject.optInt("flower-week");
            this.hOR = jSONObject.optInt("rich-week");
            this.hOS = jSONObject.optInt("hot-week");
            this.hOT = jSONObject.optInt("charm-week");
            this.hOU = jSONObject.optInt("pk_rank_no");
        }
    }
}
