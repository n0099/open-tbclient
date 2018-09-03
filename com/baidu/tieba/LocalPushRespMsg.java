package com.baidu.tieba;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LocalPushRespMsg extends JsonHttpResponsedMessage {
    private c mData;

    public LocalPushRespMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && isSuccess()) {
            this.mData = new c();
            this.mData.parseData(jSONObject);
        }
    }

    public c getData() {
        return this.mData;
    }
}
