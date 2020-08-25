package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChannelConfigResponseMessage extends JsonHttpResponsedMessage {
    private l mData;

    public ChannelConfigResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && isSuccess()) {
            this.mData = new l();
            this.mData.cY(jSONObject);
        }
    }

    public l getData() {
        return this.mData;
    }
}
