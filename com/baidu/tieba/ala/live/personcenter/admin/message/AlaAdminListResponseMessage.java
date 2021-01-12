package com.baidu.tieba.ala.live.personcenter.admin.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaAdminListResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.live.personcenter.admin.b.a hfG;

    public AlaAdminListResponseMessage() {
        super(1021078);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.hfG = new com.baidu.tieba.ala.live.personcenter.admin.b.a();
        this.hfG.dG(jSONObject.optJSONObject("data"));
    }

    public com.baidu.tieba.ala.live.personcenter.admin.b.a bXf() {
        return this.hfG;
    }
}
