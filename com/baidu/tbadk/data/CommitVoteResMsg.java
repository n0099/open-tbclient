package com.baidu.tbadk.data;

import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommitVoteResMsg extends JsonHttpResponsedMessage {
    public AuthTokenData tokenData;

    public CommitVoteResMsg(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.tokenData = AuthTokenData.parse(jSONObject);
    }

    public AuthTokenData getTokenData() {
        return this.tokenData;
    }
}
