package com.baidu.tieba.ala.live.personcenter.forbidden.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaForbiddenListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.forbidden.b.a eIi;

    public AlaForbiddenListResponseMessage() {
        super(1021079);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.eIi = new com.baidu.tieba.ala.live.personcenter.forbidden.b.a();
        this.eIi.cC(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.forbidden.b.a beC() {
        return this.eIi;
    }
}
