package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ad eUF;
    private ae eUG;
    private ae eUH;

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
                    this.eUF = new ad();
                    this.eUF.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.eUG = new ae();
                    this.eUG.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.eUH = new ae();
                    this.eUH.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public ad bkr() {
        return this.eUF;
    }

    public ae bks() {
        return this.eUG;
    }

    public ae bkt() {
        return this.eUH;
    }
}
