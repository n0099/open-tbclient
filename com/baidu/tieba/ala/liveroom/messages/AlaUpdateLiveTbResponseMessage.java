package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private g faQ;

    public g bmv() {
        return this.faQ;
    }

    public AlaUpdateLiveTbResponseMessage() {
        super(1021033);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.faQ = new g();
            this.faQ.parseJson(jSONObject);
            setError(this.faQ.mErrorCode);
            setErrorString(this.faQ.mErrorMsg);
        }
    }
}
