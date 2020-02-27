package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetTargetInfoResponseMessage extends JsonHttpResponsedMessage {
    private d eUv;

    public AlaGetTargetInfoResponseMessage() {
        super(1021116);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data").optJSONObject("user_info")) != null) {
            this.eUv = new d();
            this.eUv.parseJson(optJSONObject);
        }
    }

    public d bks() {
        return this.eUv;
    }
}
