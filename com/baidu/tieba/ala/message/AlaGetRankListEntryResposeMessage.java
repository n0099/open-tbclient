package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRankListEntryResposeMessage extends JsonHttpResponsedMessage {
    public int hVi;
    public int hVj;
    public int hVk;
    public int hVl;
    public int hVm;
    public int hVn;

    public AlaGetRankListEntryResposeMessage() {
        super(1021069);
        this.hVi = -1;
        this.hVj = -1;
        this.hVk = -1;
        this.hVl = -1;
        this.hVm = -1;
        this.hVn = -1;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
            this.hVi = jSONObject.optInt("game-day");
            this.hVj = jSONObject.optInt("flower-week");
            this.hVk = jSONObject.optInt("rich-week");
            this.hVl = jSONObject.optInt("hot-week");
            this.hVm = jSONObject.optInt("charm-week");
            this.hVn = jSONObject.optInt("pk_rank_no");
        }
    }
}
