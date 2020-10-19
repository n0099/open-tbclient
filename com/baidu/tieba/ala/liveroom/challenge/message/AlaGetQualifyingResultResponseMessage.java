package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ag;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int gIB;
    private boolean gIC;
    private int gID;
    private int gIE;
    private String gIF;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.gIB = 0;
        this.gIC = false;
        this.gID = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ag agVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (agVar = com.baidu.live.x.a.OS().blo) != null && agVar.aLS != null) {
            this.gIC = agVar.aLS.aOP;
            if (this.gIC) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.gIB = 1;
                    this.gIF = optJSONObject2.optString("show_last_time");
                    if (this.gIF == null || this.gIF.isEmpty()) {
                        this.gID = 0;
                        return;
                    } else {
                        this.gID = 1;
                        return;
                    }
                }
                this.gIB = 0;
                return;
            }
            this.gIB = 0;
        }
    }

    public boolean bUo() {
        return this.gIB == 1;
    }

    public boolean bUp() {
        return this.gID == 1;
    }

    public long bUq() {
        try {
            this.gIE = Integer.parseInt(this.gIF);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.gIE * 1000;
    }
}
