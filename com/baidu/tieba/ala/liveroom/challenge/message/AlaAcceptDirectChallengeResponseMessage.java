package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int gqG;
    private com.baidu.live.challenge.a gqH;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.gqG = -1;
        this.gqH = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gqG = optJSONObject.optInt("accept_status", -1);
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

    public boolean bPv() {
        return this.gqG == 1;
    }
}
