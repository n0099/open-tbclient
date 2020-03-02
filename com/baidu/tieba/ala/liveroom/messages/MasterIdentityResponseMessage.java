package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fgW;
    private String fgX;
    private int fgY;
    private int fgZ;
    private String fha;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fgY = 0;
        this.fgZ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fgW = jSONObject.optInt("anchor_identity");
                this.fgX = jSONObject.optString("anchor_proportion");
                this.fgY = jSONObject.optInt("anchor_identity_status");
                this.fgZ = jSONObject.optInt("anchor_proportion_status");
                this.fha = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bpi() {
        return this.fgY;
    }

    public int bpj() {
        return this.fgZ;
    }

    public String bpk() {
        return this.fha;
    }
}
