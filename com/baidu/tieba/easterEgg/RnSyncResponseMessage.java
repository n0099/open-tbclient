package com.baidu.tieba.easterEgg;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.h0.e.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RnSyncResponseMessage extends JsonHttpResponsedMessage {
    public a mData;

    public RnSyncResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null || !isSuccess()) {
            return;
        }
        a aVar = new a();
        this.mData = aVar;
        aVar.d(jSONObject);
    }

    public a getData() {
        return this.mData;
    }
}
