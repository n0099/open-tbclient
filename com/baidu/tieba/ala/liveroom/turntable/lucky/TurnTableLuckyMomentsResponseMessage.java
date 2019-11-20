package com.baidu.tieba.ala.liveroom.turntable.lucky;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TurnTableLuckyMomentsResponseMessage extends JsonHttpResponsedMessage {
    public c eoL;

    public TurnTableLuckyMomentsResponseMessage() {
        super(1021155);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021155 && (optJSONObject = jSONObject.optJSONObject("result")) != null) {
            this.eoL = new c(optJSONObject);
        }
    }
}
