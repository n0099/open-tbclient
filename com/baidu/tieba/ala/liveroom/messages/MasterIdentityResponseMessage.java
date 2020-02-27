package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fgV;
    private String fgW;
    private int fgX;
    private int fgY;
    private String fgZ;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fgX = 0;
        this.fgY = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fgV = jSONObject.optInt("anchor_identity");
                this.fgW = jSONObject.optString("anchor_proportion");
                this.fgX = jSONObject.optInt("anchor_identity_status");
                this.fgY = jSONObject.optInt("anchor_proportion_status");
                this.fgZ = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bpg() {
        return this.fgX;
    }

    public int bph() {
        return this.fgY;
    }

    public String bpi() {
        return this.fgZ;
    }
}
