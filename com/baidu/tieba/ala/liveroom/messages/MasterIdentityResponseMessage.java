package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gFc;
    private String gFd;
    private int gFe;
    private int gFf;
    private String gFg;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gFe = 0;
        this.gFf = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gFc = jSONObject.optInt("anchor_identity");
                this.gFd = jSONObject.optString("anchor_proportion");
                this.gFe = jSONObject.optInt("anchor_identity_status");
                this.gFf = jSONObject.optInt("anchor_proportion_status");
                this.gFg = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bVd() {
        return this.gFe;
    }

    public int bVe() {
        return this.gFf;
    }

    public String bVf() {
        return this.gFg;
    }
}
