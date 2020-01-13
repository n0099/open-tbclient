package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.a;
import com.baidu.tieba.ala.data.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetChallengeHistoryListResponseMessage extends JsonHttpResponsedMessage {
    public ArrayList<a> efl;
    public k fmq;

    public AlaGetChallengeHistoryListResponseMessage() {
        super(1021118);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("history_list");
            if (optJSONArray != null) {
                this.efl = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    a aVar = new a();
                    aVar.parseJson(optJSONObject);
                    this.efl.add(aVar);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_pk_info");
            if (optJSONObject2 != null) {
                this.fmq = new k();
                this.fmq.parseJson(optJSONObject2);
            }
        }
    }
}
