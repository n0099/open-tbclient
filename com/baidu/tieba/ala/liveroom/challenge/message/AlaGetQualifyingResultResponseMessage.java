package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.an;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hrb;
    private boolean hrc;
    private int hrd;
    private int hre;
    private String hrf;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hrb = 0;
        this.hrc = false;
        this.hrd = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        an anVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (anVar = com.baidu.live.af.a.OJ().bru) != null && anVar.aKA != null) {
            this.hrc = anVar.aKA.aNJ;
            if (this.hrc) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hrb = 1;
                    this.hrf = optJSONObject2.optString("show_last_time");
                    if (this.hrf == null || this.hrf.isEmpty()) {
                        this.hrd = 0;
                        return;
                    } else {
                        this.hrd = 1;
                        return;
                    }
                }
                this.hrb = 0;
                return;
            }
            this.hrb = 0;
        }
    }

    public boolean ccd() {
        return this.hrb == 1;
    }

    public boolean cce() {
        return this.hrd == 1;
    }

    public long ccf() {
        try {
            this.hre = Integer.parseInt(this.hrf);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hre * 1000;
    }
}
