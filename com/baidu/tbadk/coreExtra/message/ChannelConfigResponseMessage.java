package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChannelConfigResponseMessage extends JsonHttpResponsedMessage {
    private m mData;

    public ChannelConfigResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && isSuccess()) {
            this.mData = new m();
            this.mData.parserData(jSONObject);
        }
    }

    public m getData() {
        return this.mData;
    }
}
