package com.baidu.tieba.ala.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaUpdateWishListResponseMessage extends JsonHttpResponsedMessage {
    private k gOk;

    public AlaUpdateWishListResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            this.gOk = new k();
            if (optJSONObject != null) {
                this.gOk.parserJson(optJSONObject);
            }
        }
    }

    public k bXS() {
        return this.gOk;
    }
}
