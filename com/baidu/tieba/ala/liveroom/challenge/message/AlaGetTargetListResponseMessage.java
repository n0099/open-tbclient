package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.b;
import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetTargetListResponseMessage extends JsonHttpResponsedMessage {
    private b hjS;
    private List<d> hjT;

    public AlaGetTargetListResponseMessage() {
        super(1021105);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("page");
            if (optJSONObject2 != null) {
                this.hjS = new b();
                this.hjS.parseJson(optJSONObject2);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.hjT = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        d dVar = new d();
                        dVar.parseJson(optJSONObject3);
                        this.hjT.add(dVar);
                    }
                }
            }
        }
    }

    public b cdi() {
        return this.hjS;
    }

    public List<d> cdj() {
        return this.hjT;
    }
}
