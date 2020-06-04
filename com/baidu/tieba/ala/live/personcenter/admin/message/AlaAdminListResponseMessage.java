package com.baidu.tieba.ala.live.personcenter.admin.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAdminListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.admin.b.a fDT;

    public AlaAdminListResponseMessage() {
        super(1021078);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.fDT = new com.baidu.tieba.ala.live.personcenter.admin.b.a();
        this.fDT.cM(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.admin.b.a bvM() {
        return this.fDT;
    }
}
