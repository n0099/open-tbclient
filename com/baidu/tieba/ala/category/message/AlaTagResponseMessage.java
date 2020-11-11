package com.baidu.tieba.ala.category.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.category.b.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaTagResponseMessage extends JsonHttpResponsedMessage {
    private List<d> guF;

    public AlaTagResponseMessage() {
        super(1021191);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.guF = new ArrayList();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                d dVar = new d();
                dVar.parse(optJSONArray.getJSONObject(i2));
                this.guF.add(dVar);
            }
        }
    }

    public List<d> getTagList() {
        return this.guF;
    }
}
