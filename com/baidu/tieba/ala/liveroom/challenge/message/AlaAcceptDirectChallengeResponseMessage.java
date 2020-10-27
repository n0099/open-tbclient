package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int gUh;
    private com.baidu.live.challenge.a gUi;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.gUh = -1;
        this.gUi = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gUh = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gUi = new com.baidu.live.challenge.a();
                this.gUi.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bXc() {
        return this.gUi;
    }

    public boolean bXd() {
        return this.gUh == 1;
    }
}
