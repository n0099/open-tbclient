package com.baidu.tieba.ala.live.personcenter.admin.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAdminListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.admin.b.a gYy;

    public AlaAdminListResponseMessage() {
        super(1021078);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.gYy = new com.baidu.tieba.ala.live.personcenter.admin.b.a();
        this.gYy.dx(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.admin.b.a bYr() {
        return this.gYy;
    }
}
