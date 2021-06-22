package com.baidu.tbadk.img;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.b0.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetEmotionPidResponseMessage extends JsonHttpResponsedMessage {
    public c mPid;

    public GetEmotionPidResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mPid = c.a(jSONObject);
        }
    }

    public c getImageInfo() {
        return this.mPid;
    }
}
