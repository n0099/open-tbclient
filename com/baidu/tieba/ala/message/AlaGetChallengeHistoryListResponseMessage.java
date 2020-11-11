package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.a;
import com.baidu.tieba.ala.data.n;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetChallengeHistoryListResponseMessage extends JsonHttpResponsedMessage {
    public ArrayList<a> gaK;
    public n hyf;

    public AlaGetChallengeHistoryListResponseMessage() {
        super(1021118);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("history_list");
            if (optJSONArray != null) {
                this.gaK = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a aVar = new a();
                    aVar.parseJson(optJSONObject);
                    this.gaK.add(aVar);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_pk_info");
            if (optJSONObject2 != null) {
                this.hyf = new n();
                this.hyf.parseJson(optJSONObject2);
            }
        }
    }
}
