package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ag aub;
    private ah auc;
    private ah aud;

    public AlaGetChallengeInfoResponseMessage() {
        super(1021112);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && getError() == 0) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("challenge_info");
                if (optJSONObject2 != null) {
                    this.aub = new ag();
                    this.aub.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.auc = new ah();
                    this.auc.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.aud = new ah();
                    this.aud.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public void a(ag agVar) {
        this.aub = agVar;
    }

    public void a(ah ahVar) {
        this.auc = ahVar;
    }

    public void b(ah ahVar) {
        this.aud = ahVar;
    }

    public ag btP() {
        return this.aub;
    }

    public ah btQ() {
        return this.auc;
    }

    public ah btR() {
        return this.aud;
    }
}
