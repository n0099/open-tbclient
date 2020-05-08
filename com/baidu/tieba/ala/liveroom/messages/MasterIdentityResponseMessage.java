package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fLZ;
    private String fMa;
    private int fMb;
    private int fMc;
    private String fMd;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fMb = 0;
        this.fMc = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fLZ = jSONObject.optInt("anchor_identity");
                this.fMa = jSONObject.optString("anchor_proportion");
                this.fMb = jSONObject.optInt("anchor_identity_status");
                this.fMc = jSONObject.optInt("anchor_proportion_status");
                this.fMd = jSONObject.optString("anchor_text");
            }
        }
    }

    public int byH() {
        return this.fMb;
    }

    public int byI() {
        return this.fMc;
    }

    public String byJ() {
        return this.fMd;
    }
}
