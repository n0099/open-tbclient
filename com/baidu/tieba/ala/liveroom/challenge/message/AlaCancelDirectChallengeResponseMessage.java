package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gZT;
    private int gZU;

    public AlaCancelDirectChallengeResponseMessage() {
        super(1021107);
        this.gZU = -1;
        this.gZT = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gZU = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gZT = new com.baidu.live.challenge.a();
                this.gZT.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bYX() {
        return this.gZT;
    }

    public boolean bYZ() {
        return this.gZU == 1;
    }
}
