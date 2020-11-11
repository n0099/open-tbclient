package com.baidu.tieba.ala.message;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.m;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaUpdateWishListResponseMessage extends JsonHttpResponsedMessage {
    private m hyt;

    public AlaUpdateWishListResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            this.hyt = new m();
            if (optJSONObject != null) {
                this.hyt.parserJson(optJSONObject);
            }
        }
    }

    public m ciE() {
        return this.hyt;
    }
}
