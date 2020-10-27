package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.at;
import com.baidu.live.data.ax;
import com.baidu.live.data.az;
import com.baidu.live.data.ba;
import com.baidu.live.data.bb;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeInfoResponseMessage extends JsonHttpResponsedMessage {
    private ax aNp;
    private bb aNq;
    private bb aNr;
    private at gUm;
    private az gUn;
    private ba gUo;

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
                this.aNp = new ax();
                this.aNp.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aNq = new bb();
                this.aNq.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aNr = new bb();
                this.aNr.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.gUm = new at();
                this.gUm.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gUn = new az();
                this.gUn.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gUo = new ba();
                this.gUo.parseJson(optJSONObject7);
            }
        }
    }

    public void a(ax axVar) {
        this.aNp = axVar;
    }

    public void a(bb bbVar) {
        this.aNq = bbVar;
    }

    public void b(bb bbVar) {
        this.aNr = bbVar;
    }

    public ax bXg() {
        return this.aNp;
    }

    public bb bXh() {
        return this.aNq;
    }

    public bb bXi() {
        return this.aNr;
    }

    public at bXj() {
        return this.gUm;
    }

    public az bXk() {
        return this.gUn;
    }

    public ba bXl() {
        return this.gUo;
    }
}
