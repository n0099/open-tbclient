package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaEnterEffectEditHttpResMessage extends JsonHttpResponsedMessage {
    public AlaEnterEffectEditHttpResMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
    }
}
