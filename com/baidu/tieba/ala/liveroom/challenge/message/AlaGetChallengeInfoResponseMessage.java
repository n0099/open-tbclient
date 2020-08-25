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
    private ap aIi;
    private at aIj;
    private at aIk;
    private al gqH;
    private ar gqI;
    private as gqJ;

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
                this.aIi = new ap();
                this.aIi.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aIj = new at();
                this.aIj.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aIk = new at();
                this.aIk.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gqH = new al();
                this.gqH.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gqI = new ar();
                this.gqI.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gqJ = new as();
                this.gqJ.parseJson(optJSONObject7);
            }
        }
    }

    public void a(ap apVar) {
        this.aIi = apVar;
    }

    public void a(at atVar) {
        this.aIj = atVar;
    }

    public void b(at atVar) {
        this.aIk = atVar;
    }

    public ap bPx() {
        return this.aIi;
    }

    public at bPy() {
        return this.aIj;
    }

    public at bPz() {
        return this.aIk;
    }

    public al bPA() {
        return this.gqH;
    }

    public ar bPB() {
        return this.gqI;
    }

    public as bPC() {
        return this.gqJ;
    }
}
