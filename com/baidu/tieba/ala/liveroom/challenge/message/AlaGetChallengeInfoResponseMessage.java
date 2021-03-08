package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.bi;
import com.baidu.live.data.bj;
import com.baidu.live.data.bk;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private bg aQf;
    private bk aQg;
    private bk aQh;
    private bc hxe;
    private bi hxf;
    private bj hxg;

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
                this.aQf = new bg();
                this.aQf.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aQg = new bk();
                this.aQg.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aQh = new bk();
                this.aQh.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.hxe = new bc();
                this.hxe.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.hxf = new bi();
                this.hxf.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.hxg = new bj();
                this.hxg.parseJson(optJSONObject7);
            }
        }
    }

    public void a(bg bgVar) {
        this.aQf = bgVar;
    }

    public void a(bk bkVar) {
        this.aQg = bkVar;
    }

    public void b(bk bkVar) {
        this.aQh = bkVar;
    }

    public bg cde() {
        return this.aQf;
    }

    public bk cdf() {
        return this.aQg;
    }

    public bk cdg() {
        return this.aQh;
    }

    public bc cdh() {
        return this.hxe;
    }

    public bi cdi() {
        return this.hxf;
    }

    public bj cdj() {
        return this.hxg;
    }
}
