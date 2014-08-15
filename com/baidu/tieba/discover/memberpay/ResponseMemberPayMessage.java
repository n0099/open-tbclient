package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseMemberPayMessage extends JsonHttpResponsedMessage {
    private d mData;

    public d getMemberPayResult() {
        if (this.mData == null) {
            this.mData = new d();
        }
        return this.mData;
    }

    public ResponseMemberPayMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new d();
            this.mData.a(jSONObject);
        }
    }
}
