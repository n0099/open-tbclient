package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int elA;
    private String elB;
    private int elx;
    private String ely;
    private int elz;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.elz = 0;
        this.elA = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.elx = jSONObject.optInt("anchor_identity");
                this.ely = jSONObject.optString("anchor_proportion");
                this.elz = jSONObject.optInt("anchor_identity_status");
                this.elA = jSONObject.optInt("anchor_proportion_status");
                this.elB = jSONObject.optString("anchor_text");
            }
        }
    }

    public int aUI() {
        return this.elz;
    }

    public int aUJ() {
        return this.elA;
    }

    public String aUK() {
        return this.elB;
    }
}
