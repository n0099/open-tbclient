package com.baidu.tieba.ala.category.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.category.b.b;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaCategoryResponseMessage extends JsonHttpResponsedMessage {
    private b gOW;

    public AlaCategoryResponseMessage() {
        super(1021187);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.gOW = new b();
        this.gOW.dG(jSONObject.optJSONObject("data"));
    }

    public b bWF() {
        return this.gOW;
    }
}
