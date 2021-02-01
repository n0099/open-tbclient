package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetMyAssistWIshListResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<f> eVV;

    public AlaGetMyAssistWIshListResponseMessage(int i) {
        super(1021171);
        this.eVV = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                f fVar = new f();
                fVar.parserJson(optJSONArray.getJSONObject(i2));
                this.eVV.add(fVar);
            }
        }
    }

    public ArrayList<f> getData() {
        return this.eVV;
    }
}
