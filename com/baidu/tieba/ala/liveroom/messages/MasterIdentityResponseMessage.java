package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int faX;
    private String faY;
    private int faZ;
    private int fba;
    private String fbb;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.faZ = 0;
        this.fba = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.faX = jSONObject.optInt("anchor_identity");
                this.faY = jSONObject.optString("anchor_proportion");
                this.faZ = jSONObject.optInt("anchor_identity_status");
                this.fba = jSONObject.optInt("anchor_proportion_status");
                this.fbb = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bmx() {
        return this.faZ;
    }

    public int bmy() {
        return this.fba;
    }

    public String bmz() {
        return this.fbb;
    }
}
