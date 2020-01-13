package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fdL;
    private String fdM;
    private int fdN;
    private int fdO;
    private String fdP;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.fdN = 0;
        this.fdO = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fdL = jSONObject.optInt("anchor_identity");
                this.fdM = jSONObject.optString("anchor_proportion");
                this.fdN = jSONObject.optInt("anchor_identity_status");
                this.fdO = jSONObject.optInt("anchor_proportion_status");
                this.fdP = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bnw() {
        return this.fdN;
    }

    public int bnx() {
        return this.fdO;
    }

    public String bny() {
        return this.fdP;
    }
}
