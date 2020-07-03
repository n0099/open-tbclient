package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int fZm;
    private com.baidu.live.challenge.a fZn;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.fZm = -1;
        this.fZn = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fZm = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.fZn = new com.baidu.live.challenge.a();
                this.fZn.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bCC() {
        return this.fZn;
    }

    public boolean bCD() {
        return this.fZm == 1;
    }
}
