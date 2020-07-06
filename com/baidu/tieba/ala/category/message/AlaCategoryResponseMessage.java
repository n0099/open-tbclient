package com.baidu.tieba.ala.category.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.category.b.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCategoryResponseMessage extends JsonHttpResponsedMessage {
    private b fyW;

    public AlaCategoryResponseMessage() {
        super(1021187);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.fyW = new b();
        this.fyW.cV(jSONObject.optJSONObject("data"));
    }

    public b bvP() {
        return this.fyW;
    }
}
