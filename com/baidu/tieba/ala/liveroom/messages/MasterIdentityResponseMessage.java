package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fLU;
    private String fLV;
    private int fLW;
    private int fLX;
    private String fLY;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fLW = 0;
        this.fLX = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fLU = jSONObject.optInt("anchor_identity");
                this.fLV = jSONObject.optString("anchor_proportion");
                this.fLW = jSONObject.optInt("anchor_identity_status");
                this.fLX = jSONObject.optInt("anchor_proportion_status");
                this.fLY = jSONObject.optString("anchor_text");
            }
        }
    }

    public int byJ() {
        return this.fLW;
    }

    public int byK() {
        return this.fLX;
    }

    public String byL() {
        return this.fLY;
    }
}
