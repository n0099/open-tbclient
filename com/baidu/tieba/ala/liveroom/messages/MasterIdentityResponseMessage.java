package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gnh;
    private String gni;
    private int gnj;
    private int gnk;
    private String gnl;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gnj = 0;
        this.gnk = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gnh = jSONObject.optInt("anchor_identity");
                this.gni = jSONObject.optString("anchor_proportion");
                this.gnj = jSONObject.optInt("anchor_identity_status");
                this.gnk = jSONObject.optInt("anchor_proportion_status");
                this.gnl = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bHT() {
        return this.gnj;
    }

    public int bHU() {
        return this.gnk;
    }

    public String bHV() {
        return this.gnl;
    }
}
