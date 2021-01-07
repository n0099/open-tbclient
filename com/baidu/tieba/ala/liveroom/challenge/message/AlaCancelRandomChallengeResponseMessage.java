package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int hvA;
    private com.baidu.live.challenge.a hvz;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.hvA = -1;
        this.hvz = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hvA = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hvz = new com.baidu.live.challenge.a();
                this.hvz.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a cfK() {
        return this.hvz;
    }

    public boolean cfM() {
        return this.hvA == 1;
    }
}
