package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a hvr;
    private int hvs;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.hvs = -1;
        this.hvr = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hvs = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hvr = new com.baidu.live.challenge.a();
                this.hvr.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a ccU() {
        return this.hvr;
    }

    public boolean ccW() {
        return this.hvs == 1;
    }
}
