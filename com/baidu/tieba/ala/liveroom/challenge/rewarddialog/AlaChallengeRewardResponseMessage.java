package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaChallengeRewardResponseMessage extends JsonHttpResponsedMessage {
    public AlaChallengeRewardData eSL;

    public AlaChallengeRewardResponseMessage() {
        super(1021104);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.eSL = new AlaChallengeRewardData();
            this.eSL.errno = getError();
            this.eSL.errMsg = getErrorString();
            this.eSL.parseJson(jSONObject);
        }
    }
}
