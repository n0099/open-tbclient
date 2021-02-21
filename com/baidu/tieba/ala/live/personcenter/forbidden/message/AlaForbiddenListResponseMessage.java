package com.baidu.tieba.ala.live.personcenter.forbidden.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaForbiddenListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.a hlC;

    public AlaForbiddenListResponseMessage() {
        super(1021079);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.hlC = new com.baidu.tieba.ala.live.personcenter.forbidden.b.a();
        this.hlC.dH(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.forbidden.b.a bYD() {
        return this.hlC;
    }
}
