package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fhI;
    private String fhJ;
    private int fhK;
    private int fhL;
    private String fhM;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fhK = 0;
        this.fhL = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fhI = jSONObject.optInt("anchor_identity");
                this.fhJ = jSONObject.optString("anchor_proportion");
                this.fhK = jSONObject.optInt("anchor_identity_status");
                this.fhL = jSONObject.optInt("anchor_proportion_status");
                this.fhM = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bpo() {
        return this.fhK;
    }

    public int bpp() {
        return this.fhL;
    }

    public String bpq() {
        return this.fhM;
    }
}
