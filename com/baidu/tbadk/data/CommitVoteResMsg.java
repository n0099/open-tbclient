package com.baidu.tbadk.data;

import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CommitVoteResMsg extends JsonHttpResponsedMessage {
    private AuthTokenData tokenData;

    public CommitVoteResMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.tokenData = AuthTokenData.parse(jSONObject);
        }
    }

    public AuthTokenData getTokenData() {
        return this.tokenData;
    }
}
