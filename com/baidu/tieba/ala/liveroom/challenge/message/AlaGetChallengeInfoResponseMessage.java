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
    private au aJF;
    private ay aJG;
    private ay aJH;
    private aq guc;
    private aw gud;
    private ax gue;

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
                this.aJF = new au();
                this.aJF.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("anchor_info");
            if (optJSONObject3 != null) {
                this.aJG = new ay();
                this.aJG.parseJson(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("rival_info");
            if (optJSONObject4 != null) {
                this.aJH = new ay();
                this.aJH.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("challenge_conf");
            if (optJSONObject5 != null) {
                this.guc = new aq();
                this.guc.parseJson(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("punish_info");
            if (optJSONObject6 != null) {
                this.gud = new aw();
                this.gud.parseJson(optJSONObject6);
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("punishStickerInfo");
            if (optJSONObject7 != null) {
                this.gue = new ax();
                this.gue.parseJson(optJSONObject7);
            }
        }
    }

    public void a(au auVar) {
        this.aJF = auVar;
    }

    public void a(ay ayVar) {
        this.aJG = ayVar;
    }

    public void b(ay ayVar) {
        this.aJH = ayVar;
    }

    public au bQN() {
        return this.aJF;
    }

    public ay bQO() {
        return this.aJG;
    }

    public ay bQP() {
        return this.aJH;
    }

    public aq bQQ() {
        return this.guc;
    }

    public aw bQR() {
        return this.gud;
    }

    public ax bQS() {
        return this.gue;
    }
}
