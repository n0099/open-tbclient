package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private v dZe;
    private w dZf;
    private w dZg;

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
                    this.dZe = new v();
                    this.dZe.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.dZf = new w();
                    this.dZf.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.dZg = new w();
                    this.dZg.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public v aQj() {
        return this.dZe;
    }

    public w aQk() {
        return this.dZf;
    }

    public w aQl() {
        return this.dZg;
    }
}
