package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.PkInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetPkInfoResponseMessage extends JsonHttpResponsedMessage {
    PkInfoData hyu;

    public GetPkInfoResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hyu = new PkInfoData();
            this.hyu.parserJson(optJSONObject);
            this.hyu.logId = jSONObject.optLong("logid");
        }
    }

    public PkInfoData ciG() {
        return this.hyu;
    }
}
