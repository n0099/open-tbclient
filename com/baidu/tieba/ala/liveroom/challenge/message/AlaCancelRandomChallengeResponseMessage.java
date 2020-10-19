package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gIt;
    private int gIu;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.gIu = -1;
        this.gIt = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gIu = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gIt = new com.baidu.live.challenge.a();
                this.gIt.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bUd() {
        return this.gIt;
    }

    public boolean bUf() {
        return this.gIu == 1;
    }
}
