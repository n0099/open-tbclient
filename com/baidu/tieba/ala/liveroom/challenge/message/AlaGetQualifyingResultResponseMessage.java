package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.aj;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int gUq;
    private boolean gUr;
    private int gUs;
    private int gUt;
    private String gUu;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.gUq = 0;
        this.gUr = false;
        this.gUs = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        aj ajVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (ajVar = com.baidu.live.z.a.Pq().bmJ) != null && ajVar.aMw != null) {
            this.gUr = ajVar.aMw.aPu;
            if (this.gUr) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.gUq = 1;
                    this.gUu = optJSONObject2.optString("show_last_time");
                    if (this.gUu == null || this.gUu.isEmpty()) {
                        this.gUs = 0;
                        return;
                    } else {
                        this.gUs = 1;
                        return;
                    }
                }
                this.gUq = 0;
                return;
            }
            this.gUq = 0;
        }
    }

    public boolean bXn() {
        return this.gUq == 1;
    }

    public boolean bXo() {
        return this.gUs == 1;
    }

    public long bXp() {
        try {
            this.gUt = Integer.parseInt(this.gUu);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.gUt * 1000;
    }
}
