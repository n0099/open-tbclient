package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a fNJ;
    private int fNK;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.fNK = -1;
        this.fNJ = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fNK = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.fNJ = new com.baidu.live.challenge.a();
                this.fNJ.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bzL() {
        return this.fNJ;
    }

    public boolean bzN() {
        return this.fNK == 1;
    }
}
