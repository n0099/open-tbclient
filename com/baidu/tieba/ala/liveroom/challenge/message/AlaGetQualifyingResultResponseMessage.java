package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ag;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int gug;
    private boolean guh;
    private int gui;
    private int guj;
    private String guk;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.gug = 0;
        this.guh = false;
        this.gui = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ag agVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (agVar = com.baidu.live.x.a.NN().bhy) != null && agVar.aIO != null) {
            this.guh = agVar.aIO.aLK;
            if (this.guh) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.gug = 1;
                    this.guk = optJSONObject2.optString("show_last_time");
                    if (this.guk == null || this.guk.isEmpty()) {
                        this.gui = 0;
                        return;
                    } else {
                        this.gui = 1;
                        return;
                    }
                }
                this.gug = 0;
                return;
            }
            this.gug = 0;
        }
    }

    public boolean bQU() {
        return this.gug == 1;
    }

    public boolean bQV() {
        return this.gui == 1;
    }

    public long bQW() {
        try {
            this.guj = Integer.parseInt(this.guk);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.guj * 1000;
    }
}
