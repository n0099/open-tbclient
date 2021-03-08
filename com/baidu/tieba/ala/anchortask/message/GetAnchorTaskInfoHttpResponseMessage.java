package com.baidu.tieba.ala.anchortask.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.anchortask.b.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetAnchorTaskInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public c gMF;

    public GetAnchorTaskInfoHttpResponseMessage() {
        super(1021172);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gMF = new c();
            this.gMF.parseJson(optJSONObject);
        }
    }
}
