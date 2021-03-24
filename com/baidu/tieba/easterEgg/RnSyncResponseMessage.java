package com.baidu.tieba.easterEgg;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.g0.e.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RnSyncResponseMessage extends JsonHttpResponsedMessage {
    public a mData;

    public RnSyncResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
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
