package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hHA;
    public int hHv;
    public int hHw;
    public int hHx;
    public int hHy;
    public int hHz;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hHv = -1;
        this.hHw = -1;
        this.hHx = -1;
        this.hHy = -1;
        this.hHz = -1;
        this.hHA = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hHv = jSONObject.optInt("game-day");
            this.hHw = jSONObject.optInt("flower-week");
            this.hHx = jSONObject.optInt("rich-week");
            this.hHy = jSONObject.optInt("hot-week");
            this.hHz = jSONObject.optInt("charm-week");
            this.hHA = jSONObject.optInt("pk_rank_no");
        }
    }
}
