package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData aIV;
    private q gwE;
    private long gwF;
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
                this.gwE = new q();
                this.gwE.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_user_info");
            if (optJSONObject2 != null) {
                this.aIV = new AlaLiveUserInfoData();
                this.aIV.parserJson(optJSONObject2);
            }
            this.gwF = optJSONObject.optLong("live_total_price");
        }
    }

    public long bRp() {
        return this.mAudienceCount;
    }

    public q bRq() {
        return this.gwE;
    }

    public AlaLiveUserInfoData bRr() {
        return this.aIV;
    }

    public long bRs() {
        return this.gwF;
    }
}
