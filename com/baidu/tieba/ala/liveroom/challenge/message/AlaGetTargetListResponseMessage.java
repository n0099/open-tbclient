package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetTargetListResponseMessage extends JsonHttpResponsedMessage {
    private b eVi;
    private List<d> eVj;

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
                this.eVi = new b();
                this.eVi.parseJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eVj = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.parseJson(optJSONArray.optJSONObject(i2));
                    this.eVj.add(dVar);
                }
            }
        }
    }

    public b bkB() {
        return this.eVi;
    }

    public List<d> bkC() {
        return this.eVj;
    }
}
