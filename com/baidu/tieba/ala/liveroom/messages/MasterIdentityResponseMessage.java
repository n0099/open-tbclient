package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gFg;
    private String gFh;
    private int gFi;
    private int gFj;
    private String gFk;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gFi = 0;
        this.gFj = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gFg = jSONObject.optInt("anchor_identity");
                this.gFh = jSONObject.optString("anchor_proportion");
                this.gFi = jSONObject.optInt("anchor_identity_status");
                this.gFj = jSONObject.optInt("anchor_proportion_status");
                this.gFk = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bVe() {
        return this.gFi;
    }

    public int bVf() {
        return this.gFj;
    }

    public String bVg() {
        return this.gFk;
    }
}
