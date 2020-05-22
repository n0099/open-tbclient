package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int fZZ;
    private String gaa;
    private int gab;
    private int gac;
    private String gad;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gab = 0;
        this.gac = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.fZZ = jSONObject.optInt("anchor_identity");
                this.gaa = jSONObject.optString("anchor_proportion");
                this.gab = jSONObject.optInt("anchor_identity_status");
                this.gac = jSONObject.optInt("anchor_proportion_status");
                this.gad = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bEL() {
        return this.gab;
    }

    public int bEM() {
        return this.gac;
    }

    public String bEN() {
        return this.gad;
    }
}
