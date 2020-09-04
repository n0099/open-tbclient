package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.al;
import com.baidu.live.data.ap;
import com.baidu.live.data.ar;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ap aIk;
    private at aIl;
    private at aIm;
    private al gqL;
    private ar gqM;
    private as gqN;

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
                this.aIk = new ap();
                this.aIk.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aIl = new at();
                this.aIl.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aIm = new at();
                this.aIm.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gqL = new al();
                this.gqL.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gqM = new ar();
                this.gqM.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gqN = new as();
                this.gqN.parseJson(optJSONObject7);
            }
        }
    }

    public void a(ap apVar) {
        this.aIk = apVar;
    }

    public void a(at atVar) {
        this.aIl = atVar;
    }

    public void b(at atVar) {
        this.aIm = atVar;
    }

    public ap bPy() {
        return this.aIk;
    }

    public at bPz() {
        return this.aIl;
    }

    public at bPA() {
        return this.aIm;
    }

    public al bPB() {
        return this.gqL;
    }

    public ar bPC() {
        return this.gqM;
    }

    public as bPD() {
        return this.gqN;
    }
}
