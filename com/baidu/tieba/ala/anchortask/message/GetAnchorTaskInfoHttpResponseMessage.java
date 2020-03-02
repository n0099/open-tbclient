package com.baidu.tieba.ala.anchortask.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.anchortask.b.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetAnchorTaskInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public b euL;

    public GetAnchorTaskInfoHttpResponseMessage() {
        super(1021172);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.euL = new b();
            this.euL.parseJson(optJSONObject);
        }
    }
}
