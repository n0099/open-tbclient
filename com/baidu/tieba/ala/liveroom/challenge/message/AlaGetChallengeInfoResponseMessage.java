package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bi;
import com.baidu.live.data.bj;
import com.baidu.live.data.bk;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private bg aOF;
    private bk aOG;
    private bk aOH;
    private bc hvh;
    private bi hvi;
    private bj hvj;

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
                this.aOF = new bg();
                this.aOF.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aOG = new bk();
                this.aOG.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aOH = new bk();
                this.aOH.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.hvh = new bc();
                this.hvh.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hvi = new bi();
                this.hvi.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hvj = new bj();
                this.hvj.parseJson(optJSONObject7);
            }
        }
    }

    public void a(bg bgVar) {
        this.aOF = bgVar;
    }

    public void a(bk bkVar) {
        this.aOG = bkVar;
    }

    public void b(bk bkVar) {
        this.aOH = bkVar;
    }

    public bg ccR() {
        return this.aOF;
    }

    public bk ccS() {
        return this.aOG;
    }

    public bk ccT() {
        return this.aOH;
    }

    public bc ccU() {
        return this.hvh;
    }

    public bi ccV() {
        return this.hvi;
    }

    public bj ccW() {
        return this.hvj;
    }
}
