package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hTl;
    public int hTm;
    public int hTn;
    public int hTo;
    public int hTp;
    public int hTq;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hTl = -1;
        this.hTm = -1;
        this.hTn = -1;
        this.hTo = -1;
        this.hTp = -1;
        this.hTq = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTl = jSONObject.optInt("game-day");
            this.hTm = jSONObject.optInt("flower-week");
            this.hTn = jSONObject.optInt("rich-week");
            this.hTo = jSONObject.optInt("hot-week");
            this.hTp = jSONObject.optInt("charm-week");
            this.hTq = jSONObject.optInt("pk_rank_no");
        }
    }
}
