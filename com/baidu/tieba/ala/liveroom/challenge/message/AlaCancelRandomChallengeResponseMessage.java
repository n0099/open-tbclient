package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a fZn;
    private int fZo;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.fZo = -1;
        this.fZn = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fZo = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.fZn = new com.baidu.live.challenge.a();
                this.fZn.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bCD() {
        return this.fZn;
    }

    public boolean bCF() {
        return this.fZo == 1;
    }
}
