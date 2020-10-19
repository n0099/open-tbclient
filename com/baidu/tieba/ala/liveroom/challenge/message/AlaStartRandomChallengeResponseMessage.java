package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaStartRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gIt;

    public AlaStartRandomChallengeResponseMessage() {
        super(1021110);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONObject2 = optJSONObject.optJSONObject("match_info")) != null) {
            this.gIt = new com.baidu.live.challenge.a();
            this.gIt.parseJson(optJSONObject2);
        }
    }

    public com.baidu.live.challenge.a bUd() {
        return this.gIt;
    }
}
