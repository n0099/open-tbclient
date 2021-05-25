package com.baidu.tieba.consumptionRecords;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.c0.a;
import d.a.n0.c0.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetUserOrderHttpResponseMessage extends JsonHttpResponsedMessage {
    public boolean hasMore;
    public ArrayList<a> orderList;
    public b recommendData;

    public GetUserOrderHttpResponseMessage(int i2) {
        super(i2);
        this.hasMore = false;
        this.orderList = new ArrayList<>();
    }

    private void parseOrderListData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            a aVar = new a();
            aVar.n(optJSONObject);
            this.orderList.add(aVar);
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
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
