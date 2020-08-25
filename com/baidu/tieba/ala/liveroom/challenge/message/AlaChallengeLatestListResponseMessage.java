package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaChallengeLatestListResponseMessage extends JsonHttpResponsedMessage {
    private List<d> bjc;

    public AlaChallengeLatestListResponseMessage() {
        super(1021203);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() != 0) {
            this.bjc = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    d dVar = new d();
                    dVar.parseJson(optJSONObject);
                    this.bjc.add(dVar);
                }
            }
        }
    }

    public List<d> bPw() {
        return this.bjc;
    }
}
