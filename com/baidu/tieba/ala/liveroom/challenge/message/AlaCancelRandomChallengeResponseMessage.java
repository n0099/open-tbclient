package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a ham;
    private int han;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.han = -1;
        this.ham = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.han = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.ham = new com.baidu.live.challenge.a();
                this.ham.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bZE() {
        return this.ham;
    }

    public boolean bZG() {
        return this.han == 1;
    }
}
