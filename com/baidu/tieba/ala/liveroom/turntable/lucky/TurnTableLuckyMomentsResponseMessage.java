package com.baidu.tieba.ala.liveroom.turntable.lucky;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TurnTableLuckyMomentsResponseMessage extends JsonHttpResponsedMessage {
    public c gfu;

    public TurnTableLuckyMomentsResponseMessage() {
        super(1021157);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1021157 && (optJSONObject = jSONObject.optJSONObject("result")) != null) {
            this.gfu = new c(optJSONObject);
        }
    }
}
