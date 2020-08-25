package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int gqC;
    private com.baidu.live.challenge.a gqD;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.gqC = -1;
        this.gqD = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gqC = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gqD = new com.baidu.live.challenge.a();
                this.gqD.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bPt() {
        return this.gqD;
    }

    public boolean bPu() {
        return this.gqC == 1;
    }
}
