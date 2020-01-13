package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaDiversionInfoResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.liveroom.data.c eXE;

    public AlaDiversionInfoResponseMessage() {
        super(1021173);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eXE = new com.baidu.tieba.ala.liveroom.data.c();
            this.eXE.parse(optJSONObject);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.c bnr() {
        return this.eXE;
    }
}
