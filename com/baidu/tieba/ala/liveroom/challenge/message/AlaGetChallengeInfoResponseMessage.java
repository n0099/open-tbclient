package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.aq;
import com.baidu.live.data.au;
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private au aMK;
    private ay aML;
    private ay aMM;
    private aq gIx;
    private aw gIy;
    private ax gIz;

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
                this.aMK = new au();
                this.aMK.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aML = new ay();
                this.aML.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aMM = new ay();
                this.aMM.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gIx = new aq();
                this.gIx.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gIy = new aw();
                this.gIy.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gIz = new ax();
                this.gIz.parseJson(optJSONObject7);
            }
        }
    }

    public void a(au auVar) {
        this.aMK = auVar;
    }

    public void a(ay ayVar) {
        this.aML = ayVar;
    }

    public void b(ay ayVar) {
        this.aMM = ayVar;
    }

    public au bUh() {
        return this.aMK;
    }

    public ay bUi() {
        return this.aML;
    }

    public ay bUj() {
        return this.aMM;
    }

    public aq bUk() {
        return this.gIx;
    }

    public aw bUl() {
        return this.gIy;
    }

    public ax bUm() {
        return this.gIz;
    }
}
