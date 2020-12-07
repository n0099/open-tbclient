package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.al;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hjK;
    private boolean hjL;
    private int hjM;
    private int hjN;
    private String hjO;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hjK = 0;
        this.hjL = false;
        this.hjM = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        al alVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (alVar = com.baidu.live.ae.a.RB().brA) != null && alVar.aOG != null) {
            this.hjL = alVar.aOG.aRH;
            if (this.hjL) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hjK = 1;
                    this.hjO = optJSONObject2.optString("show_last_time");
                    if (this.hjO == null || this.hjO.isEmpty()) {
                        this.hjM = 0;
                        return;
                    } else {
                        this.hjM = 1;
                        return;
                    }
                }
                this.hjK = 0;
                return;
            }
            this.hjK = 0;
        }
    }

    public boolean cdd() {
        return this.hjK == 1;
    }

    public boolean cde() {
        return this.hjM == 1;
    }

    public long cdf() {
        try {
            this.hjN = Integer.parseInt(this.hjO);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hjN * 1000;
    }
}
