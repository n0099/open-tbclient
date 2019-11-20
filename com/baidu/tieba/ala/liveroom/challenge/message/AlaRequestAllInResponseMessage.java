package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaRequestAllInResponseMessage extends JsonHttpResponsedMessage {
    private int Su;

    public AlaRequestAllInResponseMessage() {
        super(1021113);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            this.Su = jSONObject.optJSONObject("data").optInt("allin");
        }
    }

    public int aQq() {
        return this.Su;
    }
}
