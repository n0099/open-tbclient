package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gak;
    private String gal;
    private int gam;
    private int gan;
    private String gao;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gam = 0;
        this.gan = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gak = jSONObject.optInt("anchor_identity");
                this.gal = jSONObject.optString("anchor_proportion");
                this.gam = jSONObject.optInt("anchor_identity_status");
                this.gan = jSONObject.optInt("anchor_proportion_status");
                this.gao = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bEN() {
        return this.gam;
    }

    public int bEO() {
        return this.gan;
    }

    public String bEP() {
        return this.gao;
    }
}
