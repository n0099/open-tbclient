package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int foV;
    public int foW;
    public int foX;
    public int foY;
    public int foZ;
    public int fpa;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.foV = -1;
        this.foW = -1;
        this.foX = -1;
        this.foY = -1;
        this.foZ = -1;
        this.fpa = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.foV = jSONObject.optInt("game-day");
            this.foW = jSONObject.optInt("flower-week");
            this.foX = jSONObject.optInt("rich-week");
            this.foY = jSONObject.optInt("hot-week");
            this.foZ = jSONObject.optInt("charm-week");
            this.fpa = jSONObject.optInt("pk_rank_no");
        }
    }
}
