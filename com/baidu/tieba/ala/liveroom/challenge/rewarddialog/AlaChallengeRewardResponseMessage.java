package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaChallengeRewardResponseMessage extends JsonHttpResponsedMessage {
    public AlaChallengeRewardData hmv;

    public AlaChallengeRewardResponseMessage() {
        super(1021104);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.hmv = new AlaChallengeRewardData();
            this.hmv.errno = getError();
            this.hmv.errMsg = getErrorString();
            this.hmv.parseJson(jSONObject);
        }
    }
}
