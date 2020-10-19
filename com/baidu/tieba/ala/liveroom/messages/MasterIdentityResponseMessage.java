package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gXe;
    private String gXf;
    private int gXg;
    private int gXh;
    private String gXi;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gXg = 0;
        this.gXh = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gXe = jSONObject.optInt("anchor_identity");
                this.gXf = jSONObject.optString("anchor_proportion");
                this.gXg = jSONObject.optInt("anchor_identity_status");
                this.gXh = jSONObject.optInt("anchor_proportion_status");
                this.gXi = jSONObject.optString("anchor_text");
            }
        }
    }

    public int caj() {
        return this.gXg;
    }

    public int cak() {
        return this.gXh;
    }

    public String cal() {
        return this.gXi;
    }
}
