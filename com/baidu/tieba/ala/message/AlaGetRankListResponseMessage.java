package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRankListResponseMessage extends JsonHttpResponsedMessage {
    public ArrayList<h> flW;
    public long gBD;

    public AlaGetRankListResponseMessage() {
        super(1021068);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                this.flW = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    h hVar = new h();
                    hVar.parserJson(optJSONObject);
                    this.flW.add(hVar);
                }
            }
            this.gBD = jSONObject.optLong("flower_reset_time", 0L);
        }
    }
}
