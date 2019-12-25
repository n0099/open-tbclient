package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private y ePb;
    private z ePc;
    private z ePd;

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
                    this.ePb = new y();
                    this.ePb.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.ePc = new z();
                    this.ePc.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.ePd = new z();
                    this.ePd.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public y bhM() {
        return this.ePb;
    }

    public z bhN() {
        return this.ePc;
    }

    public z bhO() {
        return this.ePd;
    }
}
