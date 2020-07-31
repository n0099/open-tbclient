package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gsh;
    private String gsi;
    private int gsj;
    private int gsk;
    private String gsl;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gsj = 0;
        this.gsk = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gsh = jSONObject.optInt("anchor_identity");
                this.gsi = jSONObject.optString("anchor_proportion");
                this.gsj = jSONObject.optInt("anchor_identity_status");
                this.gsk = jSONObject.optInt("anchor_proportion_status");
                this.gsl = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bLa() {
        return this.gsj;
    }

    public int bLb() {
        return this.gsk;
    }

    public String bLc() {
        return this.gsl;
    }
}
