package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ag auh;
    private ah aui;
    private ah auj;

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
                    this.auh = new ag();
                    this.auh.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
                if (optJSONObject3 != null) {
                    this.aui = new ah();
                    this.aui.parseJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
                if (optJSONObject4 != null) {
                    this.auj = new ah();
                    this.auj.parseJson(optJSONObject4);
                }
            }
            jSONObject.optString("logid");
        }
    }

    public void a(ag agVar) {
        this.auh = agVar;
    }

    public void a(ah ahVar) {
        this.aui = ahVar;
    }

    public void b(ah ahVar) {
        this.auj = ahVar;
    }

    public ag btN() {
        return this.auh;
    }

    public ah btO() {
        return this.aui;
    }

    public ah btP() {
        return this.auj;
    }
}
