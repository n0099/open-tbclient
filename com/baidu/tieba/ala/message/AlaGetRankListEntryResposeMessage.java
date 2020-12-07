package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hHt;
    public int hHu;
    public int hHv;
    public int hHw;
    public int hHx;
    public int hHy;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hHt = -1;
        this.hHu = -1;
        this.hHv = -1;
        this.hHw = -1;
        this.hHx = -1;
        this.hHy = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hHt = jSONObject.optInt("game-day");
            this.hHu = jSONObject.optInt("flower-week");
            this.hHv = jSONObject.optInt("rich-week");
            this.hHw = jSONObject.optInt("hot-week");
            this.hHx = jSONObject.optInt("charm-week");
            this.hHy = jSONObject.optInt("pk_rank_no");
        }
    }
}
