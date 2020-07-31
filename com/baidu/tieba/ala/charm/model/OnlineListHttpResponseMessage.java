package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private AlaLiveUserInfoData ayC;
    private k fFO;
    private long fFP;
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
                this.fFO = new k();
                this.fFO.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("current_user_info");
            if (optJSONObject2 != null) {
                this.ayC = new AlaLiveUserInfoData();
                this.ayC.parserJson(optJSONObject2);
            }
            this.fFP = optJSONObject.optLong("live_total_price");
        }
    }

    public long bzr() {
        return this.mAudienceCount;
    }

    public k bzs() {
        return this.fFO;
    }

    public AlaLiveUserInfoData bzt() {
        return this.ayC;
    }

    public long bzu() {
        return this.fFP;
    }
}
