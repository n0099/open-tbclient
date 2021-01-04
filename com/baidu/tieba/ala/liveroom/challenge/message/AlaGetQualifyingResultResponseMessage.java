package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.an;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hvH;
    private boolean hvI;
    private int hvJ;
    private int hvK;
    private String hvL;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hvH = 0;
        this.hvI = false;
        this.hvJ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        an anVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (anVar = com.baidu.live.af.a.SE().bwi) != null && anVar.aPn != null) {
            this.hvI = anVar.aPn.aSw;
            if (this.hvI) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hvH = 1;
                    this.hvL = optJSONObject2.optString("show_last_time");
                    if (this.hvL == null || this.hvL.isEmpty()) {
                        this.hvJ = 0;
                        return;
                    } else {
                        this.hvJ = 1;
                        return;
                    }
                }
                this.hvH = 0;
                return;
            }
            this.hvH = 0;
        }
    }

    public boolean cfU() {
        return this.hvH == 1;
    }

    public boolean cfV() {
        return this.hvJ == 1;
    }

    public long cfW() {
        try {
            this.hvK = Integer.parseInt(this.hvL);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hvK * 1000;
    }
}
