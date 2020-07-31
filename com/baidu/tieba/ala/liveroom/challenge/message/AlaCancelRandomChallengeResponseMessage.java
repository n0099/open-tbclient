package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gev;
    private int gew;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.gew = -1;
        this.gev = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gew = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gev = new com.baidu.live.challenge.a();
                this.gev.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bFO() {
        return this.gev;
    }

    public boolean bFQ() {
        return this.gew == 1;
    }
}
