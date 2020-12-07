package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.aw;
import com.baidu.live.data.ba;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ba aPG;
    private be aPH;
    private be aPI;
    private aw hjG;
    private bc hjH;
    private bd hjI;

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
                this.aPG = new ba();
                this.aPG.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aPH = new be();
                this.aPH.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aPI = new be();
                this.aPI.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.hjG = new aw();
                this.hjG.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hjH = new bc();
                this.hjH.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hjI = new bd();
                this.hjI.parseJson(optJSONObject7);
            }
        }
    }

    public void a(ba baVar) {
        this.aPG = baVar;
    }

    public void a(be beVar) {
        this.aPH = beVar;
    }

    public void b(be beVar) {
        this.aPI = beVar;
    }

    public ba ccW() {
        return this.aPG;
    }

    public be ccX() {
        return this.aPH;
    }

    public be ccY() {
        return this.aPI;
    }

    public aw ccZ() {
        return this.hjG;
    }

    public bc cda() {
        return this.hjH;
    }

    public bd cdb() {
        return this.hjI;
    }
}
