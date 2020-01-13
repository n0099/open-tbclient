package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaCancelDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a eQv;
    private int eQw;

    public AlaCancelDirectChallengeResponseMessage() {
        super(1021107);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eQw = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.eQv = new com.baidu.live.challenge.a();
                this.eQv.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a biv() {
        return this.eQv;
    }

    public boolean bix() {
        return this.eQw == 1;
    }
}
