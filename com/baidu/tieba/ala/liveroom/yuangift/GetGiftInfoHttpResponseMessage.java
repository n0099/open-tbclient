package com.baidu.tieba.ala.liveroom.yuangift;

import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetGiftInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private g fli;

    public GetGiftInfoHttpResponseMessage() {
        super(1021130);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONArray("data") != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            this.fli = new g();
            this.fli.parseJson(optJSONObject);
        }
    }
}
