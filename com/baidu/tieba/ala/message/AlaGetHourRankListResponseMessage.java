package com.baidu.tieba.ala.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.p;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetHourRankListResponseMessage extends JsonHttpResponsedMessage {
    private p hsj;

    public AlaGetHourRankListResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hsj = new p();
            this.hsj.parserJson(optJSONObject);
        }
    }

    public p cfY() {
        return this.hsj;
    }
}
