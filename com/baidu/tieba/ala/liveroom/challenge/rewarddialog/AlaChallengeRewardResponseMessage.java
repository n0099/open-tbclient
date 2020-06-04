package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaChallengeRewardResponseMessage extends JsonHttpResponsedMessage {
    public AlaChallengeRewardData fPU;

    public AlaChallengeRewardResponseMessage() {
        super(1021104);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.fPU = new AlaChallengeRewardData();
            this.fPU.errno = getError();
            this.fPU.errMsg = getErrorString();
            this.fPU.parseJson(jSONObject);
        }
    }
}
