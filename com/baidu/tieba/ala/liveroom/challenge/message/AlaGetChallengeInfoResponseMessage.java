package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private v dZV;
    private w dZW;
    private w dZX;

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
                    this.dZV = new v();
                    this.dZV.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.dZW = new w();
                    this.dZW.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.dZX = new w();
                    this.dZX.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public v aQl() {
        return this.dZV;
    }

    public w aQm() {
        return this.dZW;
    }

    public w aQn() {
        return this.dZX;
    }
}
