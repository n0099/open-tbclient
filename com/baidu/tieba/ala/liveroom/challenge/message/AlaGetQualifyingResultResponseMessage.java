package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.data.ak;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetQualifyingResultResponseMessage extends JsonHttpResponsedMessage {
    private int hab;
    private boolean hac;
    private int had;
    private int hae;
    private String haf;

    public AlaGetQualifyingResultResponseMessage() {
        super(1021209);
        this.hab = 0;
        this.hac = false;
        this.had = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        ak akVar;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (akVar = com.baidu.live.aa.a.Ph().bms) != null && akVar.aLL != null) {
            this.hac = akVar.aLL.aOG;
            if (this.hac) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("season_info");
                if (optJSONObject2 != null) {
                    this.hab = 1;
                    this.haf = optJSONObject2.optString("show_last_time");
                    if (this.haf == null || this.haf.isEmpty()) {
                        this.had = 0;
                        return;
                    } else {
                        this.had = 1;
                        return;
                    }
                }
                this.hab = 0;
                return;
            }
            this.hab = 0;
        }
    }

    public boolean bZi() {
        return this.hab == 1;
    }

    public boolean bZj() {
        return this.had == 1;
    }

    public long bZk() {
        try {
            this.hae = Integer.parseInt(this.haf);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.hae * 1000;
    }
}
