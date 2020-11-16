package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.av;
import com.baidu.live.data.az;
import com.baidu.live.data.bb;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private az aMH;
    private bd aMI;
    private bd aMJ;
    private av gZX;
    private bb gZY;
    private bc gZZ;

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
                this.aMH = new az();
                this.aMH.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aMI = new bd();
                this.aMI.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aMJ = new bd();
                this.aMJ.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gZX = new av();
                this.gZX.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gZY = new bb();
                this.gZY.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gZZ = new bc();
                this.gZZ.parseJson(optJSONObject7);
            }
        }
    }

    public void a(az azVar) {
        this.aMH = azVar;
    }

    public void a(bd bdVar) {
        this.aMI = bdVar;
    }

    public void b(bd bdVar) {
        this.aMJ = bdVar;
    }

    public az bZb() {
        return this.aMH;
    }

    public bd bZc() {
        return this.aMI;
    }

    public bd bZd() {
        return this.aMJ;
    }

    public av bZe() {
        return this.gZX;
    }

    public bb bZf() {
        return this.gZY;
    }

    public bc bZg() {
        return this.gZZ;
    }
}
