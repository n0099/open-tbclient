package com.baidu.tbadk.img;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetEmotionPidResponseMessage extends JsonHttpResponsedMessage {
    private c mPid;

    public GetEmotionPidResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mPid = c.k(jSONObject);
        }
    }

    public c getImageInfo() {
        return this.mPid;
    }
}
