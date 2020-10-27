package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaStartDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gUi;

    public AlaStartDirectChallengeResponseMessage() {
        super(1021106);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONObject2 = optJSONObject.optJSONObject("match_info")) != null) {
            this.gUi = new com.baidu.live.challenge.a();
            this.gUi.parseJson(optJSONObject2);
        }
    }

    public com.baidu.live.challenge.a bXc() {
        return this.gUi;
    }
}
