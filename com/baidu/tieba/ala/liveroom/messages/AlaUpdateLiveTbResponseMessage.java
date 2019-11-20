package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private g ekz;

    public g aUE() {
        return this.ekz;
    }

    public AlaUpdateLiveTbResponseMessage() {
        super(1021033);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.ekz = new g();
            this.ekz.parseJson(jSONObject);
            setError(this.ekz.mErrorCode);
            setErrorString(this.ekz.mErrorMsg);
        }
    }
}
