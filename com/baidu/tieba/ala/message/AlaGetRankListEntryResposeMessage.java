package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fjh;
    public int fji;
    public int fjj;
    public int fjk;
    public int fjl;
    public int fjm;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fjh = -1;
        this.fji = -1;
        this.fjj = -1;
        this.fjk = -1;
        this.fjl = -1;
        this.fjm = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fjh = jSONObject.optInt("game-day");
            this.fji = jSONObject.optInt("flower-week");
            this.fjj = jSONObject.optInt("rich-week");
            this.fjk = jSONObject.optInt("hot-week");
            this.fjl = jSONObject.optInt("charm-week");
            this.fjm = jSONObject.optInt("pk_rank_no");
        }
    }
}
