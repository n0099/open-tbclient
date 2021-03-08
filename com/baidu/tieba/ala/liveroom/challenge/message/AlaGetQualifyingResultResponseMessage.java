package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ar;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hxi;
    private boolean hxj;
    private int hxk;
    private int hxl;
    private String hxm;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hxi = 0;
        this.hxj = false;
        this.hxk = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ar arVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (arVar = com.baidu.live.ae.a.Qm().bwx) != null && arVar.aON != null) {
            this.hxj = arVar.aON.aSk;
            if (this.hxj) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hxi = 1;
                    this.hxm = optJSONObject2.optString("show_last_time");
                    if (this.hxm == null || this.hxm.isEmpty()) {
                        this.hxk = 0;
                        return;
                    } else {
                        this.hxk = 1;
                        return;
                    }
                }
                this.hxi = 0;
                return;
            }
            this.hxi = 0;
        }
    }

    public boolean cdl() {
        return this.hxi == 1;
    }

    public boolean cdm() {
        return this.hxk == 1;
    }

    public long cdn() {
        try {
            this.hxl = Integer.parseInt(this.hxm);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hxl * 1000;
    }
}
