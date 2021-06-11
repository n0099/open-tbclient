package com.baidu.tieba.ala.alasquare.recent_history.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.v.d.e.b.a;
import d.a.n0.v.d.e.b.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecentHistoryResponseMessage extends JsonHttpResponsedMessage {
    public a mHistoryData;

    public AlaRecentHistoryResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null) {
            return;
        }
        a aVar = new a();
        this.mHistoryData = aVar;
        aVar.f65405a = jSONObject.optInt("has_more") == 1;
        ArrayList arrayList = null;
        JSONArray optJSONArray = jSONObject.optJSONArray("host_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList arrayList2 = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                b bVar = new b();
                bVar.a(optJSONArray.optJSONObject(i3));
                arrayList2.add(bVar);
            }
            arrayList = arrayList2;
        }
        this.mHistoryData.f65406b = arrayList;
    }

    public a getRecentHistoryData() {
        return this.mHistoryData;
    }
}
