package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ac eQA;
    private ad eQB;
    private ad eQC;

    public AlaGetChallengeInfoResponseMessage() {
        super(1021112);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("challenge_info");
                if (optJSONObject2 != null) {
                    this.eQA = new ac();
                    this.eQA.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.eQB = new ad();
                    this.eQB.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.eQC = new ad();
                    this.eQC.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public ac biy() {
        return this.eQA;
    }

    public ad biz() {
        return this.eQB;
    }

    public ad biA() {
        return this.eQC;
    }
}
