package com.baidu.tieba.ala.live.personcenter.forbidden.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaForbiddenListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.a fQx;

    public AlaForbiddenListResponseMessage() {
        super(1021079);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.fQx = new com.baidu.tieba.ala.live.personcenter.forbidden.b.a();
        this.fQx.cV(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.forbidden.b.a byY() {
        return this.fQx;
    }
}
