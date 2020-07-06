package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData axp;
    private k fAE;
    private long fAF;
    private long mAudienceCount;

    public OnlineListHttpResponseMessage() {
        super(1021008);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mAudienceCount = optJSONObject.optLong("audience_count");
            if (optJSONObject.optJSONArray("initmacy_rank") != null) {
                this.fAE = new k();
                this.fAE.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_user_info");
            if (optJSONObject2 != null) {
                this.axp = new AlaLiveUserInfoData();
                this.axp.parserJson(optJSONObject2);
            }
            this.fAF = optJSONObject.optLong("live_total_price");
        }
    }

    public long bwd() {
        return this.mAudienceCount;
    }

    public k bwe() {
        return this.fAE;
    }

    public AlaLiveUserInfoData bwf() {
        return this.axp;
    }

    public long bwg() {
        return this.fAF;
    }
}
