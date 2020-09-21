package com.baidu.tieba.ala.category.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.category.b.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCategoryResponseMessage extends JsonHttpResponsedMessage {
    private b fSJ;

    public AlaCategoryResponseMessage() {
        super(1021187);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.fSJ = new b();
        this.fSJ.dl(jSONObject.optJSONObject("data"));
    }

    public b bJk() {
        return this.fSJ;
    }
}
