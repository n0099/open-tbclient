package com.baidu.tieba.frs.gametab;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.k0.q0.x1.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGameTabGetNewNotifyResponsedMessage extends JsonHttpResponsedMessage {
    public List<a> mData;

    public AlaGameTabGetNewNotifyResponsedMessage() {
        super(1021074);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (hasError() || jSONObject == null) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("data");
        int length = jSONArray.length();
        this.mData = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (jSONObject2 != null) {
                this.mData.add(new a(jSONObject2.optInt("tab_id"), jSONObject2.optInt("has_new")));
            }
        }
    }

    public List<a> getNewNotifyData() {
        return this.mData;
    }
}
