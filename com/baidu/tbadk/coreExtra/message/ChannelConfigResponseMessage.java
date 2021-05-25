package com.baidu.tbadk.coreExtra.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.m0.s.c.o;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ChannelConfigResponseMessage extends JsonHttpResponsedMessage {
    public o mData;

    public ChannelConfigResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null || !isSuccess()) {
            return;
        }
        o oVar = new o();
        this.mData = oVar;
        oVar.c(jSONObject);
    }

    public o getData() {
        return this.mData;
    }
}
