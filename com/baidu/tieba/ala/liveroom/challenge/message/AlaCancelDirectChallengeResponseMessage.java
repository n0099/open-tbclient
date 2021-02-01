package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaCancelDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a hvd;
    private int hve;

    public AlaCancelDirectChallengeResponseMessage() {
        super(1021107);
        this.hve = -1;
        this.hvd = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hve = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hvd = new com.baidu.live.challenge.a();
                this.hvd.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a ccN() {
        return this.hvd;
    }

    public boolean ccP() {
        return this.hve == 1;
    }
}
