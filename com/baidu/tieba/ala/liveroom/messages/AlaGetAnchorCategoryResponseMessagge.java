package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetAnchorCategoryResponseMessagge extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.category.b.a gWL;

    public AlaGetAnchorCategoryResponseMessagge() {
        super(1021188);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("categroy_info");
        this.gWL = new com.baidu.tieba.ala.category.b.a();
        this.gWL.parse(optJSONObject);
    }

    public com.baidu.tieba.ala.category.b.a cae() {
        return this.gWL;
    }
}
