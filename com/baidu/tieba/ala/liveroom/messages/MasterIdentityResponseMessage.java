package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MasterIdentityResponseMessage extends JsonHttpResponsedMessage {
    private int gIE;
    private String gIF;
    private int gIG;
    private int gIH;
    private String gII;

    public MasterIdentityResponseMessage() {
        super(1021131);
        this.gIG = 0;
        this.gIH = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (getError() == 0) {
                this.gIE = jSONObject.optInt("anchor_identity");
                this.gIF = jSONObject.optString("anchor_proportion");
                this.gIG = jSONObject.optInt("anchor_identity_status");
                this.gIH = jSONObject.optInt("anchor_proportion_status");
                this.gII = jSONObject.optString("anchor_text");
            }
        }
    }

    public int bWO() {
        return this.gIG;
    }

    public int bWP() {
        return this.gIH;
    }

    public String bWQ() {
        return this.gII;
    }
}
