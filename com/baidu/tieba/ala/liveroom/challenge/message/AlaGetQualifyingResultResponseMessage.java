package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hau;
    private boolean hav;
    private int haw;
    private int hax;
    private String hay;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hau = 0;
        this.hav = false;
        this.haw = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ak akVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (akVar = com.baidu.live.aa.a.PQ().bod) != null && akVar.aNw != null) {
            this.hav = akVar.aNw.aQr;
            if (this.hav) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hau = 1;
                    this.hay = optJSONObject2.optString("show_last_time");
                    if (this.hay == null || this.hay.isEmpty()) {
                        this.haw = 0;
                        return;
                    } else {
                        this.haw = 1;
                        return;
                    }
                }
                this.hau = 0;
                return;
            }
            this.hau = 0;
        }
    }

    public boolean bZP() {
        return this.hau == 1;
    }

    public boolean bZQ() {
        return this.haw == 1;
    }

    public long bZR() {
        try {
            this.hax = Integer.parseInt(this.hay);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hax * 1000;
    }
}
