package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int gtX;
    private com.baidu.live.challenge.a gtY;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.gtX = -1;
        this.gtY = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gtX = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.gtY = new com.baidu.live.challenge.a();
                this.gtY.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bQJ() {
        return this.gtY;
    }

    public boolean bQK() {
        return this.gtX == 1;
    }
}
