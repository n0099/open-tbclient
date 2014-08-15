package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseMemberPrivilegeMessage extends JsonHttpResponsedMessage {
    public h mData;

    public ResponseMemberPrivilegeMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new h();
            this.mData.a(jSONObject);
        }
    }
}
