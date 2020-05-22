package com.baidu.tieba.ala.category.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.category.b.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCategoryResponseMessage extends JsonHttpResponsedMessage {
    private b fny;

    public AlaCategoryResponseMessage() {
        super(1021187);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.fny = new b();
        this.fny.cM(jSONObject.optJSONObject("data"));
    }

    public b bsR() {
        return this.fny;
    }
}
