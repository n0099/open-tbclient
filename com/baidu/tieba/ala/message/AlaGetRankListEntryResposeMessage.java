package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gjn;
    public int gjo;
    public int gjp;
    public int gjq;
    public int gjr;
    public int gjs;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gjn = -1;
        this.gjo = -1;
        this.gjp = -1;
        this.gjq = -1;
        this.gjr = -1;
        this.gjs = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gjn = jSONObject.optInt("game-day");
            this.gjo = jSONObject.optInt("flower-week");
            this.gjp = jSONObject.optInt("rich-week");
            this.gjq = jSONObject.optInt("hot-week");
            this.gjr = jSONObject.optInt("charm-week");
            this.gjs = jSONObject.optInt("pk_rank_no");
        }
    }
}
