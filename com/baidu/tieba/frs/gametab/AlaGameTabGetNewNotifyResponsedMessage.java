package com.baidu.tieba.frs.gametab;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGameTabGetNewNotifyResponsedMessage extends JsonHttpResponsedMessage {
    private List<a> mData;

    public AlaGameTabGetNewNotifyResponsedMessage() {
        super(1021074);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (!hasError() && jSONObject != null) {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int length = jSONArray.length();
            this.mData = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2 != null) {
                    this.mData.add(new a(jSONObject2.optInt("tab_id"), jSONObject2.optInt("has_new")));
                }
            }
        }
    }

    public List<a> getNewNotifyData() {
        return this.mData;
    }
}
