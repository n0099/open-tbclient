package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ar;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hvl;
    private boolean hvm;
    private int hvn;
    private int hvo;
    private String hvp;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hvl = 0;
        this.hvm = false;
        this.hvn = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ar arVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (arVar = com.baidu.live.ae.a.Qj().buX) != null && arVar.aNn != null) {
            this.hvm = arVar.aNn.aQK;
            if (this.hvm) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hvl = 1;
                    this.hvp = optJSONObject2.optString("show_last_time");
                    if (this.hvp == null || this.hvp.isEmpty()) {
                        this.hvn = 0;
                        return;
                    } else {
                        this.hvn = 1;
                        return;
                    }
                }
                this.hvl = 0;
                return;
            }
            this.hvl = 0;
        }
    }

    public boolean ccY() {
        return this.hvl == 1;
    }

    public boolean ccZ() {
        return this.hvn == 1;
    }

    public long cda() {
        try {
            this.hvo = Integer.parseInt(this.hvp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hvo * 1000;
    }
}
