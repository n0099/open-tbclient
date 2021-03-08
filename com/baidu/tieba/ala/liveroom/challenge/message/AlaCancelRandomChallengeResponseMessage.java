package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a hxa;
    private int hxb;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.hxb = -1;
        this.hxa = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hxb = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hxa = new com.baidu.live.challenge.a();
                this.hxa.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a cda() {
        return this.hxa;
    }

    public boolean cdc() {
        return this.hxb == 1;
    }
}
