package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ay;
import com.baidu.live.data.bc;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bg;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private bc aQv;
    private bg aQw;
    private bg aQx;
    private ay hvD;
    private be hvE;
    private bf hvF;

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
                this.aQv = new bc();
                this.aQv.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aQw = new bg();
                this.aQw.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aQx = new bg();
                this.aQx.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.hvD = new ay();
                this.hvD.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hvE = new be();
                this.hvE.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hvF = new bf();
                this.hvF.parseJson(optJSONObject7);
            }
        }
    }

    public void a(bc bcVar) {
        this.aQv = bcVar;
    }

    public void a(bg bgVar) {
        this.aQw = bgVar;
    }

    public void b(bg bgVar) {
        this.aQx = bgVar;
    }

    public bc cfN() {
        return this.aQv;
    }

    public bg cfO() {
        return this.aQw;
    }

    public bg cfP() {
        return this.aQx;
    }

    public ay cfQ() {
        return this.hvD;
    }

    public be cfR() {
        return this.hvE;
    }

    public bf cfS() {
        return this.hvF;
    }
}
