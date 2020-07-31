package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.challenge.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetChallengeMvpToastInfoResponseMessage extends JsonHttpResponsedMessage {
    public List<b> geG;
    public String toast;
    public int type;

    public GetChallengeMvpToastInfoResponseMessage() {
        super(1021199);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("sticker");
            this.geG = new ArrayList();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    b bVar = new b();
                    bVar.parse(optJSONObject2);
                    this.geG.add(bVar);
                }
            }
            this.type = optJSONObject.optInt("type");
            this.toast = optJSONObject.optString("toast");
        }
    }
}
