package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gqH;
    private int gqI;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.gqI = -1;
        this.gqH = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gqI = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gqH = new com.baidu.live.challenge.a();
                this.gqH.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bPu() {
        return this.gqH;
    }

    public boolean bPw() {
        return this.gqI == 1;
    }
}
