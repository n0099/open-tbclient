package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ad eUr;
    private ae eUs;
    private ae eUt;

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
                    this.eUr = new ad();
                    this.eUr.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.eUs = new ae();
                    this.eUs.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.eUt = new ae();
                    this.eUt.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public ad bko() {
        return this.eUr;
    }

    public ae bkp() {
        return this.eUs;
    }

    public ae bkq() {
        return this.eUt;
    }
}
