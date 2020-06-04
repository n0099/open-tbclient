package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ak azl;
    private al azm;
    private al azn;

    public AlaGetChallengeInfoResponseMessage() {
        super(1021112);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("challenge_info");
            if (optJSONObject2 != null) {
                this.azl = new ak();
                this.azl.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.azm = new al();
                this.azm.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.azn = new al();
                this.azn.parseJson(optJSONObject4);
            }
        }
    }

    public void a(ak akVar) {
        this.azl = akVar;
    }

    public void a(al alVar) {
        this.azm = alVar;
    }

    public void b(al alVar) {
        this.azn = alVar;
    }

    public ak bzO() {
        return this.azl;
    }

    public al bzP() {
        return this.azm;
    }

    public al bzQ() {
        return this.azn;
    }
}
