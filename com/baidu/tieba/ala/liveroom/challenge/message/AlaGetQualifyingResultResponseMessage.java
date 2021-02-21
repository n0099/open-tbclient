package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ar;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private boolean hvA;
    private int hvB;
    private int hvC;
    private String hvD;
    private int hvz;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hvz = 0;
        this.hvA = false;
        this.hvB = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ar arVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (arVar = com.baidu.live.ae.a.Qj().buX) != null && arVar.aNn != null) {
            this.hvA = arVar.aNn.aQK;
            if (this.hvA) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hvz = 1;
                    this.hvD = optJSONObject2.optString("show_last_time");
                    if (this.hvD == null || this.hvD.isEmpty()) {
                        this.hvB = 0;
                        return;
                    } else {
                        this.hvB = 1;
                        return;
                    }
                }
                this.hvz = 0;
                return;
            }
            this.hvz = 0;
        }
    }

    public boolean cdf() {
        return this.hvz == 1;
    }

    public boolean cdg() {
        return this.hvB == 1;
    }

    public long cdh() {
        try {
            this.hvC = Integer.parseInt(this.hvD);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hvC * 1000;
    }
}
