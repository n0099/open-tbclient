package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int ekG;
    private String ekH;
    private int ekI;
    private int ekJ;
    private String ekK;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.ekI = 0;
        this.ekJ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.ekG = jSONObject.optInt("anchor_identity");
                this.ekH = jSONObject.optString("anchor_proportion");
                this.ekI = jSONObject.optInt("anchor_identity_status");
                this.ekJ = jSONObject.optInt("anchor_proportion_status");
                this.ekK = jSONObject.optString("anchor_text");
            }
        }
    }

    public int aUG() {
        return this.ekI;
    }

    public int aUH() {
        return this.ekJ;
    }

    public String aUI() {
        return this.ekK;
    }
}
