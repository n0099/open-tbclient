package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetDirectChallengeListResponseMessage extends JsonHttpResponsedMessage {
    private List<d> geC;
    private int mCount;

    public AlaGetDirectChallengeListResponseMessage() {
        super(1021108);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.mCount = optJSONObject.optInt("count");
            JSONArray optJSONArray = optJSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.geC = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        d dVar = new d();
                        dVar.parseJson(optJSONObject2);
                        this.geC.add(dVar);
                    }
                }
            }
        }
    }

    public int getCount() {
        return this.mCount;
    }

    public List<d> bFY() {
        return this.geC;
    }
}
