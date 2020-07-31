package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDiversionInfoResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.liveroom.data.c gmm;

    public AlaDiversionInfoResponseMessage() {
        super(1021181);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gmm = new com.baidu.tieba.ala.liveroom.data.c();
            this.gmm.parse(optJSONObject);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.c bKT() {
        return this.gmm;
    }
}
