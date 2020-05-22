package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int fNx;
    private com.baidu.live.challenge.a fNy;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.fNx = -1;
        this.fNy = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fNx = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.fNy = new com.baidu.live.challenge.a();
                this.fNy.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bzJ() {
        return this.fNy;
    }

    public boolean bzK() {
        return this.fNx == 1;
    }
}
