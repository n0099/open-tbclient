package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.al;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hjM;
    private boolean hjN;
    private int hjO;
    private int hjP;
    private String hjQ;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hjM = 0;
        this.hjN = false;
        this.hjO = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        al alVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (alVar = com.baidu.live.ae.a.RB().brA) != null && alVar.aOG != null) {
            this.hjN = alVar.aOG.aRH;
            if (this.hjN) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hjM = 1;
                    this.hjQ = optJSONObject2.optString("show_last_time");
                    if (this.hjQ == null || this.hjQ.isEmpty()) {
                        this.hjO = 0;
                        return;
                    } else {
                        this.hjO = 1;
                        return;
                    }
                }
                this.hjM = 0;
                return;
            }
            this.hjM = 0;
        }
    }

    public boolean cde() {
        return this.hjM == 1;
    }

    public boolean cdf() {
        return this.hjO == 1;
    }

    public long cdg() {
        try {
            this.hjP = Integer.parseInt(this.hjQ);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hjP * 1000;
    }
}
