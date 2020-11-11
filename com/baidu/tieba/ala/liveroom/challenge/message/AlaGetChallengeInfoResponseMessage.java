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
    private az aOs;
    private bd aOt;
    private bd aOu;
    private av haq;
    private bb har;
    private bc has;

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
                this.aOs = new az();
                this.aOs.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aOt = new bd();
                this.aOt.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aOu = new bd();
                this.aOu.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.haq = new av();
                this.haq.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.har = new bb();
                this.har.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.has = new bc();
                this.has.parseJson(optJSONObject7);
            }
        }
    }

    public void a(az azVar) {
        this.aOs = azVar;
    }

    public void a(bd bdVar) {
        this.aOt = bdVar;
    }

    public void b(bd bdVar) {
        this.aOu = bdVar;
    }

    public az bZI() {
        return this.aOs;
    }

    public bd bZJ() {
        return this.aOt;
    }

    public bd bZK() {
        return this.aOu;
    }

    public av bZL() {
        return this.haq;
    }

    public bb bZM() {
        return this.har;
    }

    public bc bZN() {
        return this.has;
    }
}
