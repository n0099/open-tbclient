package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaChallengeLatestListResponseMessage extends JsonHttpResponsedMessage {
    private List<d> bep;

    public AlaChallengeLatestListResponseMessage() {
        super(1021203);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() != 0) {
            this.bep = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    d dVar = new d();
                    dVar.parseJson(optJSONObject);
                    this.bep.add(dVar);
                }
            }
        }
    }

    public List<d> ccW() {
        return this.bep;
    }
}
