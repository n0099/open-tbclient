package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int fpj;
    public int fpk;
    public int fpl;
    public int fpm;
    public int fpn;
    public int fpo;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.fpj = -1;
        this.fpk = -1;
        this.fpl = -1;
        this.fpm = -1;
        this.fpn = -1;
        this.fpo = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.fpj = jSONObject.optInt("game-day");
            this.fpk = jSONObject.optInt("flower-week");
            this.fpl = jSONObject.optInt("rich-week");
            this.fpm = jSONObject.optInt("hot-week");
            this.fpn = jSONObject.optInt("charm-week");
            this.fpo = jSONObject.optInt("pk_rank_no");
        }
    }
}
