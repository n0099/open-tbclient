package com.baidu.tieba.easterEgg;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class RnSyncResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.easterEgg.a.a mData;

    public RnSyncResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && isSuccess()) {
            this.mData = new com.baidu.tieba.easterEgg.a.a();
            this.mData.cQ(jSONObject);
        }
    }

    public com.baidu.tieba.easterEgg.a.a getData() {
        return this.mData;
    }
}
