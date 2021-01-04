package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int hvy;
    private com.baidu.live.challenge.a hvz;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.hvy = -1;
        this.hvz = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hvy = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hvz = new com.baidu.live.challenge.a();
                this.hvz.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a cfJ() {
        return this.hvz;
    }

    public boolean cfK() {
        return this.hvy == 1;
    }
}
