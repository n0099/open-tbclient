package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a gUi;
    private int gUj;

    public AlaCancelDirectChallengeResponseMessage() {
        super(1021107);
        this.gUj = -1;
        this.gUi = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gUj = optJSONObject.optInt("cancel_status");
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

    public boolean bXe() {
        return this.gUj == 1;
    }
}
