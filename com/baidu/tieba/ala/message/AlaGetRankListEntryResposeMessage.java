package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hTA;
    public int hTB;
    public int hTC;
    public int hTD;
    public int hTE;
    public int hTz;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hTz = -1;
        this.hTA = -1;
        this.hTB = -1;
        this.hTC = -1;
        this.hTD = -1;
        this.hTE = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hTz = jSONObject.optInt("game-day");
            this.hTA = jSONObject.optInt("flower-week");
            this.hTB = jSONObject.optInt("rich-week");
            this.hTC = jSONObject.optInt("hot-week");
            this.hTD = jSONObject.optInt("charm-week");
            this.hTE = jSONObject.optInt("pk_rank_no");
        }
    }
}
