package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hyh;
    public int hyi;
    public int hyj;
    public int hyk;
    public int hyl;
    public int hym;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hyh = -1;
        this.hyi = -1;
        this.hyj = -1;
        this.hyk = -1;
        this.hyl = -1;
        this.hym = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hyh = jSONObject.optInt("game-day");
            this.hyi = jSONObject.optInt("flower-week");
            this.hyj = jSONObject.optInt("rich-week");
            this.hyk = jSONObject.optInt("hot-week");
            this.hyl = jSONObject.optInt("charm-week");
            this.hym = jSONObject.optInt("pk_rank_no");
        }
    }
}
