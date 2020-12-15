package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int hxY;
    private String hxZ;
    private int hya;
    private int hyb;
    private String hyc;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.hya = 0;
        this.hyb = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.hxY = jSONObject.optInt("anchor_identity");
                this.hxZ = jSONObject.optString("anchor_proportion");
                this.hya = jSONObject.optInt("anchor_identity_status");
                this.hyb = jSONObject.optInt("anchor_proportion_status");
                this.hyc = jSONObject.optString("anchor_text");
            }
        }
    }

    public int cjc() {
        return this.hya;
    }

    public int cjd() {
        return this.hyb;
    }

    public String cje() {
        return this.hyc;
    }
}
