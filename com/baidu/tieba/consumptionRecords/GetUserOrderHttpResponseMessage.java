package com.baidu.tieba.consumptionRecords;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.a0.a;
import d.b.i0.a0.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetUserOrderHttpResponseMessage extends JsonHttpResponsedMessage {
    public boolean hasMore;
    public ArrayList<a> orderList;
    public b recommendData;

    public GetUserOrderHttpResponseMessage(int i) {
        super(i);
        this.hasMore = false;
        this.orderList = new ArrayList<>();
    }

    private void parseOrderListData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            a aVar = new a();
            aVar.l(optJSONObject);
            this.orderList.add(aVar);
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.hasMore = jSONObject.optInt("hasmore") != 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("order_list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            parseOrderListData(optJSONArray);
        }
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<a> getOrderList() {
        return this.orderList;
    }

    public b getRecommendInfo() {
        return this.recommendData;
    }
}
