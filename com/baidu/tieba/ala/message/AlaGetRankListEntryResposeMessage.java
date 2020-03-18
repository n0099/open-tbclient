package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fpJ;
    public int fpK;
    public int fpL;
    public int fpM;
    public int fpN;
    public int fpO;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fpJ = -1;
        this.fpK = -1;
        this.fpL = -1;
        this.fpM = -1;
        this.fpN = -1;
        this.fpO = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fpJ = jSONObject.optInt("game-day");
            this.fpK = jSONObject.optInt("flower-week");
            this.fpL = jSONObject.optInt("rich-week");
            this.fpM = jSONObject.optInt("hot-week");
            this.fpN = jSONObject.optInt("charm-week");
            this.fpO = jSONObject.optInt("pk_rank_no");
        }
    }
}
