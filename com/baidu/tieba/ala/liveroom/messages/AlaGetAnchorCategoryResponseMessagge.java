package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetAnchorCategoryResponseMessagge extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.category.b.a fZH;

    public AlaGetAnchorCategoryResponseMessagge() {
        super(1021188);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("categroy_info");
        this.fZH = new com.baidu.tieba.ala.category.b.a();
        this.fZH.parse(optJSONObject);
    }

    public com.baidu.tieba.ala.category.b.a bEG() {
        return this.fZH;
    }
}
