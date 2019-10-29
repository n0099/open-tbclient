package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int dZP;
    private com.baidu.live.challenge.a dZQ;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.dZP = optJSONObject.optInt("accept_status");
            this.dZQ = new com.baidu.live.challenge.a();
            this.dZQ.parseJson(optJSONObject.optJSONObject("match_info"));
        }
    }

    public com.baidu.live.challenge.a aQi() {
        return this.dZQ;
    }

    public boolean aQj() {
        return this.dZP == 1;
    }
}
