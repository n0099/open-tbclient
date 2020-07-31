package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.aj;
import com.baidu.live.data.an;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.ar;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private an aCY;
    private ar aCZ;
    private ar aDa;
    private ap geA;
    private aq geB;
    private aj gez;

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
                this.aCY = new an();
                this.aCY.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aCZ = new ar();
                this.aCZ.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aDa = new ar();
                this.aDa.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gez = new aj();
                this.gez.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.geA = new ap();
                this.geA.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.geB = new aq();
                this.geB.parseJson(optJSONObject7);
            }
        }
    }

    public void a(an anVar) {
        this.aCY = anVar;
    }

    public void a(ar arVar) {
        this.aCZ = arVar;
    }

    public void b(ar arVar) {
        this.aDa = arVar;
    }

    public an bFS() {
        return this.aCY;
    }

    public ar bFT() {
        return this.aCZ;
    }

    public ar bFU() {
        return this.aDa;
    }

    public aj bFV() {
        return this.gez;
    }

    public ap bFW() {
        return this.geA;
    }

    public aq bFX() {
        return this.geB;
    }
}
