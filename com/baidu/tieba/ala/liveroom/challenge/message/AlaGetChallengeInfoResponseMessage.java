package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ai;
import com.baidu.live.data.am;
import com.baidu.live.data.ao;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private am aBD;
    private aq aBE;
    private aq aBF;
    private ai fZr;
    private ao fZs;
    private ap fZt;

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
                this.aBD = new am();
                this.aBD.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aBE = new aq();
                this.aBE.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aBF = new aq();
                this.aBF.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.fZr = new ai();
                this.fZr.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.fZs = new ao();
                this.fZs.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.fZt = new ap();
                this.fZt.parseJson(optJSONObject7);
            }
        }
    }

    public void a(am amVar) {
        this.aBD = amVar;
    }

    public void a(aq aqVar) {
        this.aBE = aqVar;
    }

    public void b(aq aqVar) {
        this.aBF = aqVar;
    }

    public am bCG() {
        return this.aBD;
    }

    public aq bCH() {
        return this.aBE;
    }

    public aq bCI() {
        return this.aBF;
    }

    public ai bCJ() {
        return this.fZr;
    }

    public ao bCK() {
        return this.fZs;
    }

    public ap bCL() {
        return this.fZt;
    }
}
