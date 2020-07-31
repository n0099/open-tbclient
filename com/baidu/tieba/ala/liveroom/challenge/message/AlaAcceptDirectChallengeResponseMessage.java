package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int geu;
    private com.baidu.live.challenge.a gev;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.geu = -1;
        this.gev = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.geu = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gev = new com.baidu.live.challenge.a();
                this.gev.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bFO() {
        return this.gev;
    }

    public boolean bFP() {
        return this.geu == 1;
    }
}
