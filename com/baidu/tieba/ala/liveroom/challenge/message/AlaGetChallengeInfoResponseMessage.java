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
    private bc hvv;
    private bi hvw;
    private bj hvx;

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
                this.hvv = new bc();
                this.hvv.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hvw = new bi();
                this.hvw.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hvx = new bj();
                this.hvx.parseJson(optJSONObject7);
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

    public bg ccY() {
        return this.aOF;
    }

    public bk ccZ() {
        return this.aOG;
    }

    public bk cda() {
        return this.aOH;
    }

    public bc cdb() {
        return this.hvv;
    }

    public bi cdc() {
        return this.hvw;
    }

    public bj cdd() {
        return this.hvx;
    }
}
