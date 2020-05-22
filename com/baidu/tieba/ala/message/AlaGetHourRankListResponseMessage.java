package com.baidu.tieba.ala.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.m;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetHourRankListResponseMessage extends JsonHttpResponsedMessage {
    private m gjb;

    public AlaGetHourRankListResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gjb = new m();
            this.gjb.parserJson(optJSONObject);
        }
    }

    public m bHA() {
        return this.gjb;
    }
}
