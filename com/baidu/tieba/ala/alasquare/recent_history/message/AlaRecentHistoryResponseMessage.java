package com.baidu.tieba.ala.alasquare.recent_history.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alasquare.recent_history.b.a;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecentHistoryResponseMessage extends JsonHttpResponsedMessage {
    private a mHistoryData;

    public AlaRecentHistoryResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_RECENT_HISTORY_LIST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.mHistoryData = new a();
            this.mHistoryData.hasMore = jSONObject.optInt("has_more") == 1;
            ArrayList arrayList = null;
            JSONArray optJSONArray = jSONObject.optJSONArray("host_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    b bVar = new b();
                    bVar.parse(optJSONArray.optJSONObject(i2));
                    arrayList.add(bVar);
                }
            }
            this.mHistoryData.fJl = arrayList;
        }
    }

    public a getRecentHistoryData() {
        return this.mHistoryData;
    }
}
