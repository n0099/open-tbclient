package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int gjc;
    public int gjd;
    public int gje;
    public int gjf;
    public int gjg;
    public int gjh;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.gjc = -1;
        this.gjd = -1;
        this.gje = -1;
        this.gjf = -1;
        this.gjg = -1;
        this.gjh = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.gjc = jSONObject.optInt("game-day");
            this.gjd = jSONObject.optInt("flower-week");
            this.gje = jSONObject.optInt("rich-week");
            this.gjf = jSONObject.optInt("hot-week");
            this.gjg = jSONObject.optInt("charm-week");
            this.gjh = jSONObject.optInt("pk_rank_no");
        }
    }
}
