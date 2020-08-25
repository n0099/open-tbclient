package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData aDE;
    private k fRf;
    private long fRg;
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
                this.fRf = new k();
                this.fRf.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_user_info");
            if (optJSONObject2 != null) {
                this.aDE = new AlaLiveUserInfoData();
                this.aDE.parserJson(optJSONObject2);
            }
            this.fRg = optJSONObject.optLong("live_total_price");
        }
    }

    public long bIu() {
        return this.mAudienceCount;
    }

    public k bIv() {
        return this.fRf;
    }

    public AlaLiveUserInfoData bIw() {
        return this.aDE;
    }

    public long bIx() {
        return this.fRg;
    }
}
