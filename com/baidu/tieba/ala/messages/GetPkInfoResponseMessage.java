package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.PkInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetPkInfoResponseMessage extends JsonHttpResponsedMessage {
    PkInfoData hTI;

    public GetPkInfoResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hTI = new PkInfoData();
            this.hTI.parserJson(optJSONObject);
            this.hTI.logId = jSONObject.optLong("logid");
        }
    }

    public PkInfoData coN() {
        return this.hTI;
    }
}
