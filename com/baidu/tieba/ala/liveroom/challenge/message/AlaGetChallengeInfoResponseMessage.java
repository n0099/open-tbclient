package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ay;
import com.baidu.live.data.bc;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bg;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private bc aLI;
    private bg aLJ;
    private bg aLK;
    private ay hqX;
    private be hqY;
    private bf hqZ;

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
                this.aLI = new bc();
                this.aLI.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aLJ = new bg();
                this.aLJ.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aLK = new bg();
                this.aLK.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.hqX = new ay();
                this.hqX.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hqY = new be();
                this.hqY.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hqZ = new bf();
                this.hqZ.parseJson(optJSONObject7);
            }
        }
    }

    public void a(bc bcVar) {
        this.aLI = bcVar;
    }

    public void a(bg bgVar) {
        this.aLJ = bgVar;
    }

    public void b(bg bgVar) {
        this.aLK = bgVar;
    }

    public bc cbW() {
        return this.aLI;
    }

    public bg cbX() {
        return this.aLJ;
    }

    public bg cbY() {
        return this.aLK;
    }

    public ay cbZ() {
        return this.hqX;
    }

    public be cca() {
        return this.hqY;
    }

    public bf ccb() {
        return this.hqZ;
    }
}
