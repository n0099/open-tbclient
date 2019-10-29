package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private g elq;

    public g aUG() {
        return this.elq;
    }

    public AlaUpdateLiveTbResponseMessage() {
        super(1021033);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.elq = new g();
            this.elq.parseJson(jSONObject);
            setError(this.elq.mErrorCode);
            setErrorString(this.elq.mErrorMsg);
        }
    }
}
