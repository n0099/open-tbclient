package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hsk;
    public int hsl;
    public int hsm;
    public int hsn;
    public int hso;
    public int hsp;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hsk = -1;
        this.hsl = -1;
        this.hsm = -1;
        this.hsn = -1;
        this.hso = -1;
        this.hsp = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hsk = jSONObject.optInt("game-day");
            this.hsl = jSONObject.optInt("flower-week");
            this.hsm = jSONObject.optInt("rich-week");
            this.hsn = jSONObject.optInt("hot-week");
            this.hso = jSONObject.optInt("charm-week");
            this.hsp = jSONObject.optInt("pk_rank_no");
        }
    }
}
