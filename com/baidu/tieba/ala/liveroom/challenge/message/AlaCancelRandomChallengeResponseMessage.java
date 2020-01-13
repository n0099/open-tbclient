package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a eQv;
    private int eQw;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eQw = optJSONObject.optInt("cancel_status");
            this.eQv = new com.baidu.live.challenge.a();
            this.eQv.parseJson(optJSONObject.optJSONObject("match_info"));
        }
    }

    public com.baidu.live.challenge.a biv() {
        return this.eQv;
    }

    public boolean bix() {
        return this.eQw == 1;
    }
}
