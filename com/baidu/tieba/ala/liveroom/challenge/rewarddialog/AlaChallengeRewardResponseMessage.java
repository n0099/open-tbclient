package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaChallengeRewardResponseMessage extends JsonHttpResponsedMessage {
    public AlaChallengeRewardData gth;

    public AlaChallengeRewardResponseMessage() {
        super(1021104);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.gth = new AlaChallengeRewardData();
            this.gth.errno = getError();
            this.gth.errMsg = getErrorString();
            this.gth.parseJson(jSONObject);
        }
    }
}
