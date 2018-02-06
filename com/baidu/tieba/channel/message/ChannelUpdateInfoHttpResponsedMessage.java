package com.baidu.tieba.channel.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ChannelUpdateInfoHttpResponsedMessage extends JsonHttpResponsedMessage {
    public ChannelUpdateInfoHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_CHANNEL_UPDATE_INFO);
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
