package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gwa;
    public int gwb;
    public int gwc;
    public int gwd;
    public int gwe;
    public int gwf;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gwa = -1;
        this.gwb = -1;
        this.gwc = -1;
        this.gwd = -1;
        this.gwe = -1;
        this.gwf = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gwa = jSONObject.optInt("game-day");
            this.gwb = jSONObject.optInt("flower-week");
            this.gwc = jSONObject.optInt("rich-week");
            this.gwd = jSONObject.optInt("hot-week");
            this.gwe = jSONObject.optInt("charm-week");
            this.gwf = jSONObject.optInt("pk_rank_no");
        }
    }
}
