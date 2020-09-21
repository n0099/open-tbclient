package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData aEz;
    private n fUu;
    private long fUv;
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
                this.fUu = new n();
                this.fUu.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_user_info");
            if (optJSONObject2 != null) {
                this.aEz = new AlaLiveUserInfoData();
                this.aEz.parserJson(optJSONObject2);
            }
            this.fUv = optJSONObject.optLong("live_total_price");
        }
    }

    public long bJD() {
        return this.mAudienceCount;
    }

    public n bJE() {
        return this.fUu;
    }

    public AlaLiveUserInfoData bJF() {
        return this.aEz;
    }

    public long bJG() {
        return this.fUv;
    }
}
