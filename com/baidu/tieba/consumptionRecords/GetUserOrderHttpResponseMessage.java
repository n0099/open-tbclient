package com.baidu.tieba.consumptionRecords;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetUserOrderHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean hasMore;
    private ArrayList<a> orderList;
    private b recommendData;

    public GetUserOrderHttpResponseMessage(int i) {
        super(i);
        this.hasMore = false;
        this.orderList = new ArrayList<>();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.hasMore = jSONObject.optInt("hasmore") != 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("order_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                parseOrderListData(optJSONArray);
            }
        }
    }

    private void parseOrderListData(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.parser(optJSONObject);
                this.orderList.add(aVar);
            }
        }
    }

    public ArrayList<a> getOrderList() {
        return this.orderList;
    }

    public b getRecommendInfo() {
        return this.recommendData;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }
}
