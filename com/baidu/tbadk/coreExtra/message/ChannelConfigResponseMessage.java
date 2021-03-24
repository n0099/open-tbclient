package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.h0.s.c.m;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ChannelConfigResponseMessage extends JsonHttpResponsedMessage {
    public m mData;

    public ChannelConfigResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null || !isSuccess()) {
            return;
        }
        m mVar = new m();
        this.mData = mVar;
        mVar.c(jSONObject);
    }

    public m getData() {
        return this.mData;
    }
}
