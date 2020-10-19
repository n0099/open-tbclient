package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hgl;
    public int hgm;
    public int hgn;
    public int hgo;
    public int hgp;
    public int hgq;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hgl = -1;
        this.hgm = -1;
        this.hgn = -1;
        this.hgo = -1;
        this.hgp = -1;
        this.hgq = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hgl = jSONObject.optInt("game-day");
            this.hgm = jSONObject.optInt("flower-week");
            this.hgn = jSONObject.optInt("rich-week");
            this.hgo = jSONObject.optInt("hot-week");
            this.hgp = jSONObject.optInt("charm-week");
            this.hgq = jSONObject.optInt("pk_rank_no");
        }
    }
}
