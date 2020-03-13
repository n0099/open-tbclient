package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fhj;
    private String fhk;
    private int fhl;
    private int fhm;
    private String fhn;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fhl = 0;
        this.fhm = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fhj = jSONObject.optInt("anchor_identity");
                this.fhk = jSONObject.optString("anchor_proportion");
                this.fhl = jSONObject.optInt("anchor_identity_status");
                this.fhm = jSONObject.optInt("anchor_proportion_status");
                this.fhn = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bpj() {
        return this.fhl;
    }

    public int bpk() {
        return this.fhm;
    }

    public String bpl() {
        return this.fhn;
    }
}
