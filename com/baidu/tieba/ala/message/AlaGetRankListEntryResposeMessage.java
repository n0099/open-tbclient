package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int foW;
    public int foX;
    public int foY;
    public int foZ;
    public int fpa;
    public int fpb;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.foW = -1;
        this.foX = -1;
        this.foY = -1;
        this.foZ = -1;
        this.fpa = -1;
        this.fpb = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.foW = jSONObject.optInt("game-day");
            this.foX = jSONObject.optInt("flower-week");
            this.foY = jSONObject.optInt("rich-week");
            this.foZ = jSONObject.optInt("hot-week");
            this.fpa = jSONObject.optInt("charm-week");
            this.fpb = jSONObject.optInt("pk_rank_no");
        }
    }
}
