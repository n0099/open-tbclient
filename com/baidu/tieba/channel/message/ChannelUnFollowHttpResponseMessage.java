package com.baidu.tieba.channel.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ChannelUnFollowHttpResponseMessage extends JsonHttpResponsedMessage {
    public ChannelUnFollowHttpResponseMessage() {
        super(1003309);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            setError(-1);
        }
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error == 0) {
        }
    }
}
