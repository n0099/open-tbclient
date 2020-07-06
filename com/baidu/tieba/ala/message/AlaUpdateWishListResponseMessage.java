package com.baidu.tieba.ala.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaUpdateWishListResponseMessage extends JsonHttpResponsedMessage {
    private j gwm;

    public AlaUpdateWishListResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            this.gwm = new j();
            if (optJSONObject != null) {
                this.gwm.parserJson(optJSONObject);
            }
        }
    }

    public j bKL() {
        return this.gwm;
    }
}
