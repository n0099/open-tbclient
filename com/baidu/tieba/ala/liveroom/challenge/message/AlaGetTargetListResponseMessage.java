package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetTargetListResponseMessage extends JsonHttpResponsedMessage {
    private b eQF;
    private List<d> eQG;

    public AlaGetTargetListResponseMessage() {
        super(1021105);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("page");
            if (optJSONObject2 != null) {
                this.eQF = new b();
                this.eQF.parseJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eQG = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.parseJson(optJSONArray.optJSONObject(i2));
                    this.eQG.add(dVar);
                }
            }
        }
    }

    public b biD() {
        return this.eQF;
    }

    public List<d> biE() {
        return this.eQG;
    }
}
