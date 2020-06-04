package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int fNI;
    private com.baidu.live.challenge.a fNJ;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.fNI = -1;
        this.fNJ = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fNI = optJSONObject.optInt("accept_status", -1);
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

    public boolean bzM() {
        return this.fNI == 1;
    }
}
